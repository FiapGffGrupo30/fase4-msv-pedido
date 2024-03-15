package br.fiap.gff.orders.domain.ports;

import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.infra.shared.contracts.BaseDatabasePort;

public interface CategoryDatabasePort extends BaseDatabasePort<Category> {
}
