package order.service.server.service;

import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    private final UserRepository repository;


    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public User findByEmail(User user){
        System.out.println(repository.findByEmail(user.getEmail()));
        return repository.findByEmail(user.getEmail());
    }

    @Override
    public User create(User entity) {
        User user = findByEmail(entity);
        if(user == null) return repository.save(entity);
        else {
            throw new NotFoundException("Usuário cadastrado");
        }
    }
}