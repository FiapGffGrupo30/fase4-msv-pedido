package br.fiap.gff.orders.infra.database.repositories;

import br.fiap.gff.orders.infra.database.models.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, String> {
    List<OrderModel> findByCustomerId(Long customerId);
}
