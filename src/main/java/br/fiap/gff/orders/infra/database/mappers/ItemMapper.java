package br.fiap.gff.orders.infra.database.mappers;

import org.mapstruct.Mapper;

import br.fiap.gff.orders.domain.entities.Item;
import br.fiap.gff.orders.infra.database.models.ItemModel;

@Mapper(componentModel = "spring")
public interface ItemMapper extends MapperFactory<Item, ItemModel> {

}
