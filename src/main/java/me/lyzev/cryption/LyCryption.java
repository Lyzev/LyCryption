package me.lyzev.cryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

/**
 * This file is part of LyCryption.
 * Copyright (c) 2021 Lyzev.
 *
 * This is an encryption which uses bit shifting and {@link Random}.
 *
 * @author Lyzev
 * @date 3/12/2022
 * @project LyCryption
 * @package me.lyzev.cryption
 */
public class LyCryption {

    private final StringBuilder key; // Key for encryption/decryption

    /**
     * A constructor for {@link LyCryption}
     *
     * @param key the key for encryption/decryption
     */
    public LyCryption(String key) {
        if (key == null) // Checks if the key is valid
            throw new NullPointerException("The provided key can't be null.");
        this.key = new StringBuilder(key);
    }

    /**
     * This method encrypts the provided input.
     *
     * @param in the text to encrypt
     * @return the encrypted text
     */
    public String encrypt(String in) {
        char[] out = in.toCharArray(); // Input as char array
        Random random = new Random(key.toString().hashCode()); // Creates an instance of Random with the hashcode of the key as the seed
        for (int i = 0; i < out.length; i++) // Loops thorugh every char of the provided input
            out[i] = (char) (out[i] << key.charAt(random.nextInt(key.length())) % 8); // Shifts the char value
        return Base64.getEncoder().encodeToString(new String(out).getBytes(StandardCharsets.UTF_8)); // Creates a string with the char array and encodes it with Base64
    }

    /**
     * This method decrypts the provided input.
     *
     * @param in the text to decrypt
     * @return the decrypted text
     */
    public String decrypt(String in) {
        char[] out = new String(Base64.getDecoder().decode(in)).toCharArray(); // Decodes the input with Base64, creates a string with it and gets the chars in the string as an array
        Random random = new Random(key.toString().hashCode()); // Creates an instance of Random with the hashcode of the key as the seed
        for (int i = 0; i < out.length; i++) // Loops thorugh every char of the provided input
            out[i] = (char) (out[i] >> key.charAt(random.nextInt(key.length())) % 8); // Shifts the char value
        return new String(out); // Creates a string with the char array
    }

    /**
     * @return the key for encryption/decryption
     */
    public StringBuilder getKey() {
        return key;
    }
}
