package ut.set.sn.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import ut.set.sn.exception.PoduitNotFoundException;
import ut.set.sn.modeles.Produit;
import ut.set.sn.repo.ProduitRepository;
import ut.set.sn.service.ProduitService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/produit")
//ProduitController
public class ProduitController {
	ProduitService produitSrv;
	private ProduitRepository prdRepo;
	

   public ProduitController(ProduitService prodServ) {
	   this.produitSrv = prodServ;
    	
		// TODO Auto-generated constructor stub
	}

    @GetMapping(path = "/tous")
   // @PreAuthorize("hasAuthority('produit:list')")
	public ResponseEntity<List<Produit>> getAlls(){
		List<Produit> produits = produitSrv.getAllProduit();
		List<Produit> prds = new ArrayList<Produit>();
		int i ;
		for(i=0;i<produits.size();i++) {
			Produit prod = new Produit(produits.get(i).getNom(), produits.get(i).getPrixUnitaire(),produits.get(i).getQuantite(),produits.get(i).getCategorie());
			prod.setId(produits.get(i).getId());
			prod.setType(produits.get(i).getType());
			prod.setPicByte(decompressBytes(produits.get(i).getPicByte()));
			prds.add(prod);
			
		
		
		}
		return new ResponseEntity<List<Produit>>(prds, HttpStatus.OK);
		
	}

    @GetMapping(path = "/find/{id}")
  //  @PreAuthorize("hasAuthority('produit:view')")
	public ResponseEntity<Produit> findById(@PathVariable("id") Long id){
		Produit pdr = produitSrv.trouverProduitById(id);
	
			Produit prod = new Produit(pdr.getNom(), pdr.getPrixUnitaire(),pdr.getQuantite(),pdr.getCategorie());
			prod.setId(pdr.getId());
			prod.setType(pdr.getType());
			prod.setPicByte(decompressBytes(pdr.getPicByte()));
		
		return new ResponseEntity<Produit>(prod, HttpStatus.OK);
		
	}
    

   /* @PostMapping(path = "/ajouter")
   // @PreAuthorize("hasAuthority('produit:write')")
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit prd){
		Produit newpro = produitSrv.ajouterProduit(prd);
		
		return new ResponseEntity<Produit>(newpro,HttpStatus.CREATED);
		
	}*/
    
    @PostMapping(value="/ajouter",produces= "application/json")
    public ResponseEntity<Produit> uplaodImage(@RequestParam("imageFile") MultipartFile file,@RequestParam("nom") String nom,
    		   @RequestParam("prixUnitaire") int prixUnitaire,@RequestParam("quantite") int quantite,@RequestParam("categorie") String categorie ) throws IOException {


           System.out.println("Original Image Byte Size - " + file.getBytes().length);
           Produit prod =new Produit();
           prod.setPhoto(file.getOriginalFilename());
           prod.setPicByte(compressBytes(file.getBytes()));
           prod.setType(file.getContentType());
          prod.setNom(nom);
          prod.setPrixUnitaire(prixUnitaire);
         prod.setQuantite(quantite);
          prod.setCategorie(categorie);

        Produit prd=  produitSrv.ajouterProduit(prod);
           return new ResponseEntity<Produit>(prd,HttpStatus.OK);
       }

 // compress the image bytes before storing it in the database

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);
        }
        try {

            outputStream.close();
        } catch (IOException e) {

        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {

                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();

        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
    

   @PutMapping("/update/{id}")
    //@PreAuthorize("hasAuthority('produit:write')")
    public ResponseEntity<Produit> miseAjourProduit(@PathVariable(value = "id") Long prodId, 
    @RequestBody Produit pdrr){
    Optional<Produit> pdr = prdRepo.findById(prodId);
    
   Produit prod = pdr.get();
    prod.setNom(prod.getNom());
    prod.setCategorie(prod.getCategorie());
    prod.setPhoto(prod.getPhoto());
    prod.setPrixUnitaire(prod.getPrixUnitaire());
    prod.setQuantite(prod.getQuantite());
    prod.setPicByte(prod.getPicByte());
    prod.setType(prod.getType());
  		
	return new ResponseEntity<>(prdRepo.save(prod), HttpStatus.OK);
		}
   
		
  /*@PutMapping("/update/{id}")
  public ResponseEntity<Produit> updateProduit(@RequestParam("id") Long id, 
		  @RequestParam("imageFile") MultipartFile file,@RequestParam("nom") String nom,
		   @RequestParam("prixUnitaire") int prixUnitaire,@RequestParam("quantite") int quantite,@RequestParam("categorie") String categorie ) throws IOException {
	  
		Produit pdr = produitSrv.trouverProduitById(id);
		pdr.setPhoto(file.getOriginalFilename());
		pdr.setPicByte(compressBytes(file.getBytes()));
		pdr.setType(file.getContentType());
		pdr.setNom(nom);
		pdr.setCategorie(categorie);
		pdr.setQuantite(quantite);
		Produit prNew = produitSrv.updateProduit(pdr);
		
		return new ResponseEntity<Produit>(prNew,HttpStatus.OK);
	}	*/	
		
		
	

       
    
 

    @DeleteMapping(path = "/supprimer/{id}")
    //@PreAuthorize("hasAuthority('pproduit:delete')")
    public ResponseEntity<Produit> deletProduitById(@PathVariable("id") Long id){
		 produitSrv.supprimerProduit(id);
		return new ResponseEntity<Produit>(HttpStatus.OK);
   

		
    }
    }

