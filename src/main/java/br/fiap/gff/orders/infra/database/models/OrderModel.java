package br.fiap.gff.orders.infra.database.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.fiap.gff.orders.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class OrderModel {

    @Id
    private String id;

    private Long customerId;

    private List<ItemModel> items;

    private Boolean paid;

    private OrderStatus status;
}
