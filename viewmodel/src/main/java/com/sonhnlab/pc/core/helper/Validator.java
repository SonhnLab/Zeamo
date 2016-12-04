package com.sonhnlab.pc.core.helper;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class Validator {

    //region Constructor

    private Validator() {

    }

    //endregion

    //region Public method

    public static boolean validEmail(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validNotEmpty(String text) {
        return text != null && !text.isEmpty();
    }

    public static boolean validPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean validGender(String gender) {
        return gender != null && !gender.equals("Gender");
    }

    public static boolean validCollection(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static boolean validPhoneNumber(String phoneNumber) {
        if (validNotEmpty(phoneNumber)) {
            String phone = phoneNumber.replaceFirst("\\+", "").trim();
            try {
                Long.valueOf(phone);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static boolean validNumber(String number) {
        if (validNotEmpty(number)) {
            try {
                Double.valueOf(number);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean validDate(Date date) {
        return date != null;
    }

    public static boolean validNotNull(Object object) {
        return object != null;
    }

    //endregion
}
