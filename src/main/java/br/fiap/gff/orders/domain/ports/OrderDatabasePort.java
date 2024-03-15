package br.fiap.gff.orders.domain.ports;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.infra.shared.contracts.BaseDatabasePort;

import java.util.List;

public interface OrderDatabasePort extends BaseDatabasePort<Order> {
    List<Order> findByCustomerId(Long customerId);
}
