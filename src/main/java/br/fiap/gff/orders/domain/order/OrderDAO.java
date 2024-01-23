package br.fiap.gff.orders.domain.order;

import java.util.List;

import br.fiap.gff.orders.shared.contracts.BaseDAO;

public interface OrderDAO extends BaseDAO<Order> {
    List<Order> findByCustomerId(Long customerId);
}
