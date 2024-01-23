package br.fiap.gff.orders.domain.order;

import java.util.List;

import org.springframework.stereotype.Service;

import br.fiap.gff.orders.domain.order.dto.RequestOrderDTO;
import br.fiap.gff.orders.domain.order.exceptions.OrderNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {
    private final OrderDAO dao;

    @Override
    public Order create(RequestOrderDTO dto) {
        return dao.save(dto.toOrder());
    }

    @Override
    public Order update(String id, RequestOrderDTO dto) {
        Order order = findById(id);
        Order updatedOrder = order.updateTo(dto.toOrder());
        return dao.save(updatedOrder);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }

    @Override
    public Order findById(String id) {
        return dao.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found!"));
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return dao.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
}
