package br.fiap.gff.orders.domain.usecases;

import java.util.List;

import br.fiap.gff.orders.application.dto.RequestOrderDTO;
import br.fiap.gff.orders.domain.entities.Order;

public interface OrderUseCase {
    Order create(RequestOrderDTO dto);

    Order update(String id, RequestOrderDTO dto);

    void deleteById(String id);

    Order findById(String id);

    List<Order> findByCustomerId(Long customerId);

    List<Order> findAll();
}
