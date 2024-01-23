package br.fiap.gff.orders.domain.items;

public record Item(Long productId, String nome, Double price, Integer quantity) {
}
