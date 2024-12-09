/**
 * Main class to run and test the hashing utility functions.
 * This class demonstrates the usage of the {@link HashingUtils} class for
 * hashing strings using various algorithms (MD5, SHA-1, SHA-256), 
 * verifying hash matches, and testing salted hashes.
 * 
 * <p>The tests include:</p>
 * <ul>
 *   <li>Hashing a string with MD5</li>
 *   <li>Hashing a string with SHA-1</li>
 *   <li>Hashing a string with SHA-256</li>
 *   <li>Verifying a hash matches the input string</li>
 *   <li>Verifying that a hash does not match with an incorrect value</li>
 *   <li>Testing the hashing function with a salt value</li>
 * </ul>
 */
public class Main {

    /**
     * Main method to run the tests for the hashing utilities.
     * It performs several tests on the {@link HashingUtils} methods and 
     * verifies their correctness using assertions. If all tests pass, 
     * "All tests passed!" is printed to the console.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Test case 1: Hash a string with MD5
        String input1 = "hello";
        String md5Hash = HashingUtils.hashString(input1, HashAlgorithm.MD5);
        // MD5 hash of "hello"
        assert md5Hash.equals("5d41402abc4b2a76b9719d911017c592") : "MD5 hash mismatch";

        // Test case 2: Hash a string with SHA-1
        String input2 = "hello";
        String sha1Hash = HashingUtils.hashString(input2, HashAlgorithm.SHA1);
        // SHA-1 hash of "hello"
        assert sha1Hash.equals("2ef7bde608ce5404e97d5f042f95f89f1c232871") : "SHA-1 hash mismatch";

        // Test case 3: Hash a string with SHA-256
        String input3 = "hello";
        String sha256Hash = HashingUtils.hashString(input3, HashAlgorithm.SHA256);
        // SHA-256 hash of "hello"
        assert sha256Hash.equals("2cf24dba5fb0a30e26e83b2ac5b9e29e1b1677c34b8b7cbd5ca72c18e42d5e0c") : "SHA-256 hash mismatch";

        // Test case 4: Verify hash matches the input string with SHA-256
        String input4 = "hello";
        String hashToCheck = HashingUtils.hashString(input4, HashAlgorithm.SHA256);
        // Verify that the hash matches
        assert HashingUtils.matchesHash(input4, hashToCheck, HashAlgorithm.SHA256) : "Hash verification failed";

        // Test case 5: Verify hash does not match with incorrect hash
        String wrongHash = "incorrect_hash";
        // Hash verification should fail
        assert !HashingUtils.matchesHash(input4, wrongHash, HashAlgorithm.SHA256) : "Hash verification incorrectly passed with wrong hash";

        // Test case 6: Test salted hash
        String salt = "salt123";
        String saltedHash = HashingUtils.hashStringWithSalt(input4, salt, HashAlgorithm.SHA256);
        // Salted hash should not be null
        assert saltedHash != null : "Salted hash is null";

        // If all tests pass, print success message
        System.out.println("All tests passed!");
    }
}
