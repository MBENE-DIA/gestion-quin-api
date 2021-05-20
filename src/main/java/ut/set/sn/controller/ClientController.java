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
import ut.set.sn.modeles.Client;
import ut.set.sn.modeles.UserModel;
import ut.set.sn.repo.ClientRepository;
import ut.set.sn.repo.UserRepository;
import ut.set.sn.service.ClientService;
/*@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/client")
public class ClientController {

	ClientService clientSrv;

	public ClientController(ClientService clSrv) {
		   this.clientSrv = clSrv;
	    	
			// TODO Auto-generated constructor stub
		}
    @GetMapping(path = "/tous")
    //@PreAuthorize("hasAuthority('categorie:list')")
	public ResponseEntity<List<Client>> getAlls(){
		List<Client> clients = clientSrv.getAllClients();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
		
	}

    @GetMapping(path = "/find/{id}")
  //  @PreAuthorize("hasAuthority('categorie:view')")
	public ResponseEntity<Client> findById(@PathVariable("id") Long id){
		Client cl = clientSrv.trouverClientById(id);
		return new ResponseEntity<Client>(cl, HttpStatus.OK);
		
	}

}*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired ClientRepository repository;
	
	@Autowired UserRepository userRepo;
	
	@GetMapping("/clients")
	public List<Client> getAllClientt() {
		System.out.println("Get all clients...");

		List<Client> clients = new ArrayList<>();
		repository.findAll().forEach(clients::add);
		
		return clients;
	}

	@PostMapping("/client")
	public Client ajouterClient(@RequestBody Client cl){
		Client newCl = repository.save(cl) ; 
		return newCl;
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long Id)
			throws ClientFoundException {
		Client client = repository.findById(Id)
				.orElseThrow(() -> new ClientFoundException("client non trouvé  :: " + Id));
		return ResponseEntity.ok().body(client);
	}

	
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteAssistant(@PathVariable(value = "id") Long AssistantId)
			throws ClientFoundException {
		Client client = repository.findById(AssistantId)
				.orElseThrow(() -> new ClientFoundException("Client non trouvé :: " + AssistantId));
		repository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	@DeleteMapping("/clients/delete")
	public ResponseEntity<String> deleteAllassistants() {
		System.out.println("Delete All assistant...");
		repository.deleteAll();
		return new ResponseEntity<>("tout les clients ont été supprimer de la base ", HttpStatus.OK);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateAssistant(@PathVariable("id") Long id, @RequestBody Client Client) {
		System.out.println("Update Article with ID = " + id + "...");
		Optional<Client> clientInfo = repository.findById(id);
		if (clientInfo.isPresent()) {
			Client client = clientInfo.get();
			client.setAdresse( client.getAdresse()   );
			client.setNom( client.getNom()   );
			client.setPrenom( client.getPrenom()   );
			client.setTelephone(client.getTelephone());
			
			return new ResponseEntity<>(repository.save(client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/clients/user/{email}")
	public ResponseEntity<Client> getClientByEmail(@PathVariable(value = "email") String email)
			throws ClientFoundException {
		System.out.println("user " + email);
		Optional<UserModel> user = userRepo.findByEmail(email);

		Client assistant = repository.findByUser(user)
				.orElseThrow(() -> new ClientFoundException("client non trouvé  :: " + user.toString()));
		return ResponseEntity.ok().body(assistant);
	}
}