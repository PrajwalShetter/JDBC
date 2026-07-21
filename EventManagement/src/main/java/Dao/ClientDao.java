package Dao;

import Dto.ClientDto;

public interface ClientDao {

    boolean addClient(ClientDto client);

    boolean existsById(int clientId);


}
