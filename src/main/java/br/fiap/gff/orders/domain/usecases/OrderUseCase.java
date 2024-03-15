package br.fiap.gff.orders.domain.usecases;

import br.fiap.gff.orders.domain.entities.Order;

import java.util.List;

public interface OrderUseCase {
    Order create(Order order);

    Order update(String id, Order newOrder);

    void deleteById(String id);

    Order findById(String id);

    List<Order> findByCustomerId(Long customerId);

    List<Order> findAll();
}
