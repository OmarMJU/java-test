package com.omju.javatest.util;

public class PasswordUtil {
    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assessPassword(String password) {
        if (password.length() < 8)
            return SecurityLevel.WEAK;
        if (password.length() == 8)
            return  SecurityLevel.MEDIUM;
        if (password.length() > 8)
            return SecurityLevel.STRONG;

        return null;
    }
}