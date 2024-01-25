package br.fiap.gff.orders.domain.items.dto;

import br.fiap.gff.orders.domain.items.Item;

public record RequestItemDTO(Long productId, String nome, Double price, Integer quantity, Long categoryId) {
    public Item toItem() {
        return new Item(productId, nome, price, quantity, categoryId);
    }
}
