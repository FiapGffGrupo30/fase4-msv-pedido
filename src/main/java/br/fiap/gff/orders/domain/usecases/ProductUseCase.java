package br.fiap.gff.orders.domain.usecases;

import br.fiap.gff.orders.domain.entities.Product;

import java.util.List;

public interface ProductUseCase {
    Product create(Product product);

    Product update(String id, Product newProduct);

    void deleteById(String id);

    Product findById(String id);

    List<Product> findAll();
}
