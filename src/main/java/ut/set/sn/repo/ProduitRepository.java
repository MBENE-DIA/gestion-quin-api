package ut.set.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
