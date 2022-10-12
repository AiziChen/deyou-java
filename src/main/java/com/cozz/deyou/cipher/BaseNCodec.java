package com.cozz.deyou.cipher;

import com.cozz.deyou.utils.StringUtils;

import java.util.Arrays;

public abstract class BaseNCodec {
    @Deprecated

    /* renamed from: b */
    protected final byte f23699b;

    /* renamed from: c */
    private final int f23700c;

    /* renamed from: d */
    private final int f23701d;

    /* renamed from: e */
    protected final int f23702e;

    /* renamed from: f */
    private final int f23703f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseNCodec.java */
    /* renamed from: com.tangran.diaodiao.lib.b.a.a.b$a */
    /* loaded from: classes2.dex */
    public static class C5338a {

        /* renamed from: a */
        int f23704a;

        /* renamed from: b */
        long f23705b;

        /* renamed from: c */
        byte[] f23706c;

        /* renamed from: d */
        int f23707d;

        /* renamed from: e */
        int f23708e;

        /* renamed from: f */
        boolean f23709f;

        /* renamed from: g */
        int f23710g;

        /* renamed from: h */
        int f23711h;

        C5338a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", C5338a.class.getSimpleName(), Arrays.toString(this.f23706c), Integer.valueOf(this.f23710g), Boolean.valueOf(this.f23709f), Integer.valueOf(this.f23704a), Long.valueOf(this.f23705b), Integer.valueOf(this.f23711h), Integer.valueOf(this.f23707d), Integer.valueOf(this.f23708e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (byte) 61);
    }

    /* renamed from: b */
    private byte[] m3380b(C5338a c5338a) {
        byte[] bArr = c5338a.f23706c;
        if (bArr == null) {
            c5338a.f23706c = new byte[8192];
            c5338a.f23707d = 0;
            c5338a.f23708e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            c5338a.f23706c = bArr2;
        }
        return c5338a.f23706c;
    }

    /* renamed from: a */
    int m3385a(C5338a c5338a) {
        if (c5338a.f23706c != null) {
            return c5338a.f23707d - c5338a.f23708e;
        }
        return 0;
    }

    /* renamed from: a */
    abstract void mo3381a(byte[] bArr, int i, int i2, C5338a c5338a);

    /* renamed from: a */
    protected abstract boolean mo3387a(byte b);

    /* renamed from: b */
    abstract void mo3378b(byte[] bArr, int i, int i2, C5338a c5338a);

    /* renamed from: c */
    int m3376c(byte[] bArr, int i, int i2, C5338a c5338a) {
        if (c5338a.f23706c == null) {
            return c5338a.f23709f ? -1 : 0;
        }
        int min = Math.min(m3385a(c5338a), i2);
        System.arraycopy(c5338a.f23706c, c5338a.f23708e, bArr, i, min);
        c5338a.f23708e += min;
        if (c5338a.f23708e >= c5338a.f23707d) {
            c5338a.f23706c = null;
        }
        return min;
    }

    /* renamed from: d */
    public long m3375d(byte[] bArr) {
        int length = bArr.length;
        int i = this.f23700c;
        long j = (long) (((length + i) - 1) / i) * this.f23701d;
        int i2 = this.f23702e;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f23703f) : j;
    }

    protected BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        this.f23700c = i;
        this.f23701d = i2;
        this.f23702e = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.f23703f = i4;
        this.f23699b = b;
    }

    public byte[] m3386a(int i, C5338a c5338a) {
        byte[] bArr = c5338a.f23706c;
        return (bArr == null || bArr.length < c5338a.f23707d + i) ? m3380b(c5338a) : bArr;
    }


    /* renamed from: a */
    public byte[] m3384a(String str) {
        return m3379b(StringUtils.m3374a(str));
    }


    /* renamed from: a */
    public byte[] m3382a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5338a c5338a = new C5338a();
        mo3378b(bArr, i, i2, c5338a);
        mo3378b(bArr, i, -1, c5338a);
        byte[] bArr2 = new byte[c5338a.f23707d - c5338a.f23708e];
        m3376c(bArr2, 0, bArr2.length, c5338a);
        return bArr2;
    }

    /* renamed from: c */
    public byte[] m3377c(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : m3382a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public byte[] m3379b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5338a c5338a = new C5338a();
        mo3381a(bArr, 0, bArr.length, c5338a);
        mo3381a(bArr, 0, -1, c5338a);
        byte[] bArr2 = new byte[c5338a.f23707d];
        m3376c(bArr2, 0, bArr2.length, c5338a);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3383a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (this.f23699b == b || mo3387a(b)) {
                return true;
            }
        }
        return false;
    }
}