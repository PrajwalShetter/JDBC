package com.xworkz.BankApplication.service.impl;

import com.xworkz.BankApplication.Dao.BankDao;
import com.xworkz.BankApplication.Dao.impl.BankDaoImpl;
import com.xworkz.BankApplication.Dto.UserDto;
import com.xworkz.BankApplication.constant.AccountType;
import com.xworkz.BankApplication.service.BankService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BankServiceImpl implements BankService {

    BankDao dao = new BankDaoImpl();

    @Override
    public void register(UserDto user) {
        boolean isuserName = false;
        boolean isdob = false;
        boolean isage = false;
        boolean isnomineeName = false;
        boolean ismobileNo = false;
        boolean isgmail = false;
        boolean isaddress = false;
        boolean isBalance = false;
        boolean isAccount = false;

        if (user != null) {
            if (user.getName() != null && user.getName().matches("^[a-zA-Z\\s]{2,50}$")) {
                isuserName = true;
            }
            if (user.getDob() != null && user.getDob().matches("^(19|20)\\d\\d-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
                isdob = true;
            }
            if (user.getAge() != null && user.getAge().matches("^(1[8-9]|[2-9][0-9])$")) {
                isage = true;
            }
            if (user.getNomineeName() != null && user.getNomineeName().matches("^[a-zA-Z\\s]{2,50}$")) {
                isnomineeName = true;
            }
            if (user.getGmail() != null && user.getGmail().matches("^[a-zA-Z0-9.]{6,30}@gmail\\.com$")) {
                isgmail = true;
            }
            if (user.getMobileNo() != null && user.getMobileNo().matches("^(?:\\+91|0)?[6-9]\\d{9}$")) {
                ismobileNo = true;
            }
            if (user.getAddress() != null && user.getAddress().matches("^[a-zA-Z0-9\\s.,#\\-\\/]{10,150}$")) {
                isaddress = true;
            }
            if (user.getBalance() >= 1000) {
                isBalance = true;
            }
            if (user.getAccountType() != null) {
                isAccount = true;
            }
        } else {
            System.out.println("User could not be null");
        }

        System.out.println("name valid :" + isuserName);
        System.out.println("dob valid :" + isdob);
        System.out.println("age valid :" + isage);
        System.out.println("nomineeName valid :" + isnomineeName);
        System.out.println("mobile valid :" + ismobileNo);
        System.out.println("gmail valid :" + isgmail);
        System.out.println("address valid :" + isaddress);
        System.out.println("balance  valid :" + isBalance);
        System.out.println("AccountType valid :" + isAccount);

        if (isuserName && isdob && isage && isnomineeName && ismobileNo && isgmail && isaddress && isBalance && isAccount) {
            System.out.println("All validations are pass");
            dao.register(user);
        } else {
            System.out.println("Validation failed");
        }
    }

    @Override
    public void getDetailsByEmail(String gmail) {
         dao.getDetailsByEmail(gmail);
    }

    @Override
    public boolean updateNameById(String name, int id) {
        return dao.updateNameById(name,id);
    }

    @Override
    public boolean updateAgeAndDobByEmail(int age, String dob, String gmail) {
        return dao.updateAgeAndDobByEmail(age,dob,gmail);
    }

    @Override
    public boolean updateAddressByEmail(String address, String gmail) {
        return dao.updateAddressByEmail(address,gmail);
    }

    @Override
    public boolean updateMobileNoByEmail(String mobileNo, String gmail) {
        return dao.updateMobileNoByEmail(mobileNo,gmail);
    }

    @Override
    public boolean updateNomineeNameByName(String nomineeName, String name) {
        return dao.updateNomineeNameByName(nomineeName,name);
    }

    @Override
    public boolean updateBalanceByAccountType(int balance, AccountType accountType) {
        return dao.updateBalanceByAccountType(balance, accountType);
    }

    @Override
    public boolean deleteUserById(int id) {
        return dao.deleteMeById(id);
    }

    @Override
    public List<UserDto> viewAllUsers() {
        return dao.viewAllUsers();
    }

    @Override
    public void getUserNameAndAccountBalanceById(int id) {
        dao.getUserNameAndAccountBalanceById(id);
    }
}

