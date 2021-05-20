package ut.set.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ut.set.sn.exception.EmployerFoundException;
import ut.set.sn.modeles.Employer;
import ut.set.sn.repo.EmployerRepository;

@Service
public class EmployerService {
	private EmployerRepository employerRepo;

	@Autowired
	public EmployerService(EmployerRepository employerRpo) {
		// TODO Auto-generated constructor stub
		this.employerRepo = employerRpo;
	}

	public Employer ajouterEmployer(Employer emp) {
		return employerRepo.save(emp);

	}

	public List<Employer> getAllEmployer() {
		return employerRepo.findAll();

	}

	public void supprimerEmployer(Long id) {
		employerRepo.deleteById(id);
	}

	public Employer trouverEmployerById(Long id) {
		return employerRepo.findById(id)
				.orElseThrow(() -> new EmployerFoundException("Employer avec id" + id + "non trouvé !!!"));
	}

	public Employer updateEmployer(Employer emp) {
		return employerRepo.save(emp);

	}
}