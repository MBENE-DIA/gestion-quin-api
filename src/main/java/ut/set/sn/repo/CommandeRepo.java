package ut.set.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Commande;
@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {

}
