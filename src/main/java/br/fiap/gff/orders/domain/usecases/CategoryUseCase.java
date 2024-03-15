package br.fiap.gff.orders.domain.usecases;

import br.fiap.gff.orders.domain.entities.Category;

import java.util.List;

public interface CategoryUseCase {

    Category create(Category category);

    Category update(String id, Category newCategory);

    void deleteById(String id);

    Category findById(String id);

    List<Category> findAll();

}
