package com.zingpay.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean validateMobileNumber(String mobileNumber) {
        String patterns = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    public static boolean validateCNIC(String cnic) {
        String patterns = "^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(cnic);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        String patterns = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
