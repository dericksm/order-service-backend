package order.service.server.controller;

import order.service.server.entity.AbstractEntity;
import order.service.server.entity.User;
import order.service.server.service.AbstractService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public abstract class AbstractController<T extends AbstractEntity> {

    private final AbstractService<T> service;

    public AbstractController(AbstractService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> findById(@PathVariable String id) {
        T entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody T t) {
        T entity  = service.create(t);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody T t, @PathVariable String id) {
        T entity = t;
        service.update(entity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}

