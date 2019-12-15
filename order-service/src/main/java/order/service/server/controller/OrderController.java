package order.service.server.controller;

import order.service.server.entity.Order;
import order.service.server.service.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends  AbstractController<Order>{
    public OrderController(AbstractService<Order> service) {
        super(service);
    }
}
