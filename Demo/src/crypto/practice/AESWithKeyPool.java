package crypto.practice;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESWithKeyPool {

    /**
     * Size of encrypted string :-
     * Plaintext size + AES-GCM encryption tag ( 16 bytes if tag length 128 ) + IV size ( if appended in encrypted string)
     * Base64 encoding: After encryption, the ciphertext and tag will be Base64-encoded, adding around 33% to the size
     * Now in our key we have added 4 extra characters to key index
     */

    private int KEY_SIZE =128;
    private int TAG_LENGTH = 128;

    // IV size for GCM mode is 12 bytes
    private byte[] iv = new byte[12];

    private static final int BINARY_LENGTH = 4; // Fixed length for binary representation of the key index
    private static final int KEY_POOL_SIZE = 10;
    private SecretKey[] keyPool = new SecretKey[KEY_POOL_SIZE];

    private final SecureRandom secureRandom = new SecureRandom();

    public void initKeyPool() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);

        for (int i = 0; i < KEY_POOL_SIZE; i++) {
            keyPool[i] = generator.generateKey();
        }
    }

    public void initKeyPoolWithCustomKeys(String[] customKeys) {
        if (customKeys.length != KEY_POOL_SIZE) {
            throw new IllegalArgumentException("The number of custom keys must be exactly " + KEY_POOL_SIZE);
        }

        for (int i = 0; i < KEY_POOL_SIZE; i++) {
            byte[] keyBytes = customKeys[i].getBytes();
            if (keyBytes.length != KEY_SIZE / 8) {
                throw new IllegalArgumentException("Each custom key must be " + (KEY_SIZE / 8) + " bytes long.");
            }
            keyPool[i] = new SecretKeySpec(keyBytes, "AES");
        }
    }


    public String encrypt(String msg) throws Exception{

        byte[] msgInBytes = msg.getBytes();

        // Randomly select a key from the key pool
        int keyIndex = secureRandom.nextInt(KEY_POOL_SIZE);
        SecretKey key = keyPool[keyIndex];

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

        // Convert the key index to binary and pad to a fixed length
        String keyIndexBinary = String.format("%" + BINARY_LENGTH + "s", Integer.toBinaryString(keyIndex)).replace(' ', '0');

//       return encode(encryptedMsgInBytes);
        return  encodedString+keyIndexBinary;
    }

    public String decrypt(String encryptedMsgWithBinaryIndex) throws Exception{


        // Extract the binary key index from the last fixed-length portion
        int encryptedTextLength = encryptedMsgWithBinaryIndex.length();
        String keyIndexBinary = encryptedMsgWithBinaryIndex.substring(encryptedTextLength - BINARY_LENGTH);
        String encryptedMsg = encryptedMsgWithBinaryIndex.substring(0, encryptedTextLength - BINARY_LENGTH);

        // Convert the binary key index back to an integer
        int keyIndex = Integer.parseInt(keyIndexBinary, 2);

        // Retrieve the correct key from the key pool
        SecretKey key = keyPool[keyIndex];


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

        AESWithKeyPool aes = new AESWithKeyPool();

////      randomly generated key
//        aes.initKeyPool();

        // Custom keys
        String[] customKeys = {
                "1234567812345678", "abcdefghabcdefgh", "8765432187654321", "ijklmnopijklmnop",
                "mnopqrstmnopqrst", "uvwxyz12uvwxyz12", "1234abcd1234abcd", "zzzzzzzzzzzzzzzz",
                "keynumber9number", "lastkeylastkey12"
        };

        // Initialize key pool with custom keys
        aes.initKeyPoolWithCustomKeys(customKeys);

        String msg= "Virendra";

        long startTime = System.currentTimeMillis();  // Capture start time
        String encryptedMsg= aes.encrypt(msg);
        long endTime = System.currentTimeMillis();  // Capture end time

        long duration = (endTime - startTime);  // Calculate duration in milli-seconds
        System.out.println("Encryption Time: " + duration + " ms");


        startTime = System.currentTimeMillis();  // Capture start time
        String decryptedMsg = aes.decrypt(encryptedMsg);
        endTime = System.currentTimeMillis();  // Capture end time

        duration = (endTime - startTime);  // Calculate duration in milli-seconds
        System.out.println("Decryption Time: " + duration + " ms");

        System.out.println("encryptedMsg -> "+encryptedMsg);
        System.out.println("decryptedMsg -> "+decryptedMsg);

    }


}
