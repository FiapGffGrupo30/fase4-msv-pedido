package br.fiap.gff.orders.infra.database.adapters;

import br.fiap.gff.orders.domain.entities.Product;
import br.fiap.gff.orders.domain.ports.ProductDatabasePort;
import br.fiap.gff.orders.infra.database.mappers.ProductMapper;
import br.fiap.gff.orders.infra.database.models.ProductModel;
import br.fiap.gff.orders.infra.database.repositories.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductDatabaseAdapter extends BaseDatabaseAdapter<Product, ProductModel> implements ProductDatabasePort {
    public ProductDatabaseAdapter(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

}
