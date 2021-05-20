package ut.set.sn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
  Optional<UserModel> findByEmail(String email);
	
	UserModel findOneByEmail(String email);

	Optional<UserModel> findById(Integer id);
	
	Boolean existsByEmail(String email);

}
