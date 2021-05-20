package ut.set.sn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ut.set.sn.modeles.Client;
import ut.set.sn.modeles.UserModel;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
Optional<Client> findByUser(Integer user);
	
	Optional<Client> findByUser(Optional<UserModel> user);

}
