package br.fiap.gff.orders.infra.data.mappers;

import org.mapstruct.Mapper;

import br.fiap.gff.orders.domain.items.Item;
import br.fiap.gff.orders.infra.data.models.ItemModel;

@Mapper(componentModel = "spring")
public interface ItemMapper extends MapperFactory<Item, ItemModel> {

}
