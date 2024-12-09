package security;

public class Main {

    public static void main(String[] args) {
        // Test case 1: Hash a string with MD5
        String input1 = "hello";
        String md5Hash = HashingUtils.hashString(input1, HashAlgorithm.MD5);
        assert md5Hash.equals("5d41402abc4b2a76b9719d911017c592") : "MD5 hash mismatch";

        // Test case 2: Hash a string with SHA-1
        String input2 = "hello";
        String sha1Hash = HashingUtils.hashString(input2, HashAlgorithm.SHA1);
        assert sha1Hash.equals("2ef7bde608ce5404e97d5f042f95f89f1c232871") : "SHA-1 hash mismatch";

        // Test case 3: Hash a string with SHA-256
        String input3 = "hello";
        String sha256Hash = HashingUtils.hashString(input3, HashAlgorithm.SHA256);
        assert sha256Hash.equals("2cf24dba5fb0a30e26e83b2ac5b9e29e1b1677c34b8b7cbd5ca72c18e42d5e0c") : "SHA-256 hash mismatch";

        // Test case 4: Verify hash matches the input string with SHA-256
        String input4 = "hello";
        String hashToCheck = HashingUtils.hashString(input4, HashAlgorithm.SHA256);
        assert HashingUtils.matchesHash(input4, hashToCheck, HashAlgorithm.SHA256) : "Hash verification failed";

        // Test case 5: Verify hash does not match with incorrect hash
        String wrongHash = "incorrect_hash";
        assert !HashingUtils.matchesHash(input4, wrongHash, HashAlgorithm.SHA256) : "Hash verification incorrectly passed with wrong hash";

        // Test case 6: Test salted hash
        String salt = "salt123";
        String saltedHash = HashingUtils.hashStringWithSalt(input4, salt, HashAlgorithm.SHA256);
        assert saltedHash != null : "Salted hash is null";

        System.out.println("All tests passed!");
    }
}

