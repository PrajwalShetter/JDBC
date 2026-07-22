package Runner;

import Dto.ClientDto;
import controller.ClientController;

import java.util.Scanner;

public class ClientRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClientDto client = new ClientDto();


        System.out.println("Enter ClientName :");
        client.setClientName(sc.nextLine());

        System.out.println("Enter company name :");
        client.setCompanyName(sc.nextLine());

        System.out.println("Enter Email");
        client.setEmail(sc.nextLine());

        System.out.println("Enter PhoneNumber :");
        client.setPhoneNumber(sc.nextLong());
        sc.nextLine();

        System.out.println("Enter Address :");
        client.setAddress(sc.nextLine());

        System.out.println("Enter City :");
        client.setCity(sc.nextLine());

        System.out.println("Enter State :");
        client.setState(sc.nextLine());

        System.out.println("Enter Pincode :");
        client.setPincode(sc.nextLine());

        ClientController controller = new ClientController();
        boolean result = controller.addClient(client);

        if(result){
            System.out.println("Client added Successfully");
        }
        else {
            System.out.println("something went wrong");
        }
    }
}
