package fotowebstore.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHandler {

    public static byte[] hash(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        return messageDigest.digest(input);
    }

    public static byte[] salt() {
        SecureRandom secRand = new SecureRandom();
        return secRand.generateSeed(32);
    }
}
