package com.example.aesencryption.Functions;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    public static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] IV) throws Exception
    {
        /*The encryption class is the class that does the actual encryption and decryption. The Cipher class instance is created by calling the getInstance () method, which passes the name Cipher as a parameter, we used AES / CBC / PKCS5Padding.*/
        Cipher cipher = Cipher.getInstance("AES");
        /*SecretKeySpec provides a mechanism for converting byte data to a secret key suitable for passing to the init () method of the Cipher class.*/
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        /*IV ParameterSpec is a wrapper for an initialization vector, IV takes the randomness of how IV ParameterSpec is configured.*/
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        /*After the cipher instance is created, we need to initialize its encrypted instance by calling the init () method. We need to pass 3 parameters to the init () method.
         * Cipher.ENCRYPT_MODE
         * keySpec
         * ivSpec */
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] cipherText = cipher.doFinal(plaintext);
        return cipherText;
    }
}


