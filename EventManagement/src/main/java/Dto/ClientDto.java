package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDto {

    private int clientId;
    private String clientName;
    private String companyName;
    private String email;
    private long phoneNumber;
    private String address;
    private String city;
    private String state;
    private String pincode;

}

