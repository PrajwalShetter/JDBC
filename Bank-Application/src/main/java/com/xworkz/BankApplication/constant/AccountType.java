package com.xworkz.BankApplication.constant;

public enum AccountType {

    SAVING, CURRENT, RD, FIXED, SALARIED, INVESTMENT, JOINT;

    public static  boolean isValidType(String input){

        try{
            AccountType.valueOf(input.trim().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
