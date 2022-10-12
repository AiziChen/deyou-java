package com.cozz.deyou.cipher;

import com.cozz.deyou.utils.StringUtils;

public class Base64 extends BaseNCodec {

    /* renamed from: g */
    static final byte[] f23689g = {13, 10};

    /* renamed from: h */
    private static final byte[] f23690h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: i */
    private static final byte[] f23691i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: j */
    private static final byte[] f23692j = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: k */
    private final byte[] f23693k;

    /* renamed from: l */
    private final byte[] f23694l;

    /* renamed from: m */
    private final byte[] f23695m;

    /* renamed from: n */
    private final int f23696n;

    /* renamed from: o */
    private final int f23697o;

    public Base64() {
        this(0);
    }

    /* renamed from: e */
    public static String m3389e(byte[] bArr) {
        return StringUtils.m3372a(m3393a(bArr, false));
    }

    @Override
    void mo3381a(byte[] bArr, int i, int i2, BaseNCodec.C5338a c5338a) {
        byte b;
        if (c5338a.f23709f) {
            return;
        }
        if (i2 < 0) {
            c5338a.f23709f = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] m3386a = m3386a(this.f23696n, c5338a);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == this.f23699b) {
                c5338a.f23709f = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = f23692j;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    c5338a.f23711h = (c5338a.f23711h + 1) % 4;
                    c5338a.f23704a = (c5338a.f23704a << 6) + b;
                    if (c5338a.f23711h == 0) {
                        int i5 = c5338a.f23707d;
                        c5338a.f23707d = i5 + 1;
                        int i6 = c5338a.f23704a;
                        m3386a[i5] = (byte) ((i6 >> 16) & 255);
                        int i7 = c5338a.f23707d;
                        c5338a.f23707d = i7 + 1;
                        m3386a[i7] = (byte) ((i6 >> 8) & 255);
                        int i8 = c5338a.f23707d;
                        c5338a.f23707d = i8 + 1;
                        m3386a[i8] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!c5338a.f23709f || c5338a.f23711h == 0) {
            return;
        }
        byte[] m3386a2 = m3386a(this.f23696n, c5338a);
        int i9 = c5338a.f23711h;
        if (i9 == 1) {
            return;
        }
        if (i9 == 2) {
            c5338a.f23704a >>= 4;
            int i10 = c5338a.f23707d;
            c5338a.f23707d = i10 + 1;
            m3386a2[i10] = (byte) (c5338a.f23704a & 255);
        } else if (i9 == 3) {
            c5338a.f23704a >>= 2;
            int i11 = c5338a.f23707d;
            c5338a.f23707d = i11 + 1;
            int i12 = c5338a.f23704a;
            m3386a2[i11] = (byte) ((i12 >> 8) & 255);
            int i13 = c5338a.f23707d;
            c5338a.f23707d = i13 + 1;
            m3386a2[i13] = (byte) (i12 & 255);
        } else {
            throw new IllegalStateException("Impossible modulus " + c5338a.f23711h);
        }
    }

