package com.xworkz.BankApplication.runner;

import com.xworkz.BankApplication.Dto.UserDto;
import com.xworkz.BankApplication.constant.AccountType;
import com.xworkz.BankApplication.controller.BankController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BankRunner {

    public static void main(String[] args) {

        BankController controller = new BankController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi... Welcome to Bank");
        boolean isRunning = true;


        while(isRunning){
            System.out.println("=====Plz Authenticate yourself=====\n");
            System.out.println("1.User");
            System.out.println("1.Manager");
            System.out.println("Enter Your choice 1 or 2:");

            int choice =sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("user verified");
                    boolean isUser = true;

                    while(isUser){
                        System.out.println("What would you like to do here,");
                        System.out.println("1.Register yourself ");
                        System.out.println("2. you want to see your details");
                        System.out.println("3. Edit your details");
                        System.out.println("4. Delete yourself");
                        System.out.println("Enter your choice :");

                        int choice1 = sc.nextInt();
                        sc.nextLine();

                        switch (choice1){
                            case 1:
                                System.out.println("Welcome for registration \n please Fill the form \n");
                                UserDto user1 = new UserDto();

                                System.out.println("Enter name : ");
                                user1.setName(sc.nextLine());
                                System.out.println("Dob :");
                                user1.setDob(sc.nextLine());
                                System.out.println("Enter your age :");
                                user1.setAge(sc.nextLine());
                                System.out.println("Enter your gmail");
                                user1.setGmail(sc.nextLine());
                                System.out.println("Enter your mobileNo");
                                user1.setMobileNo(sc.nextLine());
                                System.out.println("Enter your Address");
                                user1.setAddress(sc.nextLine());
                                System.out.println("Enter your NomineeName :");
                                user1.setNomineeName(sc.nextLine());
                                System.out.println("Enter the balance :");
                                user1.setBalance(sc.nextInt());
                                System.out.println("Enter your account type :");
                                String inputType = sc.next().toUpperCase();
                                user1.setAccountType(AccountType.valueOf(inputType));

                                 controller.register(user1);
                                break;

                            case 2:
                                System.out.println("Here your details ");

                                System.out.println("Controller calling getDetailsByEmail() ");
                                System.out.println("Enter your mail :");
                                controller.getDetailsByEmail(sc.nextLine());
                                break;

                            case 3:
                                boolean isEdit =true;

                                while(isEdit) {
                                    System.out.println("What do you want to edit :\n");
                                    System.out.println("1.update your age and DOB ");
                                    System.out.println("2.update Address");
                                    System.out.println("3.update Mobile number");
                                    System.out.println("4.update Nominee Name");
                                    System.out.println("5.update balance ");
                                    System.out.println("6.update name");

                                    int num = sc.nextInt();
                                    sc.nextLine();

                                    if(num == 1){

                                        System.out.println("Controller calling updateAgeAndDobByEmail ()");
                                        controller.updateAgeAndDobByEmail(sc.nextInt(),sc.nextLine(),sc.nextLine());
                                    } else if (num ==2) {
                                        System.out.println("Controller calling  updateAddressByEmail()");
                                          controller.updateAddressByEmail(sc.nextLine(),sc.nextLine());
                                    } else if (num ==3) {
                                        System.out.println("Controller calling  updateMobileNoByEmail()");
                                        controller.updateMobileNoByEmail(sc.nextLine(),sc.nextLine());

                                    } else if (num ==4) {
                                        System.out.println("Controller calling updateNomineeNameByName()");
                                         controller.updateNomineeNameByName(sc.nextLine(), sc.nextLine());

                                    } else if (num ==5) {
                                        System.out.println("Controller calling updateBalanceByAccountType()");
                                         controller.updateBalanceByAccountType(sc.nextInt(), AccountType.valueOf(sc.next().toUpperCase()));

                                    } else if (num ==6) {
                                        System.out.println("controller calling updateNameById()");
                                        controller.updateNameById(sc.nextLine(), sc.nextInt());

                                    } else {
                                        System.out.println("Enter valid number");
                                    }
                                  isEdit = false;
                                }
                                break;
                            case 4:
                                System.out.println("Deleting you data");
                                System.out.println("controller calling deleteMeById() :");
                                 controller.deleteUserById(sc.nextInt());
                                 break;

                        }
                        isUser=false;
                    }
                    break;

                case 2:
                    System.out.println("Manager access granted");
                    boolean isManager = true;

                    while(isManager){
                        System.out.println("What can i Help you");
                        System.out.println("1.View all Registered users");
                        System.out.println("2.Delete user");
                        System.out.println("3.View the users name and account balance");
                        System.out.println("Enter your choice between  1 & 3");
                        int choice2 = sc.nextInt();
                        sc.nextLine();

                        switch (choice2){
                            case 1:
                                System.out.println("controller calling  viewAllUsers()");


                                List<UserDto> list =  controller.viewAllUsers();

                                for(UserDto dto : list){
                                    System.out.println(dto.getName());
                                    System.out.println(dto.getAge());
                                    System.out.println(dto.getDob());
                                    System.out.println(dto.getGmail());
                                    System.out.println(dto.getMobileNo());
                                    System.out.println(dto.getAddress());
                                    System.out.println(dto.getNomineeName());
                                    System.out.println(dto.getBalance());
                                    System.out.println(dto.getAccountType());
                                    System.out.println("=========================");
                                }

                                break;

                            case 2:
                                System.out.println("controller calling deleteMeById() :");
                                controller.deleteUserById(sc.nextInt());
                                break;

                            case 3:
                                System.out.println("controller calling getUserNameAndAccountBalanceById()");
                                controller.getUserNameAndAccountBalanceById(sc.nextInt());
                                break;

                        }
                        isManager = false;

                    }
                    break;

                default:
                    System.out.println("Invalid choice please choose a number between 1 & 2");
                    break;
            }
            isRunning = false;
        }

    }
}
