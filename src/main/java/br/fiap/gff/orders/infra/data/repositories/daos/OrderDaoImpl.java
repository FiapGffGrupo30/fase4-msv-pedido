package br.fiap.gff.orders.infra.data.repositories.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import br.fiap.gff.orders.domain.order.Order;
import br.fiap.gff.orders.domain.order.OrderDAO;
import br.fiap.gff.orders.infra.data.mappers.OrderMapper;
import br.fiap.gff.orders.infra.data.models.OrderModel;
import br.fiap.gff.orders.infra.data.repositories.OrderRepository;

@Component
public class OrderDaoImpl extends BaseDaoImpl<Order, OrderModel> implements OrderDAO {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderDaoImpl(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId).stream().map(mapper::fromModel).toList();
    }

}
