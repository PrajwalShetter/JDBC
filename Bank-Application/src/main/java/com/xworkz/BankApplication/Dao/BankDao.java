package com.xworkz.BankApplication.Dao;

import com.xworkz.BankApplication.Dto.UserDto;
import com.xworkz.BankApplication.constant.AccountType;

import java.util.List;
import java.util.Map;

public interface BankDao {

    void register(UserDto user);

    void getDetailsByEmail(String gmail);

    boolean updateNameById( String name, int id);

    boolean updateAgeAndDobByEmail(int age, String dob, String gmail);

    boolean updateAddressByEmail(String address, String gmail);

    boolean updateMobileNoByEmail(String mobileNo, String gmail);

    boolean updateNomineeNameByName(String nomineeName, String name);

    boolean updateBalanceByAccountType(int balance, AccountType accountType);

    boolean deleteUserById(int id);

    List<UserDto> viewAllUsers();

    void getUserNameAndAccountBalanceById(int id);
}
