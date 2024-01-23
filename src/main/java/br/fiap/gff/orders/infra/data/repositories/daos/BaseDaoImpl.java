package br.fiap.gff.orders.infra.data.repositories.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.fiap.gff.orders.infra.data.mappers.MapperFactory;
import br.fiap.gff.orders.shared.contracts.BaseDAO;

public abstract class BaseDaoImpl<E, M> implements BaseDAO<E> {

    private final MongoRepository<M, String> repository;
    private final MapperFactory<E, M> mapper;

    public BaseDaoImpl(MongoRepository<M, String> repository, MapperFactory<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll().stream().map(mapper::fromModel).toList();
    }

    @Override
    public Optional<E> findById(String id) {
        return repository.findById(id).map(mapper::fromModel);
    }

    @Override
    public E save(E entity) {
        M model = mapper.toModel(entity);
        return mapper.fromModel(repository.save(model));
    }
}
