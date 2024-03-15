package br.fiap.gff.orders.domain.entities;

public record Item(
        Long productId,
        String nome,
        Double price,
        Integer quantity,
        Long categoryId) {
}
