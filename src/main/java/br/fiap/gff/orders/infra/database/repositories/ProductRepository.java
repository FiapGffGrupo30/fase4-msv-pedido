package br.fiap.gff.orders.infra.database.repositories;

import br.fiap.gff.orders.infra.database.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {
}
