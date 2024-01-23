package br.fiap.gff.orders.domain.order;

import java.util.List;

import br.fiap.gff.orders.domain.order.dto.RequestOrderDTO;

public interface OrderUseCase {
    Order create(RequestOrderDTO dto);

    Order update(String id, RequestOrderDTO dto);

    void deleteById(String id);

    Order findById(String id);

    List<Order> findByCustomerId(Long customerId);

    List<Order> findAll();
}
