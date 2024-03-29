package br.fiap.gff.orders.infra.data.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.fiap.gff.orders.infra.data.models.OrderModel;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, String> {
    List<OrderModel> findByCustomerId(Long customerId);
}
