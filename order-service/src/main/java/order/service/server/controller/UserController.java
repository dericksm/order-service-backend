package order.service.server.controller;

import order.service.server.entity.User;
import order.service.server.service.AbstractService;
import order.service.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User> {

    private UserService userServiceAb;

    public UserController(AbstractService<User> service, UserService userServiceAb) {
        super(service);
        this.userServiceAb = userServiceAb;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) throws Exception {
        User find = userServiceAb.findByEmail(user);
        if(find.getPassword().equals(user.getPassword())){
            return true;
        } else {
            return false;
        }
    }



}
