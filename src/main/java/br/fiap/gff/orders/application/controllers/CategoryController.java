package br.fiap.gff.orders.application.controllers;

import br.fiap.gff.orders.application.dto.RequestCategoryDTO;
import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.domain.usecases.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase useCase;


    @GetMapping()
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = useCase.findAll();
        return categories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Category category = useCase.findById(id);
        return category == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(RequestCategoryDTO dto) {
        Category createdCategory = useCase.create(dto.toCategory());
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/{id}")
                        .buildAndExpand(createdCategory.id()).toUri())
                .body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, RequestCategoryDTO dto) {
        Category updatedCategory = useCase.update(id, dto.toCategory(id));
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
