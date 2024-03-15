package br.fiap.gff.orders.domain.entities;

import br.fiap.gff.orders.infra.shared.utils.Coalesce;
import lombok.Builder;

@Builder(toBuilder = true)
public record Category(
        String id,
        String name,
        String description
) {

    /**
     * Updates the Category with the provided category.
     *
     * @param category the Category object to update to
     * @return the updated Category object
     */
    public Category updateTo(Category category) {
        String name = Coalesce.of(category.name, this.name);
        String description = Coalesce.of(category.description, this.description);
        return Category
                .builder()
                .id(this.id)
                .name(name)
                .description(description)
                .build();
    }

}
