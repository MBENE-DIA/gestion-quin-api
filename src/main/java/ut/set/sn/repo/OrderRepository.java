package ut.set.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ut.set.sn.modeles.Order;
@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {

}
