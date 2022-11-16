package com.example.eBooking.service;

import com.example.eBooking.model.Client;
import com.example.eBooking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client findClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = null;
        if (optionalClient.isPresent()) {
            client = optionalClient.get();
        } else {
            throw new RuntimeException("Client by " + id + " not found");
        }
        return client;
    }

    public void deleteClientById(Long id) {
            clientRepository.deleteById(id);
        }

}
