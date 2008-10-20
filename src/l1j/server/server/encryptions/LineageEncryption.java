package l1j.server.server.encryptions;

import java.util.HashMap;

import l1j.server.server.types.UChar8;
import l1j.server.server.types.ULong32;

/**
 * Handler Encryption/Decryption of lineage packet data
 * 
 * @author Storm Last update: 2005-12-10
 */
public class LineageEncryption {
	// Initialized keys - one key per client ID
	private static HashMap<Object, LineageKeys> keyMap = new HashMap<Object, LineageKeys>();

	// The current key to use for encryption/decryption
	// private static LineageKeys currentKeys = null;

	/**
	 * Initializes lineage encrypt/decrypt keys for the given clientID and maps
	 * them to that id.
	 * 
	 * @param clientID
	 *            the id to map the keys to
	 * @param seed
	 *            a random seed to compute the keys with
	 * @return LineageKeys the generated encrypt/decrypt keys
	 * @throws ClientIdExistsException
	 *             If a client id already is in use
	 */
	public static LineageKeys initKeys(Object clientID, long seed)
			throws ClientIdExistsException {
		if (keyMap.containsKey(clientID)) {
			throw new ClientIdExistsException();
		}

		LineageKeys keys = new LineageKeys();

		long key[] = { seed, 0x930FD7E2L };

		LineageBlowfish.getSeeds(key);

		keys.encodeKey[0] = keys.decodeKey[0] = key[0];
		keys.encodeKey[1] = keys.decodeKey[1] = key[1];

		keyMap.put(clientID, keys);

		return keys;
	}

	/**
	 * Sets the keys that are mapped to the client id as the current keys to be
	 * used.
	 * 
	 * @param clientID
	 *            the client id to set the keys for
	 * @return boolean true if the client id was found, otherwise false
	 */
	public static LineageKeys prepareKeys(Object clientID) {
		LineageKeys keys;
		if ((keys = keyMap.get(clientID)) == null) {
			// Possibly throw NoSuchClientIdException
			// Error... client hasn't any initialized lineage keys, forgot to
			// init the keys?
			return null;
		}

		// currentKeys = keys;

		return keys;
	}

	/**
	 * Encrypts the data with the prepared keys.
	 * 
	 * @param buf
	 *            the data to be encrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 * @throws NoEncryptionKeysSelectedException
	 *             If no keys have been prepared
	 */
	public static char[] encrypt(char[] buf, LineageKeys currentKeys)
			throws NoEncryptionKeysSelectedException {
		if (currentKeys == null) {
			throw new NoEncryptionKeysSelectedException();
		}

		long mask = ULong32.fromArray(buf);

		_encrypt(buf, currentKeys);

		currentKeys.encodeKey[0] ^= mask;
		currentKeys.encodeKey[1] = ULong32.add(currentKeys.encodeKey[1],
				0x287EFFC3L);

		// updatekeye( cp, e );
		return buf;
	}

	/**
	 * Encrypts the data with the prepared keys.
	 * 
	 * @param buf
	 *            the data to be encrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 * @throws NoEncryptionKeysSelectedException
	 *             If no keys have been prepared
	 */
	public static byte[] encrypt(byte[] buf, LineageKeys currentKeys)
			throws NoEncryptionKeysSelectedException {
		if (currentKeys == null) {
			throw new NoEncryptionKeysSelectedException();
		}

		long mask = ULong32.fromArray(buf);

		_encrypt(buf, currentKeys);

		currentKeys.encodeKey[0] ^= mask;
		currentKeys.encodeKey[1] = ULong32.add(currentKeys.encodeKey[1],
				0x287EFFC3L);

		// updatekeye( cp, e );
		return buf;
	}

	/**
	 * Decrypts the data with the prepared keys.
	 * 
	 * @param buf
	 *            the data to be decrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 * @throws NoEncryptionKeysSelectedException
	 *             If no keys have been prepared
	 */
	public static char[] decrypt(char[] buf, LineageKeys currentKeys)
			throws NoEncryptionKeysSelectedException {
		if (currentKeys == null) {
			throw new NoEncryptionKeysSelectedException();
		}

		_decrypt(buf, currentKeys);

		long mask = ULong32.fromArray(buf);

		currentKeys.decodeKey[0] ^= mask;
		currentKeys.decodeKey[1] = ULong32.add(currentKeys.decodeKey[1],
				0x287EFFC3L);

		// updatekeyd( cp, d );
		return buf;
	}

