package br.fiap.gff.orders.infra.database.mappers;

import org.mapstruct.Mapper;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.infra.database.models.OrderModel;

@Mapper(componentModel = "spring")
public interface OrderMapper extends MapperFactory<Order, OrderModel> {

}
