package order.service.server.controller;

import order.service.server.entity.Customer;
import order.service.server.service.AbstractService;
import order.service.server.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController<Customer> {

    private CustomerService customerService;

    public CustomerController(AbstractService<Customer> service, CustomerService customerService) {
        super(service);
        this.customerService = customerService;
    }
}
