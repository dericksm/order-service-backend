package order.service.server.controller;

import order.service.server.entity.User;
import order.service.server.service.UserServiceNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserServiceNormal userServiceNormal;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userServiceNormal.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userServiceNormal.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
        User newUser = userServiceNormal.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userServiceNormal.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody User user, @PathVariable String id) {
        User updUser = user;
        updUser.setId(id);
        userServiceNormal.update(updUser);
        return ResponseEntity.noContent().build();
    }


}
