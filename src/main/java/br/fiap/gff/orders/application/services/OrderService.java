package br.fiap.gff.orders.application.services;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.domain.exceptions.OrderNotFoundException;
import br.fiap.gff.orders.domain.ports.OrderDatabasePort;
import br.fiap.gff.orders.domain.usecases.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderDatabasePort databasePort;

    @Override
    public Order create(Order order) {
        return databasePort.save(order);
    }

    @Override
    public Order update(String id, Order newOrder) {
        Order order = findById(id);
        Order updatedOrder = order.updateTo(newOrder);
        return databasePort.save(updatedOrder);
    }

    @Override
    public void deleteById(String id) {
        databasePort.deleteById(id);
    }

    @Override
    public Order findById(String id) {
        return databasePort.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found!"));
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return databasePort.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findAll() {
        return databasePort.findAll();
    }
}
