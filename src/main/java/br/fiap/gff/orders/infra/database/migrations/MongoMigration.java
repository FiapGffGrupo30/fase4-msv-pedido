package br.fiap.gff.orders.infra.database.migrations;

import br.fiap.gff.orders.domain.entities.Category;
import br.fiap.gff.orders.infra.database.models.CategoryModel;
import br.fiap.gff.orders.infra.database.models.ProductModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoMigration implements ApplicationListener<ApplicationReadyEvent> {

    private final MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        if (!mongoTemplate.collectionExists("categories"))
            mongoTemplate.createCollection("categories");

        if (!mongoTemplate.collectionExists("products"))
            mongoTemplate.createCollection("products");


        Resource categoryResource = new ClassPathResource("migrations/categories.json");
        List<CategoryModel> categories = null;
        try {
            categories = new ObjectMapper().readValue(categoryResource.getInputStream(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        categories.forEach(c -> {
            if (mongoTemplate.findById(c.getId(), CategoryModel.class) == null)
                mongoTemplate.insert(c);
        });

        Resource productsResource = new ClassPathResource("migrations/products.json");
        List<ProductModel> products = null;
        try {
            products = new ObjectMapper().readValue(productsResource.getInputStream(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        products.forEach(p -> {
            if (mongoTemplate.findById(p.getId(), ProductModel.class) == null)
                mongoTemplate.insert(p);
        });
    }
}
