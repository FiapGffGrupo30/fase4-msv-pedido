package br.fiap.gff.orders.infra.database.adapters;

import br.fiap.gff.orders.infra.database.mappers.MapperFactory;
import br.fiap.gff.orders.infra.shared.contracts.BaseDatabasePort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseDatabaseAdapter<E, M> implements BaseDatabasePort<E> {

    private final MongoRepository<M, String> repository;
    private final MapperFactory<E, M> mapper;

    public BaseDatabaseAdapter(MongoRepository<M, String> repository, MapperFactory<E, M> mapper) {
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
