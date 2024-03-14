package br.fiap.gff.orders.infra.database.mappers;

public interface MapperFactory<E, M> {
    E fromModel(M model);

    M toModel(E entity);
}
