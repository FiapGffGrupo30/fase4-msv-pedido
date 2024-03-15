package br.fiap.gff.orders.application.services;

import br.fiap.gff.orders.domain.entities.Product;
import br.fiap.gff.orders.domain.exceptions.ProductNotFoundException;
import br.fiap.gff.orders.domain.ports.ProductDatabasePort;
import br.fiap.gff.orders.domain.usecases.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductDatabasePort databasePort;

    @Override
    public Product create(Product product) {
        return databasePort.save(product);
    }

    @Override
    public Product update(String id, Product newProduct) {
        Product oldProduct = findById(id);
        Product updatedProduct = oldProduct.updateTo(newProduct);
        return databasePort.save(updatedProduct);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        databasePort.deleteById(id);
    }

    @Override
    public Product findById(String id) {
        return databasePort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        return databasePort.findAll();
    }
}
