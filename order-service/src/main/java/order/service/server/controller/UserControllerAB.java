package order.service.server.controller;

import order.service.server.entity.User;
import order.service.server.service.AbstractService;
import order.service.server.service.UserServiceAb;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAb")
public class UserControllerAB extends AbstractController<User> {

    private UserServiceAb userServiceAb;

    public UserControllerAB(AbstractService<User> service, UserServiceAb userServiceAb) {
        super(service);
        this.userServiceAb = userServiceAb;
    }
}
