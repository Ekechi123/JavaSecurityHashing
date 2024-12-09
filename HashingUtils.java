import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for hashing strings using different algorithms.
 */
public class HashingUtils {

    /**
     * Hash a given string using the specified algorithm.
     * 
     * @param input The string to be hashed.
     * @param algorithm The hashing algorithm (MD5, SHA-1, SHA-256).
     * @return The hashed string in hexadecimal format.
     */
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

    /**
     * Verify if a given input string matches the specified hash using the given algorithm.
     * 
     * @param input The original string.
     * @param hash The expected hash.
     * @param algorithm The hashing algorithm (MD5, SHA-1, SHA-256).
     * @return True if the hash matches, false otherwise.
     */
    public static boolean matchesHash(String input, String hash, HashAlgorithm algorithm) {
        return hash.equals(hashString(input, algorithm));
    }

    /**
     * Hash a string with a salt value using the specified algorithm.
     * 
     * @param input The string to be hashed.
     * @param salt The salt to be added to the string.
     * @param algorithm The hashing algorithm (MD5, SHA-1, SHA-256).
     * @return The salted hash.
     */
    public static String hashStringWithSalt(String input, String salt, HashAlgorithm algorithm) {
        String saltedInput = input + salt;  // Concatenate input and salt
        return hashString(saltedInput, algorithm);
    }
}
