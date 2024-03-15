package br.fiap.gff.orders.infra.database.adapters;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.domain.ports.OrderDatabasePort;
import br.fiap.gff.orders.infra.database.mappers.OrderMapper;
import br.fiap.gff.orders.infra.database.models.OrderModel;
import br.fiap.gff.orders.infra.database.repositories.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDatabaseAdapter extends BaseDatabaseAdapter<Order, OrderModel> implements OrderDatabasePort {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderDatabaseAdapter(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId).stream().map(mapper::fromModel).toList();
    }

}
