/* Stream - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.math.BigInteger;

public class Stream extends Class68
{
    public int anInt2945;
    public static int anInt2946;
    public static int anInt2947;
    public static int anInt2948;
    public static int anInt2949;
    public static int anInt2950;
    public static int anInt2951;
    public static int anInt2952;
    public static int anInt2953;
    public static int anInt2954;
    public static int anInt2955;
    public static int anInt2956;
    public static int anInt2957;
    public static int anInt2958;
    public static int anInt2959;
    public byte[] aByteArray2960;
    public static int anInt2961;
    public static int anInt2962;
    public static int anInt2963;
    public static int anInt2964;
    public static int anInt2965;
    public static int anInt2966;
    public static int anInt2967;
    public static int anInt2968;
    public static int anInt2969;
    public static int anInt2970;
    public static int anInt2971;
    public static int anInt2972;
    public static int anInt2973;
    public static int anInt2974;
    public static int anInt2975;
    public static int anInt2976;
    public static int anInt2977;
    public static int anInt2978;
    public static int anInt2979;
    public static int anInt2980;
    public static int anInt2981;
    public static int anInt2982;
    public static int anInt2983;
    public static boolean aBoolean2984 = false;
    public static int anInt2985;
    public static int anInt2986;
    public static int anInt2987;
    public static int anInt2988;
    public static int anInt2989;
    public static int anInt2990;
    public static int anInt2991;
    public static int anInt2992;
    public static int anInt2993;
    public static Class68_Sub17 aClass68_Sub17_2994 = new Class68_Sub17(0, 0);
    public static int anInt2995;
    public static int anInt2996;
    public static int anInt2997;
    public static int anInt2998;
    public static int anInt2999;
    public static int anInt3000;
    public static int anInt3001;
    public static int anInt3002;
    public static int anInt3003;
    public static int anInt3004;
    public static int[] anIntArray3005;
    public static Class68_Sub20_Sub10_Sub1[] aClass68_Sub20_Sub10_Sub1Array3006;
    public static int anInt3007;
    public static Class113 aClass113_3008 = new Class113(4096);
    public static Class113 aClass113_3009;
    public static Class92[] aClass92Array3010;
    
    public long method908(int i, byte i_0_) {
	i--;
	int i_1_ = 67 % ((28 - i_0_) / 39);
	anInt2986++;
	if ((i ^ 0xffffffff) > -1 || i > 7)
	    throw new IllegalArgumentException();
	int i_2_ = i * 8;
	long l = 0L;
	for (/**/; (i_2_ ^ 0xffffffff) <= -1; i_2_ -= 8)
	    l |= ((long) aByteArray2960[anInt2945++] & 0xffL) << i_2_;
	return l;
    }
    
    public int readUnsignedWordBigEndian(int i) {
	anInt2945 += 2;
	anInt2950++;
	return (((0xff & aByteArray2960[anInt2945 - 1]) << -1387447512) + (aByteArray2960[anInt2945 - 2] & 0xff));
    }
    
    public RSString readString(int i) {
	anInt2972++;
	int i_4_ = anInt2945;
	while ((aByteArray2960[anInt2945++] ^ 0xffffffff) != -1) {
	    /* empty */
	}
	return Class68_Sub13_Sub27.method842(-i_4_ + (anInt2945 - 1), aByteArray2960, i ^ 0x10, i_4_);
    }
    
    public void writeByte(int i, int i_5_) {
	aByteArray2960[anInt2945++] = (byte) i_5_;
	anInt2985++;
    }
    
    public int method912(int i) {
	anInt2975++;
	int i_6_ = aByteArray2960[anInt2945] & i;
	if (i_6_ < 128)
	    return readUnsignedByte(-6677);
	return -32768 + readUnsignedWord(i + 1355769289);
    }
    
    public void writeDWord_v1(byte i, int i_7_) {
	aByteArray2960[anInt2945++] = (byte) (i_7_ >> -2017770840);
	aByteArray2960[anInt2945++] = (byte) i_7_;
	aByteArray2960[anInt2945++] = (byte) (i_7_ >> -1565653576);
	aByteArray2960[anInt2945++] = (byte) (i_7_ >> 1786657648);
	anInt2973++;
    }
    
    public void method914(byte i, RSString class100) {
	if (i == -9) {
	    anInt2965++;
	    anInt2945 += class100.method1611(anInt2945, i + 264, class100.method1590((byte) -113), 0, aByteArray2960);
	    aByteArray2960[anInt2945++] = (byte) 0;
	}
    }
    
    public int readUnsignedWordA() {
	anInt2967++;
	anInt2945 += 2;
	return (((aByteArray2960[anInt2945 - 2] & 0xff) << 8) + (0xff & aByteArray2960[anInt2945 - 1] - 128));
    }
    
    public void method916(long l, int i, int i_8_) {
	try {
	    i_8_--;
	    anInt2968++;
	    if ((i_8_ ^ 0xffffffff) > -1 || i_8_ > 7)
		throw new IllegalArgumentException();
	    if (i >= -106)
		method938(-115, 77, 125, null);
	    for (int i_9_ = 8 * i_8_; i_9_ >= 0; i_9_ -= 8)
		aByteArray2960[anInt2945++] = (byte) (int) (l >> i_9_);
	} catch (RuntimeException runtimeexception) {
	    throw Class107.method1652(runtimeexception, ("lh.MA(" + l + ',' + i
							 + ',' + i_8_ + ')'));
	}
    }
    
    public byte method917(boolean bool) {
	if (bool != false)
	    aByteArray2960 = null;
	anInt3004++;
	return (byte) -aByteArray2960[anInt2945++];
    }
    
    public void method918(int i, boolean bool) {
	aByteArray2960[anInt2945++] = (byte) (i >> -282453968);
	anInt2970++;
	aByteArray2960[anInt2945++] = (byte) (i >> -1827586328);
	aByteArray2960[anInt2945++] = (byte) i;
	if (bool != false)
	    anIntArray3005 = null;
    }
    
    public Stream(int i) {
	aByteArray2960 = Class33.method412(i, (byte) -85);
	anInt2945 = 0;
    }
    
    public byte method919(byte i) {
	anInt2961++;
	if (i <= 22)
	    method937(true);
	return (byte) (aByteArray2960[anInt2945++] - 128);
    }
    
    public int method920(int i, int i_10_) {
	int i_11_ = 43 % ((i_10_ - 59) / 43);
	anInt2948++;
	int i_12_ = Class64.method622(anInt2945, false, i, aByteArray2960);
	writeDWord(544537784, i_12_);
	return i_12_;
    }
    
    public int method921(byte i) {
	anInt2945 += 3;
	anInt2955++;
	int i_13_ = 78 / (-i / 42);
	return ((aByteArray2960[anInt2945 + -1] & 0xff)
		+ (aByteArray2960[anInt2945 + -3] << -1337350736 & 0xff0000)
		- -((0xff & aByteArray2960[-2 + anInt2945]) << -1317980984));
    }
    
    public void writeByteC(int i_14_) {
	aByteArray2960[anInt2945++] = (byte) -i_14_;
	anInt2978++;
    }
    
    public void writeWord(boolean bool, int i) {
	aByteArray2960[anInt2945++] = (byte) (i >> -870131448);
	aByteArray2960[anInt2945++] = (byte) i;
	anInt2966++;
    }
    
    public void method924(boolean bool, long l) {
	try {
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> 521528504);
	    if (bool != true)
		method912(-50);
	    anInt2992++;
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> 1869536624);
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> 1583085800);
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> -1133298784);
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> -820696616);
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> 138189072);
	    aByteArray2960[anInt2945++] = (byte) (int) (l >> 1096640776);
	    aByteArray2960[anInt2945++] = (byte) (int) l;
	} catch (RuntimeException runtimeexception) {
	    throw Class107.method1652(runtimeexception,
				      "lh.F(" + bool + ',' + l + ')');
	}
    }

    public int readDWord() {
	anInt2991++;
	anInt2945 += 4;
	return ((aByteArray2960[anInt2945 - 1] & 0xff) + ((aByteArray2960[anInt2945 - 3] << 16 & 0xff0000) + (((aByteArray2960[anInt2945 - 4] & 0xff) << 24) + (aByteArray2960[anInt2945 - 2] << 8 & 0xff00))));
    }
    
    public void method926(int i, long l) {
	try {
	    anInt2969++;
	    if (i != 128)
		anIntArray3005 = null;
	    writeDWordBigEndian((byte) 127, (int) (l >> -41780448));
	    writeDWordBigEndian((byte) 127, (int) l);
	} catch (RuntimeException runtimeexception) {
	    throw Class107.method1652(runtimeexception,
				      "lh.PA(" + i + ',' + l + ')');
	}
    }
    
    public int method927(boolean bool) {
	anInt2947++;
	if (bool != true)
	    return 89;
	int i = aByteArray2960[anInt2945++];
	int i_16_ = 0;
	for (/**/; i < 0; i = aByteArray2960[anInt2945++])
	    i_16_ = (i_16_ | 0x7f & i) << -731912441;
	return i | i_16_;
    }
    
    public Stream(byte[] is) {
	aByteArray2960 = is;
	anInt2945 = 0;
    }
    
    public int readDWord_v1() {
	anInt2971++;
	anInt2945 += 4;
	return ((aByteArray2960[anInt2945 - 1] << 16 & 0xff0000) + ((~0xffffff & aByteArray2960[anInt2945 - 2] << 1242983576) + ((aByteArray2960[anInt2945 - 4] & 0xff) << 8) + (0xff & aByteArray2960[anInt2945 - 3])));
    }
    
    public void writeWordBigEndian(int i, byte i_17_) {
	aByteArray2960[anInt2945++] = (byte) i;
	aByteArray2960[anInt2945++] = (byte) (i >> -678861656);
	anInt3002++;
    }
    
    public int method930(boolean bool) {
	anInt2945 += 3;
	if (bool != false)
	    aBoolean2984 = true;
	anInt3000++;
	return (((aByteArray2960[anInt2945 + -2] & 0xff) << 798639568)
		+ ((aByteArray2960[anInt2945 + -3] << -1935278584 & 0xff00)
		   - -(aByteArray2960[anInt2945 - 1] & 0xff)));
    }
    
    public void writeByteA(int i, int i_18_) {
	anInt3003++;
	aByteArray2960[anInt2945++] = (byte) (i_18_ + 128);
    }
    
    public int readDWord_v2(boolean bool) {
	anInt2962++;
	anInt2945 += 4;
	return (((aByteArray2960[anInt2945 - 3] & 0xff) << 357099128) + ((aByteArray2960[anInt2945 - 4] & 0xff) << -772724656) + (((0xff & aByteArray2960[anInt2945 - 1]) << -63088472) + (aByteArray2960[anInt2945 - 2] & 0xff)));
    }
    
    public void method933(boolean bool, BigInteger biginteger, BigInteger biginteger_19_) {
	try {
	    anInt2995++;
	    int i = anInt2945;
	    byte[] is = new byte[i];
	    anInt2945 = 0;
	    method938(0, 0, i, is);
	    BigInteger biginteger_20_ = new BigInteger(is);
	    if (bool != false)
		aClass68_Sub17_2994 = null;
	    BigInteger biginteger_21_ = biginteger_20_; //.modPow(biginteger, biginteger_19_);
	    byte[] is_22_ = biginteger_21_.toByteArray();
	    anInt2945 = 0;
	    writeByte(32, is_22_.length);
	    method942(is_22_.length, (byte) 118, 0, is_22_);
	} catch (RuntimeException runtimeexception) {
	    throw Class107.method1652(runtimeexception,
				      ("lh.UA(" + bool + ','
				       + (biginteger != null ? "{...}"
					  : "null")
				       + ','
				       + (biginteger_19_ != null ? "{...}"
					  : "null")
				       + ')'));
	}
    }
    
    public static void method934(int i, Class21 class21) {
	Class75_Sub1_Sub1.aClass21_4586 = class21;
	if (i > -73)
	    method962(true);
	anInt2974++;
    }
    
    public void method935(int i, int i_23_) {
	anInt2990++;
	if (i_23_ >= 118)
	    aByteArray2960[-1 + (anInt2945 - i)] = (byte) i;
    }
    
    public void method936(int i, int i_24_) {
	anInt2979++;
	if (i_24_ != 9684)
	    writeDWord_v1((byte) 121, 105);
	if ((i & ~0x7f) != 0) {
	    if ((i & ~0x3fff) != 0) {
		if ((~0x1fffff & i) != 0) {
		    if ((i & ~0xfffffff ^ 0xffffffff) != -1)
			writeByte(32, i >>> 1990185980 | 0x80);
		    writeByte(32, i >>> 1886938837 | 0x80);
		}
		writeByte(i_24_ + -9652, (i | 0x2017fc) >>> 744113902);
	    }
	    writeByte(32, i >>> -2144201945 | 0x80);
	}
	writeByte(i_24_ + -9652, i & 0x7f);
    }
    
    public int method937(boolean bool) {
	anInt2993++;
	int i = 0;
	int i_25_ = method912(255);
	if (bool != true)
	    return -6;
	for (/**/; i_25_ == 32767; i_25_ = method912(255))
	    i += 32767;
	i += i_25_;
	return i;
    }
    
    public void method938(int i, int i_26_, int i_27_, byte[] is) {
	anInt2976++;
	for (int i_28_ = i; i_28_ < i + i_27_; i_28_++)
	    is[i_28_] = aByteArray2960[anInt2945++];
	if (i_26_ != 0)
	    writeDWord_v1((byte) -5, 85);
    }
    
    public void writeDWord(int i, int i_29_) {
	anInt2964++;
	aByteArray2960[anInt2945++] = (byte) (i_29_ >> 544537784);
	aByteArray2960[anInt2945++] = (byte) (i_29_ >> 322362640);
	aByteArray2960[anInt2945++] = (byte) (i_29_ >> 680567848);
	aByteArray2960[anInt2945++] = (byte) i_29_;
    }
    
    public int method940(byte i) {
	anInt2956++;
	anInt2945 += 4;
	if (i < 87)
	    return 41;
	return ((aByteArray2960[anInt2945 - 1] << 269458744 & ~0xffffff)
		+ ((aByteArray2960[anInt2945 - 2] << -1234080752 & 0xff0000)
		   - (-(aByteArray2960[anInt2945 - 3] << -1038016920 & 0xff00)
		      + -(aByteArray2960[anInt2945 + -4] & 0xff))));
    }
    
    public long method941(int i) {
	anInt2989++;
	if (i < 27)
	    aClass68_Sub20_Sub10_Sub1Array3006 = null;
	long l = 0xffffffffL & (long) readDWord();
	long l_30_ = (long) readDWord() & 0xffffffffL;
	return l_30_ + (l << -2097004448);
    }
    
    public void method942(int i, byte i_31_, int i_32_, byte[] is) {
	anInt2988++;
	if (i_31_ != 118)
	    aBoolean2984 = true;
	for (int i_33_ = i_32_; i_32_ + i > i_33_; i_33_++)
	    aByteArray2960[anInt2945++] = is[i_33_];
    }
    
    public static void method943(boolean bool, int i) {
	if (i != 37) {
	    if ((i ^ 0xffffffff) != -51) {
		if (i != 75)
		    Class68_Sub13_Sub27.aFloat3913 = 8.0F;
		else
		    Class68_Sub13_Sub27.aFloat3913 = 6.0F;
	    } else
		Class68_Sub13_Sub27.aFloat3913 = 4.0F;
	} else
	    Class68_Sub13_Sub27.aFloat3913 = 3.0F;
	if (bool == false) {
	    Class68_Sub22.anInt3145 = -1;
	    Class68_Sub22.anInt3145 = -1;
	    anInt2959++;
	}
    }
    
    public void writeWordA(int i, int i_34_) {
	anInt2987++;
	aByteArray2960[anInt2945++] = (byte) (i >> -1905447096);
	aByteArray2960[anInt2945++] = (byte) (i + 128);
    }
    
    public int readUnsignedByteA() {
	anInt2981++;
	return aByteArray2960[anInt2945++] - 128 & 0xff;
    }
    
    public void method946(int[] is, int i, int i_35_, byte i_36_) {
	anInt2949++;
	int i_37_ = (i_35_ - i) / 8;
	int i_38_ = anInt2945;
	if (i_36_ <= 76)
	    method960(108);
	anInt2945 = i;
	for (int i_39_ = 0; i_39_ < i_37_; i_39_++) {
	    int i_40_ = readDWord();
	    int i_41_ = readDWord();
	    int i_42_ = -957401312;
	    int i_43_ = -1640531527;
	    int i_44_ = 32;
	    while ((i_44_-- ^ 0xffffffff) < -1) {
		i_41_ -= ((i_40_ >>> -1563092443 ^ i_40_ << 611091524) - -i_40_
			  ^ i_42_ + is[i_42_ >>> -1002502837 & 0x56c00003]);
		i_42_ -= i_43_;
		i_40_ -= ((i_41_ >>> 1337206757 ^ i_41_ << 363118692) - -i_41_
			  ^ i_42_ + is[i_42_ & 0x3]);
	    }
	    anInt2945 -= 8;
	    writeDWord(544537784, i_40_);
	    writeDWord(544537784, i_41_);
	}
	anInt2945 = i_38_;
    }
    
    public int readUnsignedWord(int i) {
	anInt2945 += 2;
	anInt2977++;
	return (((aByteArray2960[anInt2945 - 2] & 0xff) << 8) + (aByteArray2960[anInt2945 - 1] & 0xff));
    }
    
    public RSString method948(int i) {
	if (i != 23733)
	    return null;
	anInt2953++;
	if (aByteArray2960[anInt2945] == 0) {
	    anInt2945++;
	    return null;
	}
	return readString(i ^ 0x5cca);
    }
    
    public int readUnsignedByteS() {
	anInt3001++;
	return 128 - aByteArray2960[anInt2945++] & 0xff;
    }
    
    public int readUnsignedByte(int i) {
	anInt2963++;
	return 0xff & aByteArray2960[anInt2945++];
    }
    
    public void method951(int i, int i_45_) {
	if (i_45_ < -94) {
	    anInt2999++;
	    aByteArray2960[-i + (anInt2945 - 4)] = (byte) (i >> 759933560);
	    aByteArray2960[-3 + anInt2945 - i] = (byte) (i >> 520407888);
	    aByteArray2960[-2 + (anInt2945 + -i)] = (byte) (i >> -1078182744);
	    aByteArray2960[-i + (anInt2945 - 1)] = (byte) i;
	}
    }
    
    public void method952(BigInteger biginteger, byte i,
			  BigInteger biginteger_46_) {
	try {
	    anInt2946++;
	    int i_47_ = readUnsignedByte(-6677);
	    byte[] is = new byte[i_47_];
	    method938(0, 0, i_47_, is);
	    BigInteger biginteger_48_ = new BigInteger(is);
	    BigInteger biginteger_49_
		= biginteger_48_.modPow(biginteger, biginteger_46_);
	    if (i != -88)
		aClass113_3008 = null;
	    byte[] is_50_ = biginteger_49_.toByteArray();
	    anInt2945 = 0;
	    method942(is_50_.length, (byte) 118, 0, is_50_);
	} catch (RuntimeException runtimeexception) {
	    throw Class107.method1652(runtimeexception,
				      ("lh.N("
				       + (biginteger != null ? "{...}"
					  : "null")
				       + ',' + i + ','
				       + (biginteger_46_ != null ? "{...}"
					  : "null")
				       + ')'));
	}
    }
    
    public void writeByteS(int i_51_) {
	anInt2997++;
	aByteArray2960[anInt2945++] = (byte) (-i_51_ + 128);
    }
    
    public void writeDWord_v2(int i, int i_52_) {
	anInt2982++;
	aByteArray2960[anInt2945++] = (byte) (i_52_ >> -925760816);
	aByteArray2960[anInt2945++] = (byte) (i_52_ >> 1324535448);
	aByteArray2960[anInt2945++] = (byte) i_52_;
	aByteArray2960[anInt2945++] = (byte) (i_52_ >> -4948312);
    }
    
    public byte method955(int i) {
	anInt2998++;
	return aByteArray2960[anInt2945++];
    }
    
    public void method956(int i, int i_53_) {
	anInt2951++;
	if (i_53_ >= (i ^ 0xffffffff) && (i ^ 0xffffffff) > -129)
	    writeByte(32, i);
	else if (i >= 0 && (i ^ 0xffffffff) > -32769)
	    writeWord(false, i + 32768);
	else
	    throw new IllegalArgumentException();
    }
    
    public int method957(int i) {
	anInt2957++;
	if (i != -22489)
	    return -87;
	anInt2945 += 2;
	int i_54_
	    = ((0xff & aByteArray2960[-1 + anInt2945])
	       + (0xff00 & aByteArray2960[-2 + anInt2945] << -1713538328));
	if (i_54_ > 32767)
	    i_54_ -= 65536;
	return i_54_;
    }
    
    public void writeWordBigEndianA(byte i, int i_55_) {
	anInt2983++;
	aByteArray2960[anInt2945++] = (byte) (128 + i_55_);
	aByteArray2960[anInt2945++] = (byte) (i_55_ >> -1544045528);
    }
    
    public void writeDWordBigEndian(byte i, int i_56_) {
	anInt2952++;
	aByteArray2960[anInt2945++] = (byte) i_56_;
	aByteArray2960[anInt2945++] = (byte) (i_56_ >> 1279827400);
	aByteArray2960[anInt2945++] = (byte) (i_56_ >> -882770384);
	aByteArray2960[anInt2945++] = (byte) (i_56_ >> 1432242680);
    }
    
    public int method960(int i) {
	if (i != 32767)
	    return 90;
	int i_57_ = aByteArray2960[anInt2945] & 0xff;
	anInt2958++;
	if ((i_57_ ^ 0xffffffff) > -129)
	    return readUnsignedByte(-6677) - 64;
	return -49152 + readUnsignedWord(1355769544);
    }
    
    public int readUnsignedByteC() {
	anInt2996++;
	return -aByteArray2960[anInt2945++] & 0xff;
    }
    
    public static void method962(boolean bool) {
	anIntArray3005 = null;
	aClass68_Sub20_Sub10_Sub1Array3006 = null;
	aClass92Array3010 = null;
	aClass113_3009 = null;
	aClass113_3008 = null;
	aClass68_Sub17_2994 = null;
	if (bool != false)
	    method962(true);
    }
    
    public int readUnsignedWordBigEndianA() {
	anInt2980++;
	anInt2945 += 2;
	return (((aByteArray2960[anInt2945 - 1] & 0xff) << 8) + (aByteArray2960[anInt2945 - 2] - 128 & 0xff));
    }
}
