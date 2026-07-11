package com.xworkz.BankApplication.Dto;

import com.xworkz.BankApplication.constant.AccountType;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDto {

    private String name;
    private String age;
    private String dob;
    private String gmail;
    private String address;
    private String mobileNo;
    private String nomineeName;
    private int balance;
    private AccountType accountType;
}
