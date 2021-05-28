package ut.set.sn.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import ut.set.sn.modeles.Commande;
import ut.set.sn.service.CommandeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/commande")
public class CommandeController {
	CommandeService commandeServ;

   public CommandeController(CommandeService cmdSrv) {
	   this.commandeServ = cmdSrv;
    	
		// TODO Auto-generated constructor stub
	}
   
   @GetMapping(path = "/tous")
   //@PreAuthorize("hasAuthority('commande:list')")
	public ResponseEntity<List<Commande>> getAlls(){
		List<Commande> commandes = commandeServ.getAllCommandes();
		return new ResponseEntity<List<Commande>>(commandes, HttpStatus.OK);
		
	}

    @GetMapping(path = "/find/{id}")
   // @PreAuthorize("hasAuthority('commande:view')")
	public ResponseEntity<Commande> findById(@PathVariable("id") Long id){
		Commande com = commandeServ.trouverCommandeById(id);
		return new ResponseEntity<Commande>(com, HttpStatus.OK);
		
	}
    
    /*public ResponseEntity<Categorie> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            categorieService
                        .trouverCategorieById(id)
        );
    }*/

    @PostMapping(path = "/ajouter")
    //@PreAuthorize("hasAuthority('commande:write')")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){
		Commande newCommande = commandeServ.ajouterCommande(commande);
		
		return new ResponseEntity<Commande>(newCommande,HttpStatus.CREATED);
		
	}

    @PutMapping(path = "/update")
   // @PreAuthorize("hasAuthority('commande:write')")
    public ResponseEntity<Commande> miseAjour(@RequestBody Commande com){
		Commande updateComande = commandeServ.updateCommande(com);
		return new ResponseEntity<Commande>(updateComande, HttpStatus.OK);
		
	}

    @DeleteMapping(path = "{id}")
   // @PreAuthorize("hasAuthority('commande:delete')")
    public ResponseEntity<Commande> deleteCommandeById(@PathVariable("id") Long id){
		 commandeServ.supprimerCommande(id);
		return new ResponseEntity<Commande>(HttpStatus.OK);
   /* public Map<String, Boolean> destroy(@PathVariable("id") Long id) throws ResourceNotFoundException {
        categorieService.destroy(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/

		
    }
    }
