package order.service.server.controller;

import order.service.server.entity.Equipment;
import order.service.server.service.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController extends AbstractController<Equipment> {
    public EquipmentController(AbstractService<Equipment> service) {
        super(service);
    }
}
