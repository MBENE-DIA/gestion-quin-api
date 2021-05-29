package ut.set.sn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ut.set.sn.modeles.Commande;
import ut.set.sn.modeles.Livraison;

import ut.set.sn.repo.LivraisonRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/livraison")
public class LivraisonController {

	@Autowired LivraisonRepository repository;
	
	
	@GetMapping("/livraisons")
	public List<Livraison> getAllLivraison() {
		System.out.println("Get all clients...");

		List<Livraison> lives = new ArrayList<>();
		repository.findAll().forEach(lives::add);
		
		return lives;
	}
	   @GetMapping(path = "/find/{id}")
	   // @PreAuthorize("hasAuthority('commande:view')")
		public ResponseEntity<Optional<Livraison>> findById(@PathVariable("id") Long id){
			Optional<Livraison> li = repository.findById(id);
			return new ResponseEntity<Optional<Livraison>>(li, HttpStatus.OK);
			
		}
	  
	
	@PostMapping(path = "/ajouter")
    //@PreAuthorize("hasAuthority('commande:write')")
    public ResponseEntity<Livraison> ajouterLivraison(@RequestBody Livraison livraison){
		
		 repository.save(livraison);
		 
		
		return new ResponseEntity<Livraison>(repository.save(livraison),HttpStatus.CREATED);
		
	}
	
	 @DeleteMapping(path = "{id}")
	   // @PreAuthorize("hasAuthority('commande:delete')")
	    public ResponseEntity<Livraison> deleteCommandeById(@PathVariable("id") Long id){
			repository.deleteById(id);
			return new ResponseEntity<Livraison>(HttpStatus.OK);
	   

			
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