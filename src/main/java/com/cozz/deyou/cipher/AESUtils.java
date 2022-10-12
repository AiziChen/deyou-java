package com.cozz.deyou.cipher;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESUtils {
    /* renamed from: a */
    public static String m3398a(byte[] bArr) {
        return Base64.m3389e(bArr);
    }

    /* renamed from: b */
    public static byte[] m3396b(String str) {
        return Base64.m3390b(str);
    }

    /* renamed from: c */
    public static String m3394c(String str) {
        try {
            return m3400a(str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m3399a(String str, String str2) throws Exception {
        return m3398a(m3395b(str, str2));
    }

    /* renamed from: b */
    public static byte[] m3395b(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: a */
    public static String m3397a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
    }

    /* renamed from: a */
    public static String m3400a(String str) throws Exception {
        return m3397a(m3396b(str), "d7b85f6e214abcda");
    }
}
