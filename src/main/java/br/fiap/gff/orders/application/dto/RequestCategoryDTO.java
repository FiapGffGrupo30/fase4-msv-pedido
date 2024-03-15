package br.fiap.gff.orders.application.dto;

import br.fiap.gff.orders.domain.entities.Category;

public record RequestCategoryDTO(
        String id,
        String name,
        String description
) {
    public Category toCategory() {
        return new Category(id, name, description);
    }

    public Category toCategory(String id) {
        return new Category(id, name, description);
    }
}
