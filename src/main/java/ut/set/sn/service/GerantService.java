package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.set.sn.exception.GerantFounException;
import ut.set.sn.modeles.Gerant;
import ut.set.sn.repo.GerantRepository;

/*public class GerantService {

	public GerantService() {
		// TODO Auto-generated constructor stub
	}

}*/
@Service
public class GerantService {
	private GerantRepository gerantRepo;

	@Autowired
	public GerantService(GerantRepository gerantRepo) {
		// TODO Auto-generated constructor stub
		this.gerantRepo = gerantRepo;
	}

	public Gerant ajouterGerant(Gerant emp) {
		return gerantRepo.save(emp);

	}

	public List<Gerant> getAllGerant() {
		return gerantRepo.findAll();

	}

	public void supprimerGerant(Long id) {
		gerantRepo.deleteById(id);
	}

	public Gerant trouverGerantById(Long id) {
		return gerantRepo.findById(id)
				.orElseThrow(() -> new GerantFounException("Employer avec id" + id + "non trouvé !!!"));
	}

	public Gerant updateGerant(Gerant emp) {
		return gerantRepo.save(emp);

	}
}
