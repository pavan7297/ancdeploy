package com.jwtAuth.utils;

import java.util.regex.Matcher;

public class Validators {

	//password must contain atleast one digit one caps and one special char
	public static boolean isValid(final String password) {
        Matcher matcher = CommonConstants.pattern.matcher(password);
        return matcher.matches();
    }
    
	//phone number that matches 10 digits 
    public static boolean isValidPhone(final String password) {
        Matcher matcher = CommonConstants.PHONENUMBERMATCH.matcher(password);
        return matcher.matches();
    }
    
  //pattern that does not allow special characters 
    public static boolean isValidSpecial(final String password) {
        Matcher matcher = CommonConstants.SPECIALPATTERN.matcher(password);
        return matcher.matches();
    }
    
  //pattern that does allow only numbers
    public static boolean isValidNumber(final String password) {
        Matcher matcher = CommonConstants.NUMBERS.matcher(password);
        return matcher.matches();
    }
    
    //pattern that does allow only numbers
    public static boolean isValidEmail(final String password) {
        Matcher matcher = CommonConstants.EMAIL.matcher(password);
        return matcher.matches();
    }
    
  //pattern that does allow only numbers
    public static boolean isValidAadhar(final String password) {
        Matcher matcher = CommonConstants.AADHAR.matcher(password);
        return matcher.matches();
    }


}

