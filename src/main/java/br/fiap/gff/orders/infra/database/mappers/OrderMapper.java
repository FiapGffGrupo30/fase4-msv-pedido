package br.fiap.gff.orders.infra.database.mappers;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.infra.database.models.OrderModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends MapperFactory<Order, OrderModel> {

}
