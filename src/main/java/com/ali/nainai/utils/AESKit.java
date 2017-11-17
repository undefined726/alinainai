package com.ali.nainai.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * AES对称加密
 */
public class AESKit {

    private AESKit() {
    }

    /**
     * 加密
     *
     * @param secret 密钥
     * @param value  待加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String secret, String value) {
        SecretKeySpec keySpec = getKey(secret);
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
            return Base64.encodeExt(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     *
     * @param secret 密钥
     * @param value  待解密字符串
     * @return 解密后的字符串
     */
    public static String decrypt(String secret, String value) {
        SecretKeySpec keySpec = getKey(secret);
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            byte[] encrypted1 = Base64.decode(value);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成加密的密钥，保证长度为16位
     *
     * @param secret 用户的密钥
     * @return 生成的密钥
     */
    private static SecretKeySpec getKey(String secret) {
        byte[] bytes;
        try {
            bytes = secret.getBytes("UTF-8");
            return new SecretKeySpec(Arrays.copyOf(bytes, 16), "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}