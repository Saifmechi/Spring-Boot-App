package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Client;

public interface ClientInterface {

    Client saveClient(Client client);
    Client updateClient(Long id, Client client);
    void deleteClientById(Long id);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client getClientByEmail(String email);
}
