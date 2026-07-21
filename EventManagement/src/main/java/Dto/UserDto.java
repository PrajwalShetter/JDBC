package Dto;

import constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UserDto {

    private int userId;
    private String UserName;
    private String email;
    private String password;
    private Gender gender;
    private long phoneNumber;
    private String address;
    private LocalDateTime createdAt;


}
