package ut.set.sn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Gerant;
import ut.set.sn.modeles.UserModel;
@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long> {
Optional<Gerant> findByUser(UserModel user);
	
	Optional<Gerant> findByUser(Optional<UserModel> user);

}
