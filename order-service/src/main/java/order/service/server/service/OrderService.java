package order.service.server.service;

import order.service.server.entity.Order;
import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends AbstractService<Order> {
    public OrderService(MongoRepository<Order, String> repository) {
        super(repository);
    }

}


