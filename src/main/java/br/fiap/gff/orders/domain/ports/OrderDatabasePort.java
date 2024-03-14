package br.fiap.gff.orders.domain.ports;

import java.util.List;

import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.infra.shared.contracts.BaseDatabasePort;

public interface OrderDatabasePort extends BaseDatabasePort<Order> {
    List<Order> findByCustomerId(Long customerId);
}
