package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ut.set.sn.exception.LivraisonFoundException;
import ut.set.sn.modeles.Livraison;
import ut.set.sn.repo.LivraisonRepository;

@Service
public class LivraisonService {
	private LivraisonRepository livraisonRepo;

	@Autowired
	public LivraisonService(LivraisonRepository livRepo) {
		// TODO Auto-generated constructor stub
		this.livraisonRepo = livRepo;
	}

	public Livraison ajouterLivraison(Livraison liv) {
		return livraisonRepo.save(liv);

	}

	public List<Livraison> getAllLivraison() {
		return livraisonRepo.findAll();

	}

	public void supprimerLivraison(Long id) {
		livraisonRepo.deleteById(id);
	}

	public Livraison trouverLivraisonById(Long id) {
		return livraisonRepo.findById(id)
				.orElseThrow(() -> new LivraisonFoundException("Livraison avec id" + id + "non trouvé !!!"));
	}

	public Livraison updateLivraision(Livraison liv) {
		return livraisonRepo.save(liv);

	}
}