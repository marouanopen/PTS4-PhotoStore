package fotowebstore.models;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;


public class SerialKey {

    public static String generate() {
        String key = null;
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(256);
            SecretKey secretKey = generator.generateKey();
            key = Base64.encode(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return key;
    }
}
