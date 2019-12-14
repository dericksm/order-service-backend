package order.service.server.service;

import order.service.server.entity.User;
import order.service.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAb extends AbstractService<User> {

    @Autowired
    private final UserRepository repository;

    public UserServiceAb(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

}