package com.cozz.deyou.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtils {
    /* renamed from: a */
    private static byte[] m3373a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    /* renamed from: b */
    public static String m3370b(byte[] bArr) {
        return m3371a(bArr, StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    public static byte[] m3374a(String str) {
        return m3373a(str, StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    private static String m3371a(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    /* renamed from: a */
    public static String m3372a(byte[] bArr) {
        return m3371a(bArr, StandardCharsets.US_ASCII);
    }
}