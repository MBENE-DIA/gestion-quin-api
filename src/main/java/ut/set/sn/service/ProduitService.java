package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ut.set.sn.exception.ProduitFoundException;
import ut.set.sn.modeles.Produit;
import ut.set.sn.repo.ProduitRepository;

@Service
public class ProduitService {
	private ProduitRepository prdRepo;

	@Autowired
	public ProduitService(ProduitRepository prRepo) {
		// TODO Auto-generated constructor stub
		this.prdRepo = prRepo;
	}

	public Produit ajouterProduit(Produit pr) {
		return prdRepo.save(pr);

	}

	public List<Produit> getAllProduit() {
		return prdRepo.findAll();

	}

	public void supprimerProduit(Long id) {
		prdRepo.deleteById(id);
	}

	public Produit trouverProduitById(Long id) {
		return prdRepo.findById(id)
				.orElseThrow(() -> new ProduitFoundException("Produit avec id" + id + "non trouvé !!!"));
	}

	public Produit updateProduit(Produit pr) {
		return prdRepo.save(pr);

	}
}