import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * DebugHash provides an executable program to print arbitrary values to
 * the screen in an infinite loop.  It is written in such a way that code
 * changes are very likely to change the output, and thus demonstrates the
 * utility of debuggers to instrument code without modifying it.
 *
 */
public class DebugHash {

	/**
	 * Using a supplied seed value, compute arbitrary (but repeatable) values
	 * based upon an underlying hashing algorithm.
	 * 
	 * @param seed - the seed used to determine the sequence of arbitrary values.
	 */
	private static void printArbitraryHashes(byte seed) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		byte[] last_hash = {seed};

		while (true) {
			md5.update(last_hash);
			byte[] new_hash = md5.digest();
			
			String hashString = getHashString(new_hash);
			System.out.println(hashString);
			
			last_hash = new_hash;
		}
	}
	
	/**
	 * Translate a given byte array into a hexadecimal String represention of 
	 * the given array.
	 * 
	 * @param hash - the byte array to be translated.
	 * @return - the hexadecimal String representation.
	 */
	private static String getHashString(byte[] hash) {
		return String.format("%032x", new BigInteger(1, hash));
	}
	
	/**
	 * Entry-point for this executable class.
	 * 
	 * @param args - the command line parameters (unused by this program).
	 */
	public static void main(String[] args) {
		byte seed = 0;
		for (StackTraceElement element: Thread.currentThread().getStackTrace()) {
			seed += element.getLineNumber();
		}
		
		printArbitraryHashes(seed);
	}
}