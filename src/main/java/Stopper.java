public class Stopper extends Thread {
	MusicPlayer player;
	
	public Stopper(MusicPlayer player) {
		this.player = player;
		start();
	}
	
	public void run() {
		try {
			player.loop = false;
			for (int v = player.getVolume(); v >= 0; v--) {
				player.setVolume(v);
				sleep(60); // lower number means a faster fade (40 recommended)
			}
			player.interrupt();
		} catch (InterruptedException p) {}
    }
}