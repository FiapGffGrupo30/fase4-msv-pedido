package br.fiap.gff.orders.domain.usecases.services;

import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.domain.exceptions.CategoryNotFoundException;
import br.fiap.gff.orders.domain.ports.CategoryDatabasePort;
import br.fiap.gff.orders.domain.usecases.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryDatabasePort databasePort;

    @Override
    public Category create(Category category) {
        return databasePort.save(category);
    }

    @Override
    public Category update(String id, Category newCategory) {
        Category oldCategory = findById(id);
        Category updatedCategory = oldCategory.updateTo(newCategory);
        return databasePort.save(updatedCategory);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        databasePort.deleteById(id);
    }

    @Override
    public Category findById(String id) {
        return databasePort.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public List<Category> findAll() {
        return databasePort.findAll();
    }
}
