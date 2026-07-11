package com.xworkz.BankApplication.controller;

import com.xworkz.BankApplication.Dto.UserDto;
import com.xworkz.BankApplication.constant.AccountType;
import com.xworkz.BankApplication.service.BankService;
import com.xworkz.BankApplication.service.impl.BankServiceImpl;

import java.util.List;
import java.util.Map;

public class BankController {

    BankService service = new BankServiceImpl();
    public void register(UserDto user){
                service.register(user);

    }

    public void getDetailsByEmail(String gmail){
         service.getDetailsByEmail(gmail);
    }

    public boolean updateNameById(String name, int id){
        return service.updateNameById(name,id);
    }

    public boolean updateAgeAndDobByEmail(int age, String dob, String gmail){
        return service.updateAgeAndDobByEmail(age,dob,gmail);
    }

    public boolean updateAddressByEmail(String address, String gmail){
        return service.updateAddressByEmail(address,gmail);
    }

    public boolean updateMobileNoByEmail(String mobileNo, String gmail){
        return service.updateMobileNoByEmail(mobileNo, gmail);
    }

    public boolean updateNomineeNameByName(String nomineeName, String name){
        return service.updateNomineeNameByName(nomineeName, name);
    }

    public boolean updateBalanceByAccountType(int balance, AccountType accountType){
        return service.updateBalanceByAccountType(balance, accountType);
    }

    public boolean deleteUserById(int id){
        return service.deleteUserById(id);
    }

    public List<UserDto> viewAllUsers(){
        return service.viewAllUsers();
    }

    public void getUserNameAndAccountBalanceById(int id){
        service.getUserNameAndAccountBalanceById(id);
    }
}
