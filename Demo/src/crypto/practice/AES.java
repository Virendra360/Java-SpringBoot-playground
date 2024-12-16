package crypto.practice;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {

    /**
     * AES (Advanced Encryption Standard) supports several modes of operation, each with different characteristics
     * Mode	Authentication	Error Propagation	Use Case
     * ECB	No	None	Avoid for sensitive data
     * CBC	No	Yes (cascading)	File encryption
     * CFB	No	Yes	Streaming encryption
     * OFB	No	No (error-free)	Streaming encryption
     * CTR	No	No	High-speed encryption
     * GCM	Yes	No	Secure communication (TLS, VPN)
     * XTS	Yes	No	Disk encryption
     * CCM	Yes	No	Wireless protocols
     */

    /**
     * AES GCM (Galois/Counter Mode) MODE with No padding
     * AES-GCM (Galois/Counter Mode) is a mode of operation for the AES encryption algorithm that not only encrypts data but also verifies its integrity. This verification part works like a checksum.
     * When you encrypt data using AES-GCM, it not only encrypts the message but also calculates a special value called an authentication tag.
     * This tag is like a checksum for the encrypted data.
     * The tag ensures that no one has changed the encrypted message (ciphertext) while it was in transit or storage.
     *
     * AES-GCM takes your message (plain text), encrypts it, and calculates an authentication tag.
     * This tag is unique to the combination of the message, the encryption key, and the Initialization Vector (IV). So, if the message or any other factor changes, the tag will be different.
     */

    /**
     * To make AES-256 just restrict key size for 32 bytes i.e. 256 bits
     */

    /**
     * Note : Encrypted string will be same everytime if you use same key and same iv to encrypt
     * when key chane we get -> AEADBadTagException: Tag mismatch!  (Note : In CBC mode, using a different key will likely lead to corrupted decrypted data, but it may not throw a specific AEADBadTagException. Instead, you might get a BadPaddingException or a garbled output that doesn't match the original plaintext.)
     *  Above exception is commonly thrown in the case of AES-GCM mode (which uses both encryption and authentication). -> This exception indicates that the decryption has failed due to the authentication tag not matching, which means that either the ciphertext has been tampered with or the wrong key was used.
     */

    /**
     * IV Explained :-
     * IV size for GCM mode is 12 bytes
     * A random IV is generated during encryption.
     * Both the ciphertext and the IV are needed to decrypt the message successfully.
     * AES-GCM is a mode of AES that uses a nonce (IV) for encryption. This ensures that even if the same plaintext is encrypted multiple times with the same key, the ciphertext will be different.
     * The IV is generated automatically during encryption if you don't specify it, but it is still required during decryption to match the encryption process.
     * During encryption, the Cipher generates a random IV and uses it internally. However, for decryption, you must explicitly provide the same IV that was used during encryption.
     */

    /**
     * TAG_LENGTH Explained ( Authentication tag (also called a MAC or Message Authentication Code)) :-
     * specifies the size (in bits) of the authentication tag.
     * The TAG is automatically generated during the encryption process in AES-GCM.
     * During decryption, the same TAG is computed and compared to the stored one.
     * If they do not match, it indicates that the ciphertext or associated data has been tampered with, and decryption fails.
     * By default, during encryption it is 128 bits so in decrypt use 128 for default
     *  Possible TAG_LENGTH values are 128, 120, 112, 104 and 96
     *  AEADBadTagException: Tag mismatch! -> if length differs for decrypt from encrypt length used
     */

    /**
     * secret key Explained :-
     * Possible KEY_SIZE values are 128, 192 and 256
     * If the length of the key material does not match one of the valid AES key sizes (16 bytes for 128-bit, 24 bytes for 192-bit, or 32 bytes for 256-bit), an InvalidKeyException will be thrown when you attempt to initialize the Cipher with that key.
     */

    /**
     * Size of encrypted string :-
     * Plaintext size + AES-GCM encryption tag ( 16 bytes if tag length 128 ) + IV size ( if appended in encrypted string)
     * Base64 encoding: After encryption, the ciphertext and tag will be Base64-encoded, adding around 33% to the size
     */

    private SecretKey key;
   private int KEY_SIZE =128;
   private int TAG_LENGTH = 128;

   // IV size for GCM mode is 12 bytes
   private byte[] iv = new byte[12];


   // randomly generated key
    public void init() throws Exception{
        KeyGenerator generator= KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public void initCustomKey(String customKey){
        byte[] keyInBytes = customKey.getBytes();
        key= new SecretKeySpec(keyInBytes,"AES");
    }

    public String encrypt(String msg) throws Exception{

        byte[] msgInBytes = msg.getBytes();

        System.out.println("Plain text size -> "+ msgInBytes.length);

        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");

        // we will set GCM param spec manually
       // by default it generated its own IV which change everytime and TAG_LENGTH is 128 bits by default
        // This are added with cipher-text which are needed during decryption
//        encryptionCipher.init(Cipher.ENCRYPT_MODE,key);      // GCM specs added by default

        // we can add GCM specs manually also
        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH,iv);
        encryptionCipher.init(Cipher.ENCRYPT_MODE,key,spec);

        byte[] encryptedMsgInBytes = encryptionCipher.doFinal(msgInBytes);

        System.out.println("Cipher text size before encoding -> "+ encryptedMsgInBytes.length);

        String encodedString = encode(encryptedMsgInBytes);

        System.out.println("Cipher text size after encoding -> "+ encodedString.length());

//        System.out.println("encodedString -> "+encodedString);
//        System.out.println("Encrypted byte to string ->"+new String(encryptedMsgInBytes));

//       return encode(encryptedMsgInBytes);
        return  encodedString;
    }

    public String decrypt(String encryptedMsg) throws Exception{

        // bcs we have encoded we need to decode also
        byte[] encryptedMsgInBytes = decode(encryptedMsg);

        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");

        // without GCMParameterSpec we get error
        // first param is Tag length and second is IV (Initialization Vector which is mandatory in AES-GCM algo)
        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH,iv);

        decryptionCipher.init(Cipher.DECRYPT_MODE,key,spec);

        byte[] decryptedMsg= decryptionCipher.doFinal(encryptedMsgInBytes);

//        System.out.println("encode string of decrypt value ->"+encode(decryptedMsg));

//        Interpret binary data as characters. Produces unpredictable results for raw data. Gibberish or error.
//        System.out.println("decrypt raw string -> "+new String(decryptedMsg));

        return new String(decryptedMsg);
    }

    private String encode(byte[] data){
        /**
         *  Encoding transforms binary data (byte arrays) into a format that can be represented as a string
         *  (e.g., Base64 encoding turns bytes into a string of ASCII characters
         *  Safely transmitting or storing binary data as text.
         */
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) throws Exception {

        AES aes = new AES();

        // randomly generated key
//        aes.init();

        // with custom key
        aes.initCustomKey("aaaaaaaaaaaaaaaa");

        String msg= "Virendra";

        long startTime = System.currentTimeMillis();  // Capture start time
        String encryptedMsg= aes.encrypt(msg);
        long endTime = System.currentTimeMillis();  // Capture end time

        long duration = (endTime - startTime);  // Calculate duration in milli-seconds
        System.out.println("Encryption Time: " + duration + " ms");


         startTime = System.currentTimeMillis();  // Capture start time
         // aes.initCustomKey("bbbbbbbbbbbbbbbb");  // we will AEADBadTagException: Tag mismatch!
        String decryptedMsg = aes.decrypt(encryptedMsg);
         endTime = System.currentTimeMillis();  // Capture end time

         duration = (endTime - startTime);  // Calculate duration in milli-seconds
        System.out.println("Decryption Time: " + duration + " ms");

        System.out.println("encryptedMsg -> "+encryptedMsg);
        System.out.println("decryptedMsg -> "+decryptedMsg);

    }

}