	/**
	 * Decrypts the data with the prepared keys.
	 * 
	 * @param buf
	 *            the data to be decrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 * @throws NoEncryptionKeysSelectedException
	 *             If no keys have been prepared
	 */
	public static byte[] decrypt(byte[] buf, int length, LineageKeys currentKeys)
			throws NoEncryptionKeysSelectedException {
		if (currentKeys == null) {
			throw new NoEncryptionKeysSelectedException();
		}

		_decrypt(buf, length, currentKeys);

		long mask = ULong32.fromArray(buf);

		currentKeys.decodeKey[0] ^= mask;
		currentKeys.decodeKey[1] = ULong32.add(currentKeys.decodeKey[1],
				0x287EFFC3L);

		// updatekeyd( cp, d );
		return buf;
	}

	/**
	 * Does the actual hardcore encryption.
	 * 
	 * @param buf
	 *            the data to be encrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 */
	private static char[] _encrypt(char[] buf, LineageKeys currentKeys) {
		int size = buf.length;
		char[] ek = UChar8.fromArray(currentKeys.encodeKey);

		buf[0] ^= ek[0];

		for (int i = 1; i < size; i++) {
			buf[i] ^= (buf[i - 1] ^ ek[i & 7]);
		}

		buf[3] = (char) (buf[3] ^ ek[2]);
		buf[2] = (char) (buf[2] ^ buf[3] ^ ek[3]);
		buf[1] = (char) (buf[1] ^ buf[2] ^ ek[4]);
		buf[0] = (char) (buf[0] ^ buf[1] ^ ek[5]);

		return buf;
	}

	/**
	 * Does the actual hardcore encryption.
	 * 
	 * @param buf
	 *            the data to be encrypted, this arrays data is overwritten
	 * @return byte[] an 8 bit unsigned char array with the encrypted data
	 */
	private static byte[] _encrypt(byte[] buf, LineageKeys currentKeys) {
		int size = buf.length;
		char[] ek = UChar8.fromArray(currentKeys.encodeKey);

		buf[0] ^= ek[0];

		for (int i = 1; i < size; i++) {
			buf[i] ^= (buf[i - 1] ^ ek[i & 7]);
		}

		buf[3] = (byte) (buf[3] ^ ek[2]);
		buf[2] = (byte) (buf[2] ^ buf[3] ^ ek[3]);
		buf[1] = (byte) (buf[1] ^ buf[2] ^ ek[4]);
		buf[0] = (byte) (buf[0] ^ buf[1] ^ ek[5]);

		return buf;
	}

	/**
	 * Does the actual hardcore decryption.
	 * 
	 * @param buf
	 *            the data to be decrypted, this arrays data is overwritten
	 * @return char[] an 8 bit unsigned char array with the encrypted data
	 */
	private static char[] _decrypt(char[] buf, LineageKeys currentKeys) {
		int size = buf.length;
		char[] dk = UChar8.fromArray(currentKeys.decodeKey);

		char b3 = buf[3];
		buf[3] ^= dk[2];

		char b2 = buf[2];
		buf[2] ^= (b3 ^ dk[3]);

		char b1 = buf[1];
		buf[1] ^= (b2 ^ dk[4]);

		char k = (char) (buf[0] ^ b1 ^ dk[5]);
		buf[0] = (char) (k ^ dk[0]);

		for (int i = 1; i < size; i++) {
			char t = buf[i];
			buf[i] ^= (dk[i & 7] ^ k);
			k = t;
		}
		return buf;
	}

	/**
	 * Does the actual hardcore decryption.
	 * 
	 * @param buf
	 *            the data to be decrypted, this arrays data is overwritten
	 * @return byte[] an 8 bit unsigned char array with the encrypted data
	 */
	private static byte[] _decrypt(byte[] buf, int size, LineageKeys currentKeys) {
		char[] dk = UChar8.fromArray(currentKeys.decodeKey);

		byte b3 = buf[3];
		buf[3] ^= dk[2];

		byte b2 = buf[2];
		buf[2] ^= (b3 ^ dk[3]);

		byte b1 = buf[1];
		buf[1] ^= (b2 ^ dk[4]);

		byte k = (byte) (buf[0] ^ b1 ^ dk[5]);
		buf[0] = (byte) (k ^ dk[0]);

		for (int i = 1; i < size; i++) {
			byte t = buf[i];
			buf[i] ^= (dk[i & 7] ^ k);
			k = t;
		}
		return buf;
	}
}