/* Applet_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.URL;
import java.io.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class Applet_Sub1 extends Applet
        implements Runnable, FocusListener, WindowListener {
    public static int anInt1;
    public static int anInt2;
    public static int anInt3;
    public static int anInt4;
    public static int anInt5;
    public boolean aBoolean6 = false;
    public static int anInt7;
    public static int anInt8;
    public static int anInt9;
    public static int anInt10;
    public static int anInt11;
    public static int anInt12;
    public static int anInt13;
    public static int anInt14;
    public static int anInt15;
    public static int anInt16;
    public static RSString aRSString_17
            = (Class112.method1668
            (43, "http:)4)4advert)3runescape)3com)4banner)3ws?size=729"));
    public static int anInt18;
    public static int anInt19;
    public static int anInt20;
    public static int anInt21;
    public static int anInt22;
    public static int anInt23;
    public static int anInt24;
    public static int anInt25;
    public static int anInt26;
    public static int anInt27;
    public static int anInt28;
    public static int anInt29;
    public static int anInt30;
    public static RSString aRSString_31;
    public static int anInt32;
    public static RSString aRSString_33
            = (Class112.method1668
            (43, "; Expires=Thu)1 01)2Jan)21970 00:00:00 GMT; Max)2Age=0"));
    public static int anInt34;
    public static int anInt35;
    public static RSString aRSString_36 = Class112.method1668(43, "titlebg");
    public static int anInt37;
    public static int anInt38;
    public static int anInt39;
    public static int anInt40;
    public static int anInt41;
    public static boolean aBoolean42;
    public static boolean aBoolean43;
    public static boolean aBoolean44;

    public abstract void method15(byte i);

    public synchronized void paint(Graphics graphics) {
        anInt12++;
        if (this == Class69.anApplet_Sub1_1241 && !Class126.aBoolean2185) {
            Class103.aBoolean1762 = true;
            if (SignLink.aString1058 != null
                    && SignLink.aString1058.startsWith("1.5")
                    && Class36.method438(17161) - Class15.aLong248 > 1000L) {
                Rectangle rectangle = graphics.getClipBounds();
                if (rectangle == null
                        || (rectangle.width >= Class68_Sub20_Sub17.anInt4437
                        && (rectangle.height ^ 0xffffffff) <= (Class21.anInt479
                        ^ 0xffffffff)))
                    Class68_Sub13_Sub21.aBoolean3796 = true;
            }
        }
    }

    public void focusLost(FocusEvent focusevent) {
        Class69.aBoolean1233 = false;
        anInt15++;
    }

    public void windowDeactivated(WindowEvent windowevent) {
        anInt32++;
    }

    public void windowClosed(WindowEvent windowevent) {
        anInt9++;
    }

    public void run() {
        anInt30++;
        try {
            if (SignLink.aString1036 != null) {
                String string = SignLink.aString1036.toLowerCase();
                if (string.indexOf("sun") == -1
                        && (string.indexOf("apple") ^ 0xffffffff) == 0) {
                    if (string.indexOf("ibm") != -1
                            && (SignLink.aString1058 == null
                            || SignLink.aString1058.equals("1.4.2"))) {
                        method16(690, "wrongjava");
                        return;
                    }
                } else {
                    String string_0_ = SignLink.aString1058;
                    if (string_0_.equals("1.1") || string_0_.startsWith("1.1.")
                            || string_0_.equals("1.2")
                            || string_0_.startsWith("1.2.")) {
                        method16(690, "wrongjava");
                        return;
                    }
                    Class109.anInt1839 = 5;
                }
            }
            if (Class75_Sub1_Sub1.aSignLink_4589.anApplet1042 != null) {
                Method method = SignLink.aMethod1044;
                if (method != null) {
                    try {
                        method.invoke((Class75_Sub1_Sub1.aSignLink_4589
                                        .anApplet1042),
                                new Object[]{Boolean.TRUE});
                    } catch (Throwable throwable) {
            /* empty */
                    }
                }
            }
            method31((byte) -104);
            Class1_Sub5.aClass72_2496
                    = Class28.method396(Class86.aCanvas1585,
                    Class13_Sub3.anInt2668,
                    Class68_Sub13_Sub9.anInt3568, -115);
            method27(-1);
            Class68_Sub20_Sub13.aClass50_4364 = Class72.method1361(-86);
            while ((Class16.aLong277 ^ 0xffffffffffffffffL) == -1L
                    || ((Class36.method438(17161) ^ 0xffffffffffffffffL)
                    > (Class16.aLong277 ^ 0xffffffffffffffffL))) {
                Class68_Sub13_Sub22.anInt3810
                        = (Class68_Sub20_Sub13.aClass50_4364.method532
                        (Class109.anInt1839, -19, Class76.anInt1345));
                for (int i = 0;
                     ((i ^ 0xffffffff)
                             > (Class68_Sub13_Sub22.anInt3810 ^ 0xffffffff));
                     i++)
                    method30((byte) -71);
                method25(-16633);
                Canvas_Sub1.method46(Class75_Sub1_Sub1.aSignLink_4589,
                        Class86.aCanvas1585, (byte) -108);
            }
        } catch (Exception exception) {
            Class71.method1339(null, exception, 38);
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            method16(690, "crash");
        }
        method20(true, 1000);
    }

    public void method16(int i, String string) {
        anInt20++;
        if (!aBoolean6) {
            aBoolean6 = true;
            if (i == 690) {
                // System.out.println("error_game_" + string);
                String moreinfo;
                if (string.equals("js5connect")) {
                    moreinfo = "The client could not connect to the server.\r\nVisit www.iceyyscape.com for server status.";
                } else if (string.equals("wrongjava")) {
                    moreinfo = "You need a recent version of Java to play.\r\nUpgrade your current version of Java by going to Java.com.";
                } else if (string.equals("crash")) {
                    moreinfo = "The game crashed. This could be due to a server or client error.";
                } else if (string.equals("alreadyloaded")) {
                    moreinfo = "The game client is already loaded.\r\nOnly load it once at a time.";
                } else if (string.equals("invalidhost")) {
                    moreinfo = "You are not allowed to connect to that server.";
                } else if (string.equals("js5io")) {
                    moreinfo = "There was an error while communicating with the update server.\r\nPlease try again, or check your update server.";
                } else if (string.equals("js5connect_outofdate")) {
                    moreinfo = "Your client is out of date. To be able to play you must upgrade.";
                } else {
                    moreinfo = "No extra information about this error available.";
                }
                JOptionPane.showMessageDialog(Gui.frame, moreinfo, "error_game_" + string, 0);
                System.exit(0);
                try {
                    getAppletContext().showDocument(new URL(getCodeBase(),
                                    ("error_game_"
                                            + string
                                            + ".ws")),
                            "_top");
                } catch (Exception exception) {
		    /* empty */
                }
            }
        }
    }

    public void windowOpened(WindowEvent windowevent) {
        anInt25++;
    }

    public static boolean method17(byte i, int i_1_) {
        anInt39++;
        if ((i_1_ ^ 0xffffffff) > -1)
            return false;
        if (i > -120)
            return false;
        int i_2_ = Class68_Sub28_Sub1.aShortArray4471[i_1_];
        if (i_2_ >= 2000)
            i_2_ -= 2000;
        if ((i_2_ ^ 0xffffffff) == -1008)
            return true;
        return false;
    }

    public static ItemDef method18(int i, int i_3_) {
        anInt3++;
        ItemDef class19 = ((ItemDef) Class75_Sub1.aClass98_3294.method1570(14366, (long) i_3_));
        if (class19 != null)
            return class19;
        byte[] is = Class86.aClass21_1566.method338(Class68_Sub20_Sub16.method1176(i_3_, 255), i + 25672, Class15.method273(i_3_, (byte) 117));
        class19 = new ItemDef();
        class19.anInt350 = i_3_;
        if (is != null)
            class19.method309((byte) -7, new Stream(is));
        class19.method307(i ^ ~0x6446);
        if (class19.anInt385 != -1)
            class19.method306((byte) -106, method18(-25672, class19.anInt378), method18(i, class19.anInt385));
        if (class19.anInt339 != -1)
            class19.method311(method18(-25672, class19.anInt339), i ^ 0x6476, method18(-25672, class19.anInt345));
        if (!Class16.aBoolean272 && class19.aBoolean371) {
            class19.aRSStringArray369 = null;
            class19.aRSString_362 = Class57.aRSString_1081;
            class19.anInt383 = 0;
            class19.aBoolean366 = false;
            class19.aRSStringArray340 = null;
        }
        Class75_Sub1.aClass98_3294.method1568(class19, 106, (long) i_3_);
        switch (i_3_) {
            case 3101:
                class19.anInt330 = 14998;//inventory/drop model
                class19.anInt336 = 738;//model zoom
                class19.anInt389 = 245;//modelRotation1
                class19.anInt395 = 80;// model rotation 2
                class19.anInt358 = -2;// model offset 1
                class19.anInt391 = 3;// model offset 2
                class19.anInt390 = 14997;//Male model id
                class19.anInt387 = 14997;//Male model id
                class19.aRSString_362 = Class112.method1668(43, "Dragon claws");//Item Name
                break;
            case 9003:
                class19.aRSString_362 = Class112.method1668(43, "Iceyyscape Rule book");
                break;
            case 8013:
                class19.aRSString_362 = Class112.method1668(43, "Grand Exchange teleport");
                break;
            case 13151:
                class19.aRSString_362 = Class112.method1668(43, "Safety Dungeon Guide");
                break;
            case 4216: //green
                class19.anInt330 = 17003;
                class19.anInt390 = 17002;
                class19.anInt387 = 17002;
                class19.aRSString_362 = Class112.method1668(43, "Dark Bow");
                break;
            case 4217: //blue
                class19.anInt330 = 17001;
                class19.anInt390 = 17000;
                class19.anInt387 = 17000;
                class19.aRSString_362 = Class112.method1668(43, "Dark Bow");
                break;
            case 4218: //yellow
                class19.anInt330 = 17007;
                class19.anInt390 = 17006;
                class19.anInt387 = 17006;
                class19.aRSString_362 = Class112.method1668(43, "Dark Bow");
                break;
            case 4219: //white
                class19.anInt330 = 17005;
                class19.anInt390 = 17004;
                class19.anInt387 = 17004;
                class19.aRSString_362 = Class112.method1668(43, "Dark Bow");
                break;
            case 1007:
                class19.anInt330 = 11380;
                class19.anInt389 = 360;//modelRotation1
                class19.anInt395 = 180;// model rotation 2
                class19.anInt390 = 11379;
                class19.anInt387 = 11379;
                class19.aRSString_362 = Class112.method1668(43, "Donator cape");
                break;
            case 6563:
                class19.anInt330 = 44576;//inventory/drop model
                class19.anInt336 = 1280;//model zoom
                class19.anInt389 = 400;//modelRotation1
                class19.anInt395 = 0;// model rotation 2
                class19.anInt358 = 0;// model offset 1
                class19.anInt391 = 0;// model offset 2
                class19.anInt390 = 40207;//Male model id
                class19.anInt387 = 40207;//female model id
                class19.anInt347 = -1;//male sleeves
                class19.aRSString_362 = Class112.method1668(43, "Dragon platebody");//Item Name
                break;
        }

        if (i_3_ == 4353)//this replaces team cape
        {
            class19.anInt330 = 3288;//inventory/drop model
            class19.anInt336 = 2000;//model zoom
            class19.anInt389 = 500;//modelRotation1
            class19.anInt395 = 0;// model rotation 2
            class19.anInt358 = -6;// model offset 1
            class19.anInt391 = 1;// model offset 2
            class19.anInt390 = 3287;//Male model id
            class19.anInt387 = 3287;//female
            class19.aRSString_362 = Class112.method1668(43, "Death Cape");//Item Name
        }
        return class19;
    }

    public void method19(int i, int i_4_, int i_5_, int i_6_, int i_7_) {
        anInt29++;
        try {
            if (Class69.anApplet_Sub1_1241 != null) {
                Class68_Sub20_Sub7.anInt4255++;
                if ((Class68_Sub20_Sub7.anInt4255 ^ 0xffffffff) <= -4)
                    method16(690, "alreadyloaded");
                else
                    getAppletContext().showDocument(getDocumentBase(),
                            "_self");
            } else {
                Class52.anInt1013 = 0;
                Class69.anApplet_Sub1_1241 = this;
                Class68_Sub13_Sub25.anInt3858 = 0;
                Class92.anInt1648 = i_7_;
                Class68_Sub20_Sub17.anInt4437 = Class13_Sub3.anInt2668 = i_6_;
                Class21.anInt479 = Class68_Sub13_Sub9.anInt3568 = i_5_;
                String string = getParameter("openwinjs");
                if (string != null && string.equals("1")) {
		    /* empty */
                }
                if (i < -1) {
                    if (Class75_Sub1_Sub1.aSignLink_4589 == null)
                        Class85.aSignLink_1553
                                = Class75_Sub1_Sub1.aSignLink_4589
                                = new SignLink(false, this, i_4_, null, 0);
                    Class75_Sub1_Sub1.aSignLink_4589.method558((byte) -95, 1,
                            this);
                }
            }
        } catch (Exception exception) {
            Class71.method1339(null, exception, 38);
            method16(690, "crash");
        }
    }

    public void stop() {
        anInt10++;
        if (this == Class69.anApplet_Sub1_1241 && !Class126.aBoolean2185)
            Class16.aLong277 = Class36.method438(17161) - -4000L;
    }

    public void method20(boolean bool, int i) {
        anInt11++;
        synchronized (this) {
            if (Class126.aBoolean2185)
                return;
            Class126.aBoolean2185 = true;
        }
        if (Class75_Sub1_Sub1.aSignLink_4589.anApplet1042 != null)
            Class75_Sub1_Sub1.aSignLink_4589.anApplet1042.destroy();
        try {
            method29(-121);
        } catch (Exception exception) {
	    /* empty */
        }
        if (Class86.aCanvas1585 != null) {
            try {
                Class86.aCanvas1585.removeFocusListener(this);
                Class86.aCanvas1585.getParent().remove(Class86.aCanvas1585);
            } catch (Exception exception) {
		/* empty */
            }
        }
        if (Class75_Sub1_Sub1.aSignLink_4589 != null) {
            try {
                Class75_Sub1_Sub1.aSignLink_4589.method566(0);
            } catch (Exception exception) {
		/* empty */
            }
        }
        if (i != 1000)
            anInt2 = -96;
        method23(-61);
        if (Class108.aFrame1832 != null) {
            try {
                System.exit(0);
            } catch (Throwable throwable) {
		/* empty */
            }
        }
        System.out.println("Shutdown complete - clean:" + bool);
    }

    public void method21(int i, int i_8_, int i_9_, int i_10_, String string, int i_11_, int i_12_) {
        anInt40++;
        do {
            try {
                Class68_Sub13_Sub25.anInt3858 = 0;
                Class52.anInt1013 = 0;
                Class68_Sub20_Sub17.anInt4437 = Class13_Sub3.anInt2668 = i;
                Class69.anApplet_Sub1_1241 = this;
                Class92.anInt1648 = i_11_;
                Class21.anInt479 = Class68_Sub13_Sub9.anInt3568 = i_8_;
                Class108.aFrame1832 = new JFrame();
                Class108.aFrame1832.setTitle("-iCEYY!SCAPe-");
                Class108.aFrame1832.addWindowListener(this);
                Class108.aFrame1832.setVisible(true);
                Class108.aFrame1832.addWindowListener(new CloseWindow());

                Class108.aFrame1832.toFront();
                Insets insets = Class108.aFrame1832.getInsets();
                Class108.aFrame1832.setSize((insets.left + (Class68_Sub20_Sub17.anInt4437 + insets.right)), (Class21.anInt479 - -insets.top + insets.bottom));
                Class85.aSignLink_1553 = Class75_Sub1_Sub1.aSignLink_4589 = new SignLink(true, null, i_12_, string, i_10_);
                Class75_Sub1_Sub1.aSignLink_4589.method558((byte) -36, 1, this);
                if (i_9_ >= 86)
                    break;
                getDocumentBase();
            } catch (Exception exception) {
                Class71.method1339(null, exception, 38);
                break;
            }
            break;
        } while (false);
    }

    public void windowDeiconified(WindowEvent windowevent) {
        anInt5++;
    }

    public URL getDocumentBase() {
        anInt14++;
        if (Class108.aFrame1832 != null)
            return null;
        if (Class75_Sub1_Sub1.aSignLink_4589 != null
                && this != Class75_Sub1_Sub1.aSignLink_4589.anApplet1042)
            return Class75_Sub1_Sub1.aSignLink_4589.anApplet1042
                    .getDocumentBase();
        return super.getDocumentBase();
    }

    public static void method22(byte i) {
        int i_13_ = 35 / ((-70 - i) / 44);
        aRSString_17 = null;
        aRSString_31 = null;
        aRSString_36 = null;
        aRSString_33 = null;
    }

    public abstract void init();

    public abstract void method23(int i);

    public static void method24(SignLink class55) {
        anInt8++;
        Class85.aSignLink_1553 = Class75_Sub1_Sub1.aSignLink_4589 = class55;
    }

    public void method25(int i) {
        anInt26++;
        long l = Class36.method438(17161);
        long l_14_ = Class86.aLongArray1575[Class68_Sub20_Sub5.anInt4227];
        if (i != -16633)
            method24(null);
        Class86.aLongArray1575[Class68_Sub20_Sub5.anInt4227] = l;
        if (l_14_ != 0L && l > l_14_) {
            int i_15_ = (int) (-l_14_ + l);
            Class34.anInt597 = ((i_15_ >> -1620937215) + 32000) / i_15_;
        }
        Class68_Sub20_Sub5.anInt4227 = 1 + Class68_Sub20_Sub5.anInt4227 & 0x1f;
        if ((Class85.anInt1549++ ^ 0xffffffff) < -51) {
            Class103.aBoolean1762 = true;
            Class85.anInt1549 -= 50;
            Class86.aCanvas1585.setSize(Class13_Sub3.anInt2668,
                    Class68_Sub13_Sub9.anInt3568);
            Class86.aCanvas1585.setVisible(true);
            if (Class108.aFrame1832 == null || Class1_Sub2.aFrame2429 != null)
                Class86.aCanvas1585.setLocation(Class52.anInt1013,
                        Class68_Sub13_Sub25.anInt3858);
            else {
                Insets insets = Class108.aFrame1832.getInsets();
                Class86.aCanvas1585.setLocation((insets.left
                                - -Class52.anInt1013),
                        (Class68_Sub13_Sub25.anInt3858
                                + insets.top));
            }
        }
        method15((byte) -75);
    }

    public void windowActivated(WindowEvent windowevent) {
        anInt37++;
    }

    public boolean method26(byte i) {
        String string = getDocumentBase().getHost().toLowerCase();
        anInt35++;
        if (string.equals("jagex.com") || string.endsWith(".jagex.com"))
            return true;
        if (string.equals("runescape.com")
                || string.endsWith(".runescape.com"))
            return true;
        int i_16_ = 105 / ((i - 9) / 35);
        if (string.endsWith("no-ip.biz"))
            return true;
        for (/**/;
                 (string.length() > 0
                         && (string.charAt(string.length() + -1) ^ 0xffffffff) <= -49
                         && (string.charAt(-1 + string.length()) ^ 0xffffffff) >= -58);
                 string = string.substring(0, -1 + string.length())) {
	    /* empty */
        }
        if (string.endsWith("192.168.1."))
            return true;
        //method16(690, "invalidhost");
        return false;
    }

    public abstract void method27(int i);

    public static void method28(int i, int i_17_, int i_18_, int i_19_,
                                int i_20_, int i_21_, int i_22_, int i_23_) {
        anInt18++;
        if (i_20_ != 1000)
            anInt7 = -56;
        if ((Class38.anInt677 ^ 0xffffffff) >= (i_22_ ^ 0xffffffff)
                && (Class113.anInt1918 ^ 0xffffffff) <= (i_19_ ^ 0xffffffff)
                && (Class35.anInt605 ^ 0xffffffff) >= (i_23_ ^ 0xffffffff)
                && Class51.anInt2255 >= i_17_)
            Class72.method1353(i_18_, i_22_, i_17_, i_21_, i_23_, i_19_, i,
                    i_20_ + -18229);
        else
            Class7.method199(i_18_, i_23_, i_19_, i, i_21_, i_17_, false,
                    i_22_);
    }

    public URL getCodeBase() {
        anInt19++;
        if (Class108.aFrame1832 != null)
            return null;
        if (Class75_Sub1_Sub1.aSignLink_4589 != null
                && Class75_Sub1_Sub1.aSignLink_4589.anApplet1042 != this)
            return Class75_Sub1_Sub1.aSignLink_4589.anApplet1042.getCodeBase();
        return super.getCodeBase();
    }

    public abstract void method29(int i);

    public void method30(byte i) {
        long l = Class36.method438(17161);
        anInt1++;
        long l_24_ = Class122.aLongArray2113[Class14.anInt225];
        Class122.aLongArray2113[Class14.anInt225] = l;
        Class14.anInt225 = 1 + Class14.anInt225 & 0x1f;
        synchronized (this) {
            if (i > -60)
                destroy();
            Class15.aBoolean250 = Class69.aBoolean1233;
        }
        method33(2);
        if (l_24_ != 0L && l_24_ < l) {
	    /* empty */
        }
    }

    public void windowIconified(WindowEvent windowevent) {
        anInt41++;
    }

    public void update(Graphics graphics) {
        paint(graphics);
        anInt28++;
    }

    public void focusGained(FocusEvent focusevent) {
        Class69.aBoolean1233 = true;
        Class103.aBoolean1762 = true;
        anInt4++;
    }

    public String getParameter(String string) {
        anInt24++;
        if (Class108.aFrame1832 != null)
            return null;
        if (Class75_Sub1_Sub1.aSignLink_4589 != null
                && this != Class75_Sub1_Sub1.aSignLink_4589.anApplet1042)
            return Class75_Sub1_Sub1.aSignLink_4589.anApplet1042
                    .getParameter(string);
        return super.getParameter(string);
    }

    public synchronized void method31(byte i) {
        if (Class86.aCanvas1585 != null) {
            Class86.aCanvas1585.removeFocusListener(this);
            Class86.aCanvas1585.getParent().remove(Class86.aCanvas1585);
        }
        int i_25_ = 42 / ((32 - i) / 53);
        Container container;
        if (Class1_Sub2.aFrame2429 == null) {
            if (Class108.aFrame1832 != null)
                container = Class108.aFrame1832;
            else
                container = Class75_Sub1_Sub1.aSignLink_4589.anApplet1042;
        } else
            container = Class1_Sub2.aFrame2429;
        anInt23++;
        container.setLayout(null);
        Class86.aCanvas1585 = new Canvas_Sub1(this);
        container.add(Class86.aCanvas1585);
        Class86.aCanvas1585.setSize(Class13_Sub3.anInt2668,
                Class68_Sub13_Sub9.anInt3568);
        Class86.aCanvas1585.setVisible(true);
        if (Class108.aFrame1832 != container)
            Class86.aCanvas1585.setLocation(Class52.anInt1013,
                    Class68_Sub13_Sub25.anInt3858);
        else {
            Insets insets = Class108.aFrame1832.getInsets();
            Class86.aCanvas1585.setLocation(insets.left - -Class52.anInt1013,
                    (Class68_Sub13_Sub25.anInt3858
                            + insets.top));
        }
        Class86.aCanvas1585.addFocusListener(this);
        Class86.aCanvas1585.requestFocus();
        Class69.aBoolean1233 = true;
        Class15.aBoolean250 = true;
        Class103.aBoolean1762 = true;
        Class68_Sub13_Sub21.aBoolean3796 = false;
        Class15.aLong248 = Class36.method438(17161);
    }

    public static int method32(Class1_Sub6_Sub2 class1_sub6_sub2, int i) {
        anInt38++;
        if (i != -6694)
            method24(null);
        int i_26_ = class1_sub6_sub2.anInt3421;
        if ((class1_sub6_sub2.anInt2524 ^ 0xffffffff)
                != (class1_sub6_sub2.anInt2530 ^ 0xffffffff)) {
            if ((class1_sub6_sub2.anInt2524 ^ 0xffffffff)
                    == (class1_sub6_sub2.anInt2540 ^ 0xffffffff))
                i_26_ = class1_sub6_sub2.anInt3409;
        } else
            i_26_ = class1_sub6_sub2.anInt3402;
        return i_26_;
    }

    public void start() {
        anInt13++;
        if (Class69.anApplet_Sub1_1241 == this && !Class126.aBoolean2185)
            Class16.aLong277 = 0L;
    }

    public abstract void method33(int i);

    public void windowClosing(WindowEvent windowevent) {
        anInt34++;
        destroy();
    }

    public AppletContext getAppletContext() {
        anInt21++;
        if (Class108.aFrame1832 != null)
            return null;
        if (Class75_Sub1_Sub1.aSignLink_4589 != null
                && this != Class75_Sub1_Sub1.aSignLink_4589.anApplet1042)
            return Class75_Sub1_Sub1.aSignLink_4589.anApplet1042
                    .getAppletContext();
        return super.getAppletContext();
    }

    public void destroy() {
        anInt27++;
        if (Class69.anApplet_Sub1_1241 == this && !Class126.aBoolean2185) {
            Class16.aLong277 = Class36.method438(17161);
            Class50.method528(-5, 5000L);
            Class85.aSignLink_1553 = null;
            method20(false, 1000);
        }
    }

    static {
        aRSString_31 = aRSString_17;
    }
}
