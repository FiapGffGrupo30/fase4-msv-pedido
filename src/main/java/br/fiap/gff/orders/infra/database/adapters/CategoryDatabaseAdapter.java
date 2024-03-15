package br.fiap.gff.orders.infra.database.adapters;

import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.domain.ports.CategoryDatabasePort;
import br.fiap.gff.orders.infra.database.mappers.CategoryMapper;
import br.fiap.gff.orders.infra.database.models.CategoryModel;
import br.fiap.gff.orders.infra.database.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryDatabaseAdapter extends BaseDatabaseAdapter<Category, CategoryModel> implements CategoryDatabasePort {
    public CategoryDatabaseAdapter(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }
}
