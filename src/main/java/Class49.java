/* Class49 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.IOException;
import java.net.Socket;

public class Class49
{
    public static int anInt962 = 0;
    public static RSString aRSString_963
	= Class112.method1668(43, "document)3cookie=(R");
    public int anInt964;
    public static int anInt965;
    public static Interface4 anInterface4_966;
    public byte aByte967;
    public int anInt968;
    public static int anInt969;
    public static byte[][][] aByteArrayArrayArray970;
    public static int anInt971;
    public int anInt972;
    public static int anInt973;
    public static int anInt974;
    public int anInt975;
    public static int anInt976;
    public int anInt977;
    
    public static void method521(boolean bool) {
	if (bool != true)
	    anInterface4_966 = null;
	aByteArrayArrayArray970 = null;
	aRSString_963 = null;
	anInterface4_966 = null;
    }
    
    public int method522(int i) {
	if (i != 7)
	    return -110;
	anInt971++;
	return 0x7 & aByte967;
    }
    
    public int method523(int i) {
	anInt974++;
	if (i != 8)
	    return 97;
	if ((aByte967 & 0x8 ^ 0xffffffff) != -9)
	    return 0;
	return 1;
    }
    
    public static void method524(int i) {
	anInt965++;
	if (Class1.aClass35_66 != null)
	    Class1.aClass35_66.method430((byte) 94);
	if (i == 16322) {
	    if (Class68_Sub13_Sub36.aClass35_4035 != null)
		Class68_Sub13_Sub36.aClass35_4035.method430((byte) 119);
	}
    }
    
    public static void method525(byte i) {
	anInt976++;
	if ((Class68_Sub13_Sub27.anInt3914 ^ 0xffffffff) != -1) {
	    try {
		if (++Class64.anInt1190 > 2000) {
		    if (Class126.aClass61_2190 != null) {
			Class126.aClass61_2190.method594(-47);
			Class126.aClass61_2190 = null;
		    }
		    if (Class88.anInt1602 >= 1) {
			Class50.anInt980 = -5;
			Class68_Sub13_Sub27.anInt3914 = 0;
			return;
		    }
		    Class68_Sub13_Sub27.anInt3914 = 1;
		    if ((Class103.anInt1773 ^ 0xffffffff)
			== (Class115.serverPort ^ 0xffffffff))
			Class103.anInt1773 = Class68_Sub15.anInt3013;
		    else
			Class103.anInt1773 = Class115.serverPort;
		    Class64.anInt1190 = 0;
		    Class88.anInt1602++;
		}
		if (Class68_Sub13_Sub27.anInt3914 == 1) {
		    Class13_Sub2.aClass31_2657 = (Class75_Sub1_Sub1.aSignLink_4589.method559 (Class68_Sub9.serverIP, (byte) 113, Class103.anInt1773));
			System.out.println("Connection in class49");
		    Class68_Sub13_Sub27.anInt3914 = 2;
		}
		if ((Class68_Sub13_Sub27.anInt3914 ^ 0xffffffff) == -3) {
		    if (Class13_Sub2.aClass31_2657.anInt555 == 2)
			throw new IOException();
		    if (Class13_Sub2.aClass31_2657.anInt555 != 1)
			return;
		    Class126.aClass61_2190
			= new Class61(((Socket)
				       Class13_Sub2.aClass31_2657.anObject558),
				      Class75_Sub1_Sub1.aSignLink_4589);
		    Class13_Sub2.aClass31_2657 = null;
		    Class126.aClass61_2190.method590
			(0, (byte) 78,
			 Class21.aPacketStream_466.anInt2945,
			 Class21.aPacketStream_466.aByteArray2960);
		    if (Class68_Sub13_Sub36.aClass35_4035 != null)
			Class68_Sub13_Sub36.aClass35_4035.method418(false);
		    if (Class1.aClass35_66 != null)
			Class1.aClass35_66.method418(false);
		    int i_0_ = Class126.aClass61_2190.method593(55);
		    if (Class68_Sub13_Sub36.aClass35_4035 != null)
			Class68_Sub13_Sub36.aClass35_4035.method418(false);
		    if (Class1.aClass35_66 != null)
			Class1.aClass35_66.method418(false);
		    if ((i_0_ ^ 0xffffffff) != -22) {
			Class68_Sub13_Sub27.anInt3914 = 0;
			Class50.anInt980 = i_0_;
			Class126.aClass61_2190.method594(-89);
			Class126.aClass61_2190 = null;
			return;
		    }
		    Class68_Sub13_Sub27.anInt3914 = 3;
		}
		if (i < 5)
		    method524(110);
		if ((Class68_Sub13_Sub27.anInt3914 ^ 0xffffffff) == -4) {
		    if ((Class126.aClass61_2190.method597((byte) 102)
			 ^ 0xffffffff)
			> -2)
			return;
		    Class68_Sub8.aRSStringArray2872
			= new RSString[Class126.aClass61_2190.method593(114)];
		    Class68_Sub13_Sub27.anInt3914 = 4;
		}
		if (Class68_Sub13_Sub27.anInt3914 == 4) {
		    if (Class126.aClass61_2190.method597((byte) 102)
			>= Class68_Sub8.aRSStringArray2872.length * 8) {
			Class68_Sub13_Sub8.aPacketStream_3560.anInt2945
			    = 0;
			Class126.aClass61_2190.method591
			    (3, 8 * Class68_Sub8.aRSStringArray2872.length, 0,
			     (Class68_Sub13_Sub8.aPacketStream_3560
			      .aByteArray2960));
			for (int i_1_ = 0;
			     i_1_ < Class68_Sub8.aRSStringArray2872.length;
			     i_1_++)
			    Class68_Sub8.aRSStringArray2872[i_1_]
				= (Class56.method570
				   (Class68_Sub13_Sub8
					.aPacketStream_3560
					.method941(88),
				    -1));
			Class50.anInt980 = 21;
			Class68_Sub13_Sub27.anInt3914 = 0;
			Class126.aClass61_2190.method594(-25);
			Class126.aClass61_2190 = null;
		    }
		}
	    } catch (IOException ioexception) {
		if (Class126.aClass61_2190 != null) {
		    Class126.aClass61_2190.method594(-119);
		    Class126.aClass61_2190 = null;
		}
		if ((Class88.anInt1602 ^ 0xffffffff) <= -2) {
		    Class50.anInt980 = -4;
		    Class68_Sub13_Sub27.anInt3914 = 0;
		} else {
		    if (Class103.anInt1773 != Class115.serverPort)
			Class103.anInt1773 = Class115.serverPort;
		    else
			Class103.anInt1773 = Class68_Sub15.anInt3013;
		    Class68_Sub13_Sub27.anInt3914 = 1;
		    Class88.anInt1602++;
		    Class64.anInt1190 = 0;
		}
	    }
	}
    }
    
    public static void method526(boolean bool, boolean bool_2_) {
	anInt973++;
	byte[][] is = Class23.aByteArrayArray490;
	int i = 4;
	int i_3_ = is.length;
	for (int i_4_ = 0; (i_4_ ^ 0xffffffff) > (i_3_ ^ 0xffffffff); i_4_++) {
	    int i_5_ = (-Class36.anInt643
			+ (Class119.anIntArray2089[i_4_] >> 567718824) * 64);
	    int i_6_ = (-Class68_Sub13_Sub35.anInt4026
			+ (Class119.anIntArray2089[i_4_] & 0xff) * 64);
	    byte[] is_7_ = is[i_4_];
	    if (is_7_ != null) {
		method524(16322);
		Class1.method62(i_6_, is_7_, i_5_, bool, -4,
				8 * (-6 + Class43.anInt732),
				ItemDef.anInt365 * 8 - 48,
				Class109.aClass38Array1843);
	    }
	}
	int i_8_ = 0;
	if (bool_2_ != false)
	    aByteArrayArrayArray970 = null;
	for (/**/; i_8_ < i_3_; i_8_++) {
	    int i_9_ = (64 * (0xff & Class119.anIntArray2089[i_8_])
			+ -Class68_Sub13_Sub35.anInt4026);
	    byte[] is_10_ = is[i_8_];
	    int i_11_ = (64 * (Class119.anIntArray2089[i_8_] >> 1005714728)
			 + -Class36.anInt643);
	    if (is_10_ == null && Class43.anInt732 < 800) {
		method524(16322);
		for (int i_12_ = 0; (i ^ 0xffffffff) < (i_12_ ^ 0xffffffff);
		     i_12_++)
		    Class68_Sub13_Sub37.method893(64, -73, 64, i_12_, i_9_,
						  i_11_);
	    }
	}
    }
    
    public Class49() {
	/* empty */
    }
    
    public Class49(Stream class68_sub14) {
	aByte967 = class68_sub14.method955(3390);
	anInt964 = class68_sub14.readUnsignedWord(1355769544);
	anInt977 = class68_sub14.readDWord();
	anInt968 = class68_sub14.readDWord();
	anInt972 = class68_sub14.readDWord();
	anInt975 = class68_sub14.readDWord();
    }
}
