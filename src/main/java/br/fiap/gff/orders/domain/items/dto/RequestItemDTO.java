package br.fiap.gff.orders.domain.items.dto;

import br.fiap.gff.orders.domain.items.Item;

public record RequestItemDTO(Long productId, String nome, Double price, Integer quantity) {
    public Item toItem() {
        return new Item(productId, nome, price, quantity);
    }
}
