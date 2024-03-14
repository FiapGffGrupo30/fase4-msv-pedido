package br.fiap.gff.orders.infra.shared.contracts;

import java.util.List;
import java.util.Optional;

public interface BaseDatabasePort<E> {
    E save(E entity);

    Optional<E> findById(String id);

    List<E> findAll();

    void deleteById(String id);
}
