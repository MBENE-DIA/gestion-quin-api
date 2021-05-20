package ut.set.sn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import ut.set.sn.exception.ClientFoundException;
import ut.set.sn.exception.GerantFounException;
import ut.set.sn.modeles.Client;
import ut.set.sn.modeles.Gerant;
import ut.set.sn.modeles.UserModel;
import ut.set.sn.repo.GerantRepository;
import ut.set.sn.repo.UserRepository;
import ut.set.sn.service.GerantService;

/*@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/gerant")
public class GerantController {
	GerantService gerantServ;

   public GerantController(GerantService grtSrv) {
	   this.gerantServ = grtSrv;
    	
		// TODO Auto-generated constructor stub
	}
   
   @GetMapping(path = "/ajouter")
   //@PreAuthorize("hasAuthority('commande:list')")
	public ResponseEntity<List<Gerant>> getAlls(){
		List<Gerant> gerants = gerantServ.getAllGerant();
		return new ResponseEntity<List<Gerant>>(gerants, HttpStatus.OK);
		
	}

    @GetMapping(path = "/find/{id}")
   // @PreAuthorize("hasAuthority('gerant:view')")
	public ResponseEntity<Gerant> findById(@PathVariable("id") Long id){
		Gerant ger = gerantServ.trouverGerantById(id);
		return new ResponseEntity<Gerant>(ger, HttpStatus.OK);
		
	}
    
    
    @PostMapping(path = "/ajouter")
    //@PreAuthorize("hasAuthority('commande:write')")
    public ResponseEntity<Gerant> ajouterGerant(@RequestBody Gerant ger){
		Gerant newGer = gerantServ.ajouterGerant(ger);
		
		return new ResponseEntity<Gerant>(newGer,HttpStatus.CREATED);
		
	}

    @PutMapping(path = "/update")
   // @PreAuthorize("hasAuthority('commande:write')")
    public ResponseEntity<Gerant> miseAjour(@RequestBody Gerant ger){
		Gerant updateGerant = gerantServ.updateGerant(ger);
		return new ResponseEntity<Gerant>(updateGerant, HttpStatus.OK);
		
	}

    @DeleteMapping(path = "{id}")
   // @PreAuthorize("hasAuthority('commande:delete')")
    public ResponseEntity<Gerant> deleteGerantById(@PathVariable("id") Long id){
    	gerantServ.supprimerGerant(id);
		return new ResponseEntity<Gerant>(HttpStatus.OK);
 

		
    }
    }*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GerantController {

	@Autowired
	GerantRepository repository;

	@Autowired
	UserRepository userRepo;

	@GetMapping("/admins")
	public List<Gerant> getAllGerant() {
		System.out.println("Get all admins...");

		List<Gerant> admins = new ArrayList<>();
		repository.findAll().forEach(admins::add);

		return admins;
	}

	@PostMapping("/admins")
	public Gerant ajouterAdmin(@RequestBody Gerant pd) {
		Gerant newPr = repository.save(pd);
		return newPr;
	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Gerant> getAdminById(@PathVariable(value = "id") Long Id) throws GerantFounException {
		Gerant admin = repository.findById(Id)
				.orElseThrow(() -> new GerantFounException("Admin non trouvé  :: " + Id));
		return ResponseEntity.ok().body(admin);
	}

//	@GetMapping("/admins/user/{email}")
//	public ResponseEntity<Admin> getAdminByUser(@PathVariable(value = "email") String email)
//			throws ResourceNotFoundException {
//		UserModel user = userRepo.findOneByEmail(email);
//		Admin admin = user.getAdmin();
//		return ResponseEntity.ok().body(admin);
//	}

	@DeleteMapping("/admins/{id}")
	public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long AdminId)
			throws GerantFounException {
		Gerant admin = repository.findById(AdminId)
				.orElseThrow(() -> new GerantFounException("Admin non trouvé :: " + AdminId));
		repository.delete(admin);

		Map<String, Boolean> response = new HashMap<>();
		response.put("admin supprimé", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/admins/delete")
	public ResponseEntity<String> deleteAlladmins() {
		System.out.println("Delete All admins...");
		repository.deleteAll();
		return new ResponseEntity<>("tout les admins ont été supprimer de la base ", HttpStatus.OK);
	}

	@PutMapping("/admins/{id}")
	public ResponseEntity<Gerant> updateAdmin(@PathVariable("id") Long id, @RequestBody Gerant Admin) {
		System.out.println("Update Article with ID = " + id + "...");
		Optional<Gerant> adminInfo = repository.findById(id);
		if (adminInfo.isPresent()) {
			Gerant admin = adminInfo.get();
			admin.setNom(admin.getNom());
			admin.setPrenom(admin.getPrenom());
			admin.setTelephone(admin.getTelephone());

			return new ResponseEntity<>(repository.save(admin), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping("/admins/user/{email}")
	public ResponseEntity<Gerant> getGerantByEmail(@PathVariable(value = "email") String email)
			throws ClientFoundException {
		System.out.println("user " + email);
		Optional<UserModel> user = userRepo.findByEmail(email);

		Gerant assistant = repository.findByUser(user)
				.orElseThrow(() -> new GerantFounException("admin non trouvé  :: " + user.toString()));
		return ResponseEntity.ok().body(assistant);
	}
}
































