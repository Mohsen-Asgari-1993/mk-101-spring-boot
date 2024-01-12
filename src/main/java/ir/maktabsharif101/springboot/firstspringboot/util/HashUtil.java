package ir.maktabsharif101.springboot.firstspringboot.util;

import org.apache.commons.codec.digest.Sha2Crypt;

import java.nio.charset.StandardCharsets;

public class HashUtil {

    public static String hash(String rawPassword) {
        return Sha2Crypt.sha256Crypt(
                rawPassword.getBytes(StandardCharsets.UTF_8)
        );
    }

}
