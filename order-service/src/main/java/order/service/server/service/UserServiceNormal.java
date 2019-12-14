package order.service.server.service;

import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceNormal {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {return userRepository.findAll();};

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User create(User user) { return userRepository.insert(user);}

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User currentUser){
        User user = findById(currentUser.getId());
        update(user, currentUser);
        return userRepository.save(user);
    }

    private void update(User newUser, User currentUser){
        newUser.setName(currentUser.getName());
        newUser.setEmail(currentUser.getEmail());
    }

}
