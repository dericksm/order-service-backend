package order.service.server.service;

import order.service.server.entity.Equipment;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.EquipmentRepository;
import order.service.server.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll() {return equipmentRepository.findAll();};

    public Equipment findById(String id){
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        return equipment.orElseThrow(() -> new NotFoundException("Equipment not found"));
    }

    public Equipment create(Equipment equipment) { return equipmentRepository.insert(equipment);}

        public Equipment update(Equipment currentEquipment){
        Equipment equipment = findById(currentEquipment.getId());
        update(equipment, currentEquipment);
        return equipmentRepository.save(equipment);
    }

    public void delete(String id){
        findById(id);
        equipmentRepository.deleteById(id);
    }

    private void update(Equipment newEquipment, Equipment currentEquipment){
        newEquipment.setBrand(currentEquipment.getBrand());
        newEquipment.setName(currentEquipment.getName());
        newEquipment.setPreview(currentEquipment.getPreview());
        newEquipment.setProblem(currentEquipment.getProblem());
        newEquipment.setType(currentEquipment.getType());
    }

}
