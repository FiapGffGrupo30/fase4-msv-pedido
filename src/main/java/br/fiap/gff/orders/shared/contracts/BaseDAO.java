package br.fiap.gff.orders.shared.contracts;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<E> {
    E save(E entity);

    Optional<E> findById(String id);

    List<E> findAll();

    void deleteById(String id);
}
