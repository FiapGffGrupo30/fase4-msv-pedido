package br.fiap.gff.orders.infra.database.mappers;

import br.fiap.gff.orders.domain.entities.Item;
import br.fiap.gff.orders.infra.database.models.ItemModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends MapperFactory<Item, ItemModel> {

}
