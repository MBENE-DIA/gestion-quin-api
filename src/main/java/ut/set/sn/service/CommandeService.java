package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ut.set.sn.exception.CommandeFoundException;
import ut.set.sn.modeles.Commande;
import ut.set.sn.repo.CommandeRepo;


@Service
public class CommandeService {
	private CommandeRepo commandeRepo;

	@Autowired
	public CommandeService(CommandeRepo commandeRe) {
		// TODO Auto-generated constructor stub
		this.commandeRepo = commandeRe;
	}

	public Commande ajouterCommande(Commande commande) {
		return commandeRepo.save(commande);

	}

	public List<Commande> getAllCommandes() {
		return commandeRepo.findAll();

	}

	public void supprimerCommande(Long id) {
		commandeRepo.deleteById(id);
	}

	public Commande trouverCommandeById(Long id) {
		return commandeRepo.findById(id)
				.orElseThrow(() -> new CommandeFoundException("Commande avec id" + id + "non trouvé !!!"));
	}

	public Commande updateCommande(Commande com) {
		return commandeRepo.save(com);

	}
}

