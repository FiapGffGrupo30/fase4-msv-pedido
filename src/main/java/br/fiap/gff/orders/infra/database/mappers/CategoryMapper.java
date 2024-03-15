package br.fiap.gff.orders.infra.database.mappers;

import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.infra.database.models.CategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends MapperFactory<Category, CategoryModel> {
}
