package service.impl;

import Dao.ClientDao;
import Dao.impl.ClientDaoImpl;
import Dto.ClientDto;
import service.ClientService;

public class ClientServiceImpl implements ClientService {


    ClientDao clientDao = new ClientDaoImpl();
    @Override
    public boolean addClient(ClientDto client) {

        if(client == null){
            return false;
        }

        if(client.getClientName() == null ||
                !client.getClientName().matches("^[A-Za-z ]{3,20}$")){
            System.out.println("Invalid Client Name");
            return false;
        }

        if(client.getCompanyName() == null || !client.getCompanyName().matches("^[A-Za-z0-9 .,&()_-]{3,50}$")){
            System.out.println("Invalid company name");
            return false;
        }

        if(client.getEmail() == null || !client.getEmail().matches("^[A-Za-z0-9+_.,-]+@[A-za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            System.out.println("Invalid gmail");
            return false;
        }

        if(!String.valueOf(client.getPhoneNumber()).matches("^[6-9][0-9]{9}$")){
            System.out.println("Invalid PhoneNumber");
            return false;
        }

        if (client.getAddress() == null ||
                client.getAddress().trim().length() < 10 ||
                client.getAddress().trim().length() > 200) {

            System.out.println("Invalid Address");
            return false;
        }

        if(client.getCity() == null || !client.getCity().matches("^[A-Za-z ]{7,20}")){
            System.out.println("Invalid City");
            return false;
        }

        if(client.getState() == null || !client.getState().matches("^[A-Za-z ]{7,20}")){
            System.out.println("Invalid state");
            return false;
        }

        if(client.getPincode() == null || !client.getPincode().matches("^[1-9][0-9]{5}")){
            System.out.println("Invalid pincode");
            return false;
        }
        return clientDao.addClient(client);
    }
}
