package order.service.server.service;

import order.service.server.entity.Order;
import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {return orderRepository.findAll();};

    public Order findById(String id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new NotFoundException("Order not found"));
    }

    public Order create(Order order) { return orderRepository.insert(order);}

        public Order update(Order currentUser){
        Order order = findById(currentUser.getId());
        update(order, currentUser);
        return orderRepository.save(order);
    }

    private void update(Order newUser, Order currentOrder){
        newUser.setStatus(currentOrder.getStatus());
    }

}
