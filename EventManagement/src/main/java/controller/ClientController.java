package controller;

import Dto.ClientDto;
import service.ClientService;
import service.impl.ClientServiceImpl;

public class ClientController {
    ClientService clientService = new ClientServiceImpl();

    public boolean addClient(ClientDto client){
        return clientService.addClient(client);

    }
}
