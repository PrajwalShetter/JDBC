package Dto;

import constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminDto {

    private  int adminId;
    private String adminName;
    private String email;
    private String password;
    private Gender gender;
    private long phoneNumber;
    private String address;

}
