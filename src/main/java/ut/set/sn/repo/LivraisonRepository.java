package ut.set.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Livraison;
@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

}
