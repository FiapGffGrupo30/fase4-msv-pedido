package br.fiap.gff.orders.infra.database.mappers;

import br.fiap.gff.orders.domain.entities.Product;
import br.fiap.gff.orders.infra.database.models.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends MapperFactory<Product, ProductModel> {
}
