package br.fiap.gff.orders.domain.order.dto;

import java.util.List;

import br.fiap.gff.orders.domain.items.dto.RequestItemDTO;
import br.fiap.gff.orders.domain.order.Order;

public record RequestOrderDTO(Long customerId, List<RequestItemDTO> items) {
    public Order toOrder() {
        return new Order(null, customerId, items.stream().map(RequestItemDTO::toItem).toList(), false);
    }
}
