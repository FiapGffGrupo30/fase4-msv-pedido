package br.fiap.gff.orders.infra.database.repositories;

import br.fiap.gff.orders.infra.database.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {
}
