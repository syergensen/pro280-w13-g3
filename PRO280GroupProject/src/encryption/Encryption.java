package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/8/13
 */
public class Encryption {
    public static String digest(String plainText) {
        return digest(plainText, EncryptionType.MD5);
    }

    public static String digest(String plainText, EncryptionType type) {
        String encrypted = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(type.algorithm);
            byte[] digested = messageDigest.digest(plainText.getBytes());
            encrypted = Encryption.toHexString(digested);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(255 & b);
            if (hex.length() < 2) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