    @Override
    void mo3378b(byte[] bArr, int i, int i2, BaseNCodec.C5338a c5338a) {
        if (c5338a.f23709f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = i;
            int i4 = 0;
            while (i4 < i2) {
                byte[] m3386a = m3386a(this.f23697o, c5338a);
                c5338a.f23711h = (c5338a.f23711h + 1) % 3;
                int i5 = i3 + 1;
                int i6 = bArr[i3];
                if (i6 < 0) {
                    i6 += 256;
                }
                c5338a.f23704a = (c5338a.f23704a << 8) + i6;
                if (c5338a.f23711h == 0) {
                    int i7 = c5338a.f23707d;
                    c5338a.f23707d = i7 + 1;
                    byte[] bArr2 = this.f23693k;
                    int i8 = c5338a.f23704a;
                    m3386a[i7] = bArr2[(i8 >> 18) & 63];
                    int i9 = c5338a.f23707d;
                    c5338a.f23707d = i9 + 1;
                    m3386a[i9] = bArr2[(i8 >> 12) & 63];
                    int i10 = c5338a.f23707d;
                    c5338a.f23707d = i10 + 1;
                    m3386a[i10] = bArr2[(i8 >> 6) & 63];
                    int i11 = c5338a.f23707d;
                    c5338a.f23707d = i11 + 1;
                    m3386a[i11] = bArr2[i8 & 63];
                    c5338a.f23710g += 4;
                    int i12 = this.f23702e;
                    if (i12 > 0 && i12 <= c5338a.f23710g) {
                        byte[] bArr3 = this.f23695m;
                        System.arraycopy(bArr3, 0, m3386a, c5338a.f23707d, bArr3.length);
                        c5338a.f23707d += this.f23695m.length;
                        c5338a.f23710g = 0;
                    }
                }
                i4++;
                i3 = i5;
            }
            return;
        }
        c5338a.f23709f = true;
        if (c5338a.f23711h == 0 && this.f23702e == 0) {
            return;
        }
        byte[] m3386a2 = m3386a(this.f23697o, c5338a);
        int i13 = c5338a.f23707d;
        int i14 = c5338a.f23711h;
        if (i14 != 0) {
            if (i14 == 1) {
                c5338a.f23707d = i13 + 1;
                byte[] bArr4 = this.f23693k;
                int i15 = c5338a.f23704a;
                m3386a2[i13] = bArr4[(i15 >> 2) & 63];
                int i16 = c5338a.f23707d;
                c5338a.f23707d = i16 + 1;
                m3386a2[i16] = bArr4[(i15 << 4) & 63];
                if (bArr4 == f23690h) {
                    int i17 = c5338a.f23707d;
                    c5338a.f23707d = i17 + 1;
                    byte b = this.f23699b;
                    m3386a2[i17] = b;
                    int i18 = c5338a.f23707d;
                    c5338a.f23707d = i18 + 1;
                    m3386a2[i18] = b;
                }
            } else if (i14 == 2) {
                c5338a.f23707d = i13 + 1;
                byte[] bArr5 = this.f23693k;
                int i19 = c5338a.f23704a;
                m3386a2[i13] = bArr5[(i19 >> 10) & 63];
                int i20 = c5338a.f23707d;
                c5338a.f23707d = i20 + 1;
                m3386a2[i20] = bArr5[(i19 >> 4) & 63];
                int i21 = c5338a.f23707d;
                c5338a.f23707d = i21 + 1;
                m3386a2[i21] = bArr5[(i19 << 2) & 63];
                if (bArr5 == f23690h) {
                    int i22 = c5338a.f23707d;
                    c5338a.f23707d = i22 + 1;
                    m3386a2[i22] = this.f23699b;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + c5338a.f23711h);
            }
        }
        int i23 = c5338a.f23710g;
        int i24 = c5338a.f23707d;
        c5338a.f23710g = i23 + (i24 - i13);
        if (this.f23702e <= 0 || c5338a.f23710g <= 0) {
            return;
        }
        byte[] bArr6 = this.f23695m;
        System.arraycopy(bArr6, 0, m3386a2, i24, bArr6.length);
        c5338a.f23707d += this.f23695m.length;
    }

    public Base64(boolean z) {
        this(76, f23689g, z);
    }

    public Base64(int i) {
        this(i, f23689g);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f23694l = f23692j;
        if (bArr != null) {
            if (m3383a(bArr)) {
                String m3370b = StringUtils.m3370b(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + m3370b + "]");
            } else if (i > 0) {
                this.f23697o = bArr.length + 4;
                this.f23695m = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.f23695m, 0, bArr.length);
            } else {
                this.f23697o = 4;
                this.f23695m = null;
            }
        } else {
            this.f23697o = 4;
            this.f23695m = null;
        }
        this.f23696n = this.f23697o - 1;
        this.f23693k = z ? f23691i : f23690h;
    }

    /* renamed from: a */
    public static byte[] m3393a(byte[] bArr, boolean z) {
        return m3392a(bArr, z, false);
    }

    /* renamed from: a */
    public static byte[] m3392a(byte[] bArr, boolean z, boolean z2) {
        return m3391a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m3391a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, f23689g, z2);
        long m3375d = base64.m3375d(bArr);
        if (m3375d <= i) {
            return base64.m3377c(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m3375d + ") than the specified maximum size of " + i);
    }

    @Override
    protected boolean mo3387a(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f23694l;
            return b < bArr.length && bArr[b] != -1;
        }
        return false;
    }

    /* renamed from: b */
    public static byte[] m3390b(String str) {
        return new Base64().m3384a(str);
    }
}