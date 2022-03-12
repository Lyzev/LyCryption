package me.lyzev.cryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

/**
 * This file is part of LyCryption.
 * Copyright (c) 2021 Lyzev.
 *
 * This is an encryption which uses bit shifting and java.util.Random.
 *
 * @author Lyzev
 * @date 3/12/2022
 * @project LyCryption
 * @package me.lyzev.cryption
 */
public class LyCryption {

    private final StringBuilder key;

    public LyCryption(String key) {
        if (key == null)
            throw new NullPointerException("The provided key can't be null.");
        this.key = new StringBuilder(key);
    }

    public String encrypt(String in) {
        char[] out = in.toCharArray();
        Random random = new Random(key.toString().hashCode());
        for (int i = 0; i < out.length; i++)
            out[i] = (char) (out[i] << key.charAt(random.nextInt(key.reverse().length())) % 8);
        if (out.length % 2 != 0)
            key.reverse();
        return Base64.getEncoder().encodeToString(new String(out).getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String in) {
        char[] out = new String(Base64.getDecoder().decode(in)).toCharArray();
        Random random = new Random(key.toString().hashCode());
        for (int i = 0; i < out.length; i++)
            out[i] = (char) (out[i] >> key.charAt(random.nextInt(key.reverse().length())) % 8);
        if (out.length % 2 != 0)
            key.reverse();
        return new String(out);
    }

    public StringBuilder getKey() {
        return key;
    }
}
