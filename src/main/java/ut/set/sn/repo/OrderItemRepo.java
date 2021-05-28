package ut.set.sn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ut.set.sn.modeles.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
