package br.fiap.gff.orders.application.dto;

import br.fiap.gff.orders.domain.entities.Product;

public record RequestProductDTO(
        String name,
        String description,
        Double price,
        Long stock,
        String categoryId) {

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .categoryId(categoryId)
                .build();
    }

    public Product toProduct(String id) {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .categoryId(categoryId)
                .build();
    }
}
