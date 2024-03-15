package br.fiap.gff.orders.domain.ports;

import br.fiap.gff.orders.domain.entities.Product;
import br.fiap.gff.orders.infra.shared.contracts.BaseDatabasePort;

public interface ProductDatabasePort extends BaseDatabasePort<Product> {
}
