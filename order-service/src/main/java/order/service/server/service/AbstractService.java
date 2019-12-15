package order.service.server.service;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import order.service.server.entity.AbstractEntity;
import order.service.server.exception.NotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.core.support.AbstractEntityInformation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractEntity>{

    private MongoRepository<T, String> repository;

    public AbstractService(MongoRepository<T, String> repository){
        this.repository = repository;
    }

    public List<T> findAll() {return repository.findAll();};

    public T findById(String id){
        Optional<T> entity = repository.findById(id);
        return entity.orElseThrow(() -> new NotFoundException("Entity not found"));
    }

    public T create(T entity) {
        return repository.insert(entity);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public T update(T entity) {
        T save = repository.save(entity);
        return repository.save(save);
    }

    public T get(String entity) throws NotFoundException {
        return repository.findById(entity).orElseThrow(() -> new NotFoundException("Id not found"));
    }

}



