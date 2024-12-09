/**
 * Enum representing the supported hash algorithms.
 * This enum provides constants for various cryptographic hash algorithms
 * that can be used for hashing operations. Currently, it supports:
 * <ul>
 *   <li>MD5</li>
 *   <li>SHA-1</li>
 *   <li>SHA-256</li>
 * </ul>
 * Each enum constant stores the string representation of the algorithm's name.
 * 
 * Example usage:
 * <pre>
 * HashAlgorithm algorithm = HashAlgorithm.MD5;
 * String algorithmName = algorithm.getAlgorithmName();
 * </pre>
 */
public enum HashAlgorithm {

    /**
     * MD5 hash algorithm.
     * MD5 is a widely used cryptographic hash function that produces a 128-bit hash value.
     */
    MD5("MD5"),

    /**
     * SHA-1 hash algorithm.
     * SHA-1 is a cryptographic hash function that produces a 160-bit hash value.
     */
    SHA1("SHA-1"),

    /**
     * SHA-256 hash algorithm.
     * SHA-256 is a cryptographic hash function that produces a 256-bit hash value.
     */
    SHA256("SHA-256");

    /**
     * The string representation of the algorithm's name.
     * This is used to pass to the {@link java.security.MessageDigest} instance 
     * to select the specific hash algorithm.
     */
    private final String algorithmName;

    /**
     * Constructor to initialize the enum constant with its corresponding algorithm name.
     * 
     * @param algorithmName The name of the algorithm as a string (e.g., "MD5", "SHA-1", "SHA-256").
     */
    HashAlgorithm(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    /**
     * Get the name of the hash algorithm.
     * 
     * @return The string representation of the hash algorithm (e.g., "MD5", "SHA-1", "SHA-256").
     */
    public String getAlgorithmName() {
        return algorithmName;
    }
}
