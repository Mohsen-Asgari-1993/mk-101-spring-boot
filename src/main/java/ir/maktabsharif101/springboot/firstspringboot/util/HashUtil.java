package ir.maktabsharif101.springboot.firstspringboot.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

public class HashUtil {

    public static String hash(String rawPassword) {
        return DigestUtils.sha1Hex(
                rawPassword.getBytes(StandardCharsets.UTF_8)
        );
    }

}
