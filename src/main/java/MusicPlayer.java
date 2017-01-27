import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

public class MusicPlayer extends Thread {
	File file;
	boolean loop;
	FloatControl gainControl = null;

    public MusicPlayer(File file, boolean loop) {
    	this.file = file;
    	this.loop = loop;
    	start();
    }

    public void run() {
		while (loop) {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
				AudioFormat audioFormat = audioInputStream.getFormat();
			
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
				SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(audioFormat);
				line.start();
				gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
				
				byte[] abData = new byte[128000]; // Buffer size [128000]
				for (int nBytesRead = 0; nBytesRead >= 0;nBytesRead = audioInputStream.read(abData, 0, abData.length)) {
					line.write(abData, 0, nBytesRead);
				}
			
				line.drain();
				line.close();
			} catch (Exception e) {
		    	loop = false;
			}
    	}
    }
	
	public void setVolume(int percent) {
		if (gainControl != null && percent >= 0 && percent <= 100) {
			gainControl.setValue((float) (Math.log(percent / 100.0) / Math.log(10.0) * 20.0));
		}
	}
	
	public int getVolume() {
		if (gainControl != null) {
			return (int) (Math.exp(gainControl.getValue() * (Math.log(10.0) * 20.0)) * 100.0);
		} else {
			return 0;
		}
	}
}