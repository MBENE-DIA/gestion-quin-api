package ut.set.sn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Employer;
import ut.set.sn.modeles.UserModel;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
Optional<Employer> findByUser(Integer user);
	
	Optional<Employer> findByUser(Optional<UserModel> user);

}
