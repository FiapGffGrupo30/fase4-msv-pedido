package br.fiap.gff.orders.infra.data.mappers;

public interface MapperFactory<E, M> {
    E fromModel(M model);

    M toModel(E entity);
}
