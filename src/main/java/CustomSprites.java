import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class CustomSprites {
    public static Map<String, int[]> sprites = new HashMap<String, int[]>();
    
    public static void loadCustomSprites(client var_client) {
        try {
            RandomAccessFile cache = new RandomAccessFile(System.getProperty("user.home") + "/Icache31/sprites.dat", "r");
            RandomAccessFile cache_idx = new RandomAccessFile(System.getProperty("user.home") + "/Icache31/sprites.idx", "r");
            Cache ch = new Cache(cache, cache_idx, 0);
            Map<String, Image> images = new HashMap<String, Image>();
            for(int i=0; i < ch.getNumFiles(); i++) {
                byte[] buffer = ch.getFile(i);
                if(buffer == null) {
                    continue;
                }
                DataStream str = new DataStream(buffer.length, 0);
                System.arraycopy(buffer, 0, str.inBuffer, 0, buffer.length);
                String name = str.readString();
                Image img = Toolkit.getDefaultToolkit().createImage(str.inBuffer, str.readOffset(), str.inBuffer.length - str.readOffset());
                if(img != null) {
                    images.put(name, img);
                }
            }
            MediaTracker mediaTracker = new MediaTracker(var_client);
            for(Image i : images.values()) {
                mediaTracker.addImage(i, 0);
            }
            try {
                mediaTracker.waitForAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(String name : images.keySet()) {
                Image i = images.get(name);
                if(i == null) {
                    continue;
                }
                int[] pixels = new int[i.getWidth(null) * i.getHeight(null)];
                PixelGrabber pixelgrabber = new PixelGrabber(i, 0, 0, i.getWidth(null), i.getHeight(null), pixels, 0, i.getWidth(null));
                pixelgrabber.grabPixels();
                sprites.put(name, pixels);
            }
	    System.out.println("-iCEYY!SCAPe- v3.1 client is starting up...");
            //System.out.println("" + sprites.size() + " custom sprites successfully loaded!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}