package br.fiap.gff.orders.application.dto;

import java.util.List;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.domain.enums.OrderStatus;

public record RequestOrderDTO(Long customerId, List<RequestItemDTO> items) {
    public Order toOrder() {
        return new Order(null, customerId, items.stream().map(RequestItemDTO::toItem).toList(), false,
                OrderStatus.CREATED);
    }
}
