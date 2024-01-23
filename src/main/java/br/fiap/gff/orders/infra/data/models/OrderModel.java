package br.fiap.gff.orders.infra.data.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class OrderModel {

    @Id
    private String id;

    private Long customerId;

    private List<ItemModel> items;

    private Boolean paid;
}
