package com.omju.javatest.util;

import static com.omju.javatest.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PasswordUtilTest {
    private final static String STRONG_PASSWORD = "123456789";
    private final static String MEDIUM_PASSWORD = "12345678";
    private final static String WEAK_PASSWORD = "1234567";

    @Test
    public void passwordWeak() {
        assertEquals(WEAK, PasswordUtil.assessPassword(WEAK_PASSWORD));
    }

    @Test
    public void passwordMedium() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword(MEDIUM_PASSWORD));
    }

    @Test
    public void passwordStrong() {
        assertEquals(STRONG, PasswordUtil.assessPassword(STRONG_PASSWORD));
    }
}