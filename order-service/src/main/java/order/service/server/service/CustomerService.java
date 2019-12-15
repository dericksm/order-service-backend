package order.service.server.service;

import order.service.server.entity.Customer;
import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends AbstractService<Customer> {
    public CustomerService(MongoRepository<Customer, String> repository) {
        super(repository);
    }
}
