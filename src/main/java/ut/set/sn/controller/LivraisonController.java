package ut.set.sn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;


import ut.set.sn.modeles.Livraison;

import ut.set.sn.repo.LivraisonRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LivraisonController {

	@Autowired LivraisonRepository repository;
	
	
	@GetMapping("/livraisons")
	public List<Livraison> getAllLives() {
		System.out.println("Get all clients...");

		List<Livraison> lives = new ArrayList<>();
		repository.findAll().forEach(lives::add);
		
		return lives;
	}
}


	
	


/*@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
//LivraisonController
public class LivraisonController {
	LivraisonService livraisionSrv;
	LivraisonRepository repository;

   public LivraisonController(LivraisonService livSrv) {
	   this.livraisionSrv = livSrv;
    	
		// TODO Auto-generated constructor stub
	}

    @GetMapping(path = "/lives")
    //@PreAuthorize("hasAuthority('livraison:list')")
	public ResponseEntity<List<Livraison>> getAlls(){
		List<Livraison> livraisions = livraisionSrv.getAllLivraison();
		return new ResponseEntity<List<Livraison>>(livraisions, HttpStatus.OK);
		
	}
   @GetMapping("/livraisons")
	public List<Livraison> getAllLivraison() {
		System.out.println("Get all livraison...");

		List<Livraison> lives = new ArrayList<>();
		repository.findAll().forEach(lives::add);
		
		return lives;
	}
   @GetMapping("/livraison/{id}")
	public ResponseEntity<Livraison> getClientById(@PathVariable(value = "id") Long Id)
			throws LivraisonFoundException {
		Livraison livs = repository.findById(Id)
				.orElseThrow(() -> new LivraisonFoundException("employer non trouvé  :: " + Id));
		return ResponseEntity.ok().body(livs);
	}

    @GetMapping(path = "/find/{id}")
    //@PreAuthorize("hasAuthority('livraison:view')")
	public ResponseEntity<Livraison> findById(@PathVariable("id") Long id){
		Livraison liv = livraisionSrv.trouverLivraisonById(id);
		return new ResponseEntity<Livraison>(liv, HttpStatus.OK);
		
	}
    

    @PostMapping(path = "/ajouter")
   // @PreAuthorize("hasAuthority('livraison:write')")
    public ResponseEntity<Livraison> ajouterLivraison(@RequestBody Livraison livraison){
		Livraison newLiv = livraisionSrv.ajouterLivraison(livraison);
		
		return new ResponseEntity<Livraison>(newLiv,HttpStatus.CREATED);
		
	}

    @PutMapping(path = "/update")
    //@PreAuthorize("hasAuthority('livraison:write')")
    public ResponseEntity<Livraison> miseAJourLivraison(@RequestBody Livraison liv){
		Livraison updateLiv = livraisionSrv.updateLivraision(liv);
		return new ResponseEntity<Livraison>(updateLiv, HttpStatus.OK);
		
	}

    @DeleteMapping(path = "/supprimer/{id}")
    //@PreAuthorize("hasAuthority('livraison:delete')")
    public ResponseEntity<Livraison> deleteLivraisonById(@PathVariable("id") Long id){
		 livraisionSrv.supprimerLivraison(id);
		return new ResponseEntity<Livraison>(HttpStatus.OK);
   

		
    }
    }*/