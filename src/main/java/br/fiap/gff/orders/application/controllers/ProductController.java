package br.fiap.gff.orders.application.controllers;

import br.fiap.gff.orders.application.dto.RequestProductDTO;
import br.fiap.gff.orders.domain.entities.Product;
import br.fiap.gff.orders.domain.usecases.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase useCase;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = useCase.findAll();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        Product product = useCase.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody RequestProductDTO dto) {
        Product createdProduct = useCase.create(dto.toProduct());
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(createdProduct.id())
                .toUri()).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody RequestProductDTO dto) {
        Product updatedProduct = useCase.update(id, dto.toProduct(id));
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
