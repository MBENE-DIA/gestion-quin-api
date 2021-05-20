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
import ut.set.sn.exception.EmployerFoundException;
import ut.set.sn.modeles.Employer;
import ut.set.sn.modeles.UserModel;
import ut.set.sn.repo.EmployerRepository;
import ut.set.sn.repo.UserRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployerController {

	@Autowired EmployerRepository repository;
	
	@Autowired UserRepository userRepo;
	
	@GetMapping("/employers")
	public List<Employer> getAllEmployers() {
		System.out.println("Get all clients...");

		List<Employer> employes = new ArrayList<>();
		repository.findAll().forEach(employes::add);
		
		return employes;
	}

	@PostMapping("/employer")
	public Employer ajouterEmployer(@RequestBody Employer cl){
		Employer newCl = repository.save(cl) ; 
		return newCl;
	}
	
	@GetMapping("/employer/{id}")
	public ResponseEntity<Employer> getClientById(@PathVariable(value = "id") Long Id)
			throws EmployerFoundException {
		Employer emplo = repository.findById(Id)
				.orElseThrow(() -> new EmployerFoundException("employer non trouvé  :: " + Id));
		return ResponseEntity.ok().body(emplo);
	}

	
	/*@DeleteMapping("/employers/{id}")
	public Map<String, Boolean> deleteEmployer(@PathVariable(value = "id") Long id)
			throws EmployerFoundException {
		Employer employer = repository.findById(id)
				.orElseThrow(() -> new EmployerFoundException("Employer non trouvé :: " + id));
		repository.delete(employer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
	@DeleteMapping("/employers/{id}")
	public ResponseEntity<Employer> supprimerParId(@PathVariable("id") Long id){
		repository.deleteById(id);;
		return new ResponseEntity<Employer>(HttpStatus.OK);
	}

	
	@DeleteMapping("/employers/delete")
	public ResponseEntity<String> deleteAllEmployers() {
		System.out.println("Delete All assistant...");
		repository.deleteAll();
		return new ResponseEntity<>("tout les employers ont été supprimer de la base ", HttpStatus.OK);
	}

	@PutMapping("/employers/{id}")
	public ResponseEntity<Employer> updateClient(@PathVariable("id") Long id, @RequestBody Employer Client) {
		System.out.println("Update Article with ID = " + id + "...");
		Optional<Employer> employeInfo = repository.findById(id);
		if (employeInfo.isPresent()) {
			Employer employe = employeInfo.get();
			employe.setNom( employe.getNom()   );
			employe.setPrenom( employe.getPrenom()   );
			employe.setTelephone(employe.getTelephone());
			
			return new ResponseEntity<>(repository.save(employe), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employers/user/{email}")
	public ResponseEntity<Employer> getEmployeByEmail(@PathVariable(value = "email") String email)
			throws EmployerFoundException {
		System.out.println("user " + email);
		Optional<UserModel> user = userRepo.findByEmail(email);

		Employer empl = repository.findByUser(user)
				.orElseThrow(() -> new ClientFoundException("client non trouvé  :: " + user.toString()));
		return ResponseEntity.ok().body(empl);
	}
//@RequestMapping("/api/employer")
//public class EmployerController 

/*public class EmployerController {
	EmployerService employerSrv;

   public EmployerController(EmployerService empSrv) {
	   this.employerSrv = empSrv;
    	
		// TODO Auto-generated constructor stub
	}
   @GetMapping(path = "/ajouter")
   //@PreAuthorize("hasAuthority('employer:list')")
    
	public ResponseEntity<List<Employer>> getAlls(){
		List<Employer> employers = employerSrv.getAllEmployer();
		return new ResponseEntity<List<Employer>>(employers, HttpStatus.OK);
		
	}

    @GetMapping(path = "/find/{id}")
   // @PreAuthorize("hasAuthority('employer:view')")
	public ResponseEntity<Employer> findById(@PathVariable("id") Long id){
		Employer emp = employerSrv.trouverEmployerById(id);
		return new ResponseEntity<Employer>(emp, HttpStatus.OK);
		
	}
    

    @PostMapping(path = "/ajouter")
    //@PreAuthorize("hasAuthority('employer:write')")
    public ResponseEntity<Employer> ajouterEmployer(@RequestBody Employer emp){
    	Employer newEmp = employerSrv.ajouterEmployer(emp);
		
		return new ResponseEntity<Employer>(newEmp,HttpStatus.CREATED);
		
	}

    @PutMapping(path = "/update")
   // @PreAuthorize("hasAuthority('employer:write')")
    public ResponseEntity<Employer> miseAjour(@RequestBody Employer emp){
		Employer updateEmp = employerSrv.updateEmployer(emp);
		return new ResponseEntity<Employer>(updateEmp, HttpStatus.OK);
		
	}

    @DeleteMapping(path = "/supprimer/{id}")
   // @PreAuthorize("hasAuthority('employer')")
    public ResponseEntity<Employer> deleteCommandeById(@PathVariable("id") Long id){
		 employerSrv.supprimerEmployer(id);
		return new ResponseEntity<Employer>(HttpStatus.OK);
    public Map<String, Boolean> destroy(@PathVariable("id") Long id) throws ResourceNotFoundException {
        categorieService.destroy(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/

		
    
    }

