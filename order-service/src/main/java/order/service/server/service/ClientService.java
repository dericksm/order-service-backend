package order.service.server.service;

import order.service.server.entity.Client;
import order.service.server.entity.Order;
import order.service.server.exception.NotFoundException;
import order.service.server.repository.ClientRepository;
import order.service.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {return clientRepository.findAll();};

    public Client findById(String id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new NotFoundException("Client not found"));
    }

    public Client create(Client client) { return clientRepository.insert(client);}

        public Client update(Client currentClient){
        Client client = findById(currentClient.getId());
        update(client, currentClient);
        return clientRepository.save(client);
    }

    public void delete(String id){
        findById(id);
        clientRepository.deleteById(id);
    }

    private void update(Client newClient, Client currentClient){
        newClient.setDistrict(currentClient.getDistrict());
        newClient.setEmail(currentClient.getEmail());
        newClient.setName(currentClient.getName());
        newClient.setNumber(currentClient.getNumber());
        newClient.setPhone(currentClient.getPhone());
        newClient.setStreet(currentClient.getStreet());
    }

}
