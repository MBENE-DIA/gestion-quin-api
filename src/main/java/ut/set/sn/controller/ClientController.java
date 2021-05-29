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
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long ClientId)
			throws ClientFoundException {
		Client client = repository.findById(ClientId)
				.orElseThrow(() -> new ClientFoundException("Client non trouvé :: " + ClientId));
		repository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	@DeleteMapping("/clients/delete")
	public ResponseEntity<String> deleteAllClients() {
		System.out.println("Delete All Clients...");
		repository.deleteAll();
		return new ResponseEntity<>("tout les clients ont été supprimer de la base ", HttpStatus.OK);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client Client) {
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

		Client client = repository.findByUser(user)
				.orElseThrow(() -> new ClientFoundException("client non trouvé  :: " + user.toString()));
		return ResponseEntity.ok().body(client);
	}
}