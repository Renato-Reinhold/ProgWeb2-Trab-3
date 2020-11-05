package org.o7planning.sbsecurity.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("123", "$2a$10$0OxhC.kX/AmAwccSg6r7h.RQfFzfruk4OI8BDJoQmGWkcMAgbBlv6"));
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";

        String encrytedPassword = encrytePassword(password);

        System.out.println();
        System.out.println("Encryted Password: " + encrytedPassword);
    }

}