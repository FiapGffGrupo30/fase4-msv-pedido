package br.fiap.gff.orders.domain.order.dto;

import java.util.List;

import br.fiap.gff.orders.domain.items.dto.RequestItemDTO;
import br.fiap.gff.orders.domain.order.Order;
import br.fiap.gff.orders.domain.order.enums.OrderStatus;

public record RequestOrderDTO(Long customerId, List<RequestItemDTO> items) {
    public Order toOrder() {
        return new Order(null, customerId, items.stream().map(RequestItemDTO::toItem).toList(), false,
                OrderStatus.CREATED);
    }
}
