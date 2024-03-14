package br.fiap.gff.orders.application.dto;

import br.fiap.gff.orders.domain.entities.Item;

public record RequestItemDTO(Long productId, String nome, Double price, Integer quantity, Long categoryId) {
    public Item toItem() {
        return new Item(productId, nome, price, quantity, categoryId);
    }
}
