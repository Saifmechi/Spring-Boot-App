package com.EMB.app_EMB.Services.Implementation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Blog;
import com.EMB.app_EMB.Entity.Client;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.ClientRepository;
import com.EMB.app_EMB.Services.Interfaces.ClientInterface;

@Service
public class ClientImpl implements ClientInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Client not found with id " + id));

        
        existingClient.setEmail(client.getEmail());
        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setTelephone(client.getTelephone());
        existingClient.setMotDePasse(client.getMotDePasse());
        existingClient.setAdresse(client.getAdresse());

        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClientById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RessourceNotFoundException("Client not found with id " + id);
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Client not found with id " + id));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    @Override
    public Client getClientByEmail(String email){
    	Optional<Client> optional=clientRepository.findByEmail(email);
    	Client client=optional.orElse(null);
    			return client;
    }
}
