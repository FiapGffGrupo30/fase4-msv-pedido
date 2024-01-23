package br.fiap.gff.orders.infra.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemModel {

    private Long productId;

    private String nome;

    private Double price;

    private Integer quantity;
}
