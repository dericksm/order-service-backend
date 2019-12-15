package order.service.server.service;

import order.service.server.entity.Equipment;
import order.service.server.entity.User;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.EquipmentRepository;
import order.service.server.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService  extends AbstractService<Equipment> {
    public EquipmentService(MongoRepository<Equipment, String> repository) {
        super(repository);
    }
}
