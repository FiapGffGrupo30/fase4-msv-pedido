package br.fiap.gff.orders.infra.data.mappers;

import org.mapstruct.Mapper;

import br.fiap.gff.orders.domain.order.Order;
import br.fiap.gff.orders.infra.data.models.OrderModel;

@Mapper(componentModel = "spring")
public interface OrderMapper extends MapperFactory<Order, OrderModel> {

}
