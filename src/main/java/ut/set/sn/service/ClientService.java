package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.set.sn.exception.ClientFoundException;

import ut.set.sn.modeles.Client;
import ut.set.sn.repo.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepo;

	@Autowired
	public ClientService(ClientRepository clientRepo) {
		// TODO Auto-generated constructor stub
		this.clientRepo = clientRepo;
	}

	public List<Client> getAllClients() {
		return clientRepo.findAll();

	}

	public Client trouverClientById(Long id) {
		return clientRepo.findById(id)
				.orElseThrow(() -> new ClientFoundException("Client avec id" + id + "non trouvé !!!"));
	}

}
