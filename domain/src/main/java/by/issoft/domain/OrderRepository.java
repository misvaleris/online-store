package by.issoft.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {
    @EntityGraph(value = "order-info")
    List<OrderInfo> findAll();
}
