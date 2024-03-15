package br.fiap.gff.orders.domain.entities;

import br.fiap.gff.orders.infra.shared.utils.Coalesce;
import lombok.Builder;

@Builder(toBuilder = true)
public record Product(
        String id,
        String name,
        String description,
        Double price,
        Long stock,
        String categoryId
) {

    public Product updateTo(Product newProduct) {
        String name = Coalesce.of(newProduct.name, this.name);
        String description = Coalesce.of(newProduct.description, this.description);
        Double price = Coalesce.of(newProduct.price, this.price);
        Long stock = Coalesce.of(newProduct.stock, this.stock);
        String categoryId = Coalesce.of(newProduct.categoryId, this.categoryId);
        return this.toBuilder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .categoryId(categoryId)
                .build();
    }
}
