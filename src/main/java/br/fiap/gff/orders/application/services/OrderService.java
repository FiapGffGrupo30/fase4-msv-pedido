package br.fiap.gff.orders.application.services;

import java.util.List;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.domain.ports.OrderDatabasePort;
import br.fiap.gff.orders.domain.usecases.OrderUseCase;
import org.springframework.stereotype.Service;

import br.fiap.gff.orders.application.dto.RequestOrderDTO;
import br.fiap.gff.orders.domain.exceptions.OrderNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderDatabasePort databasePort;

    @Override
    public Order create(RequestOrderDTO dto) {
        return databasePort.save(dto.toOrder());
    }

    @Override
    public Order update(String id, RequestOrderDTO dto) {
        Order order = findById(id);
        Order updatedOrder = order.updateTo(dto.toOrder());
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
