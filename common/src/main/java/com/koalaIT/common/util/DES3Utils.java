package com.koalaIT.common.util;

/**
 * Created by Thinkpad on 2016/5/27.
 */

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

//import com.sun.org.apache.xml.internal.security.utils.Base64;


/**
 * 3DES加密工具类
 *
 */
public class DES3Utils {
    // 密钥
    public final static String secretKey = "0123456789abcd0123456789";
    // 向量
    public final static String iv = "12345678";
    // 加解密统一使用的编码方式
    private final static String encoding = "UTF-8";

    /**
     * 3DES加密
     *
     * @param plainText
     *            普通文本
     * @return
     * @throws Exception
     */
    public static String encode(String plainText) throws Exception {
        return encode(plainText, secretKey);
    }

    public static String encode(String plainText, String secretKey)
            throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey,ips);
//        com.sun.org.apache.xml.internal.security.Init.init();
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return Base64.encode(encryptData);
    }

    /**
     * 3DES解密
     *
     * @param plainText
     *            加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String plainText) throws Exception {
        if (StringUtils.isBlank(plainText)) {
            return "";
        }
        return decode(plainText, secretKey);
    }

    public static String decode(String encryptText, String secretKey)
            throws Exception {
        if (StringUtils.isBlank(encryptText)|| StringUtils.isBlank(secretKey)) {
            return "";
        }
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/NoPadding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey,ips);

        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

        return new String(decryptData, encoding).trim();
    }
}
