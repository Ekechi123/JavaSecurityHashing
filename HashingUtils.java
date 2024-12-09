import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtils {

    // Hash a given string using the specified algorithm
    public static String hashString(String input, HashAlgorithm algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm.getAlgorithmName());
            byte[] hashedBytes = digest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b)); // Convert each byte to hexadecimal
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Check if the input string matches the given hash using the specified algorithm
    public static boolean matchesHash(String input, String hash, HashAlgorithm algorithm) {
        return hash.equals(hashString(input, algorithm));
    }

    // Hash a string with a salt value
    public static String hashStringWithSalt(String input, String salt, HashAlgorithm algorithm) {
        String saltedInput = input + salt;  // Concatenate input and salt
        return hashString(saltedInput, algorithm);
    }
}

