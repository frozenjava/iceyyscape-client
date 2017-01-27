import java.applet.*;
import java.util.Properties;
import javax.swing.*;
import java.awt.*;
import java.lang.String;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.sound.midi.*;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Gui extends client implements ActionListener, ItemListener, WindowListener
{
	private static FileOutputStream logFileOut;
	private static boolean isApplet = false;
	public int midiCount;
	public Sequencer sequencer;
	public static JFrame frame;
	public static Properties props = new Properties();
	public String val;

	public static void main(String[] args)
	{
		new Gui();
		//JOptionPane.showMessageDialog(frame, "You must register your Username and Password before you can login!\n"+ "Do so by clicking Links on the menu bar above and then clicking register!\n"+ "Thank You!" , "Reminder! Must Register Account!", 0);
	}

	public static final String[] MENU_ITEMS = new String[] {
		"File",
		"World",
		"Links",
	};
	public static final String[][] SUB_MENU_ITEMS = new String[][] {
		new String[] {
			"Quit",
		},
		
		new String[] {
			"World 1 (Skilling)",
			"World 2 (PVP)",
			"LocalHost",
		},
		
		new String[] {
			"Register",
			"Site",
			"HighScores",
		},
	};

	public Gui() {
		try {
			//MetalLookAndFeel.setCurrentTheme(new theme.BlackWTheme());
			//JFrame.setDefaultLookAndFeelDecorated(true);

			frame = new JFrame();
			title();
			frame.setLayout(new BorderLayout());
			frame.setIconImage(new ImageIcon(System.getProperty("user.home") + "/Icache31/favicon.gif").getImage());
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));

			JMenuBar jMenuBar = new JMenuBar();
			for(int i = 0; i < MENU_ITEMS.length; i++) {
				JMenu jMenu = new JMenu(MENU_ITEMS[i]);
				for(int j = 0; j < SUB_MENU_ITEMS[i].length; j++) {
					if(SUB_MENU_ITEMS[i][j].equals("-")) {
						jMenu.addSeparator();
					} else {
						JMenuItem jMenuItem = new JMenuItem(SUB_MENU_ITEMS[i][j]);
						jMenuItem.addActionListener(this);
						jMenu.add(jMenuItem);
					}
				}
				jMenu.getPopupMenu().setLightWeightPopupEnabled(false);
				jMenuBar.add(jMenu);
			}
			JButton shotMenu = new JButton("Screenshot");
			shotMenu.setActionCommand("Screenshot");
			shotMenu.addActionListener(this);
			jMenuBar.add(shotMenu);
			
			frame.getContentPane().add(jMenuBar, BorderLayout.NORTH);
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);

			client client = new client();
			CustomSprites.loadCustomSprites(client);
            props.put("worldid", "66");
            props.put("members", "1");
            props.put("modewhat", "0");
            props.put("modewhere", "0");
            props.put("safemode", "0");
            props.put("game", "0");
            props.put("js", "1");
            props.put("lang", "0");
            props.put("affid", "0");
            props.put("settings", "kKmok3kJqOeN6D3mDdihco3oPeYN2KFy6W5--vZUbNA");
            props.put("lowmem", "0");
            SignLink signlink = new SignLink(true, this, 32, "runescape", 27);
            Applet_Sub1.method24(signlink);
            Applet applet = (Applet) new client();
            applet.init();
        } catch (Exception _ex) {
            //System.out.println(_ex);
        }
	}

	/**
	public void title() {
		if(Class115.serverPort == 43594) {
			frame.setTitle("-iCEYY!SCAPe- 3.1 Current World: 1 (Skilling)");
		} else if (Class115.serverPort == 43595) {
			frame.setTitle("-iCEYY!SCAPe- 3.1 Current World: 2 (PVP)");
		}
	}*/
	
	public void title() {
			frame.setTitle("Dev. Client Port:"+Class115.serverPort+" IP:"+Class68_Sub9.serverIP+"");
	}

	 public JDialog createFileChooserDialog(JFileChooser jfilechooser, String s, Container container)
	    {
	        JDialog jdialog = new JDialog(frame, s, true);
	        jdialog.setDefaultCloseOperation(2);
	        jdialog.add(jfilechooser);
	        jdialog.pack();
	        jdialog.setLocationRelativeTo(container);
	        return jdialog;
    }
    public void itemStateChanged(ItemEvent itemevent)
	    {
	        String s = itemevent.paramString();
	        s = s.substring(s.indexOf("item=") + 5);
	        int i = itemevent.getStateChange();
	        if(s != null)
	        {
	            
	        }
    }
    public static void chkDir(String fileName)
	    {
	        try
	        {
	            File f = new File(fileName);
	            if(!f.exists())
	                f.mkdir();
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("Error making file: ").append(e).toString());
	        }
    }
	/**
     public void midiPlayer(String command)
	    {
	        String dir = "../music/";
	        chkDir(dir);
	        if(player != null && player.isRunning())
	        {
	            player.close();
	        }
	        if(sequencer != null && sequencer.isRunning())
	        {
	            sequencer.stop();
	            sequencer.close();
	        }
	        if(command.equals("Next"))
	        {
	            midiCount++;
	        } else
	        if(command.equals("Previous"))
	        {
	            midiCount--;
	        }
	        if(!command.equals("Stop"))
	        {
	            File index = new File(dir);
	            String fileList[] = index.list();
	            if(fileList.length > 0)
	            {
	                if(midiCount > fileList.length - 1)
	                {
	                    midiCount = 0;
	                }
	                if(midiCount < 0)
	                {
	                    midiCount = fileList.length - 1;
	                }
	                if(fileList[midiCount].endsWith(".mp3"))
	                {
	                    System.out.println((new StringBuilder()).append("Playing ").append(fileList[midiCount]).toString());
	                    player = new MP3Player((new StringBuilder()).append(dir).append(fileList[midiCount]).toString(), true);
	                } else
	                if(fileList[midiCount].endsWith(".mid"))
	                {
	                    System.out.println((new StringBuilder()).append("Playing ").append(fileList[midiCount]).toString());
	                    try
	                    {
	                        File midiFile = new File((new StringBuilder()).append(dir).append(fileList[midiCount]).toString());
	                        sequencer = MidiSystem.getSequencer();
	                        sequencer.setSequence(MidiSystem.getSequence(midiFile));
	                        sequencer.setLoopCount(-1);
	                        sequencer.open();
	                        sequencer.start();
	                    }
	                    catch(MidiUnavailableException mue)
	                    {
	                        System.out.println("Midi device unavailable!");
	                    }
	                    catch(InvalidMidiDataException imde)
	                    {
	                        System.out.println("Invalid Midi data!");
	                    }
	                    catch(IOException ioe)
	                    {
	                        System.out.println("I/O Error!");
	                    }
	                }
	            } else
	            {
	                JOptionPane.showMessageDialog(frame, "To add your own music go into the user folder \nThen into the music folder now you can drop and drag your own \nMp3 music files into here once you done that \nReload the client and press next, then it will proceed and play!", "No Files In Music Folder", 0);
	            }
	        }
    }*/

public void takeScreenshot(boolean flag)
    {
        BufferedImage bufferedimage;
        try
        {
            Robot robot = new Robot();
            Point point = getLocationOnScreen();
            Rectangle rectangle = new Rectangle(point.x, point.y, getWidth(), getHeight());
            bufferedimage = robot.createScreenCapture(rectangle);
        }
        catch(Throwable throwable)
        {
             JOptionPane.showMessageDialog(frame, "An error occured while trying to create a screenshot!", "Screenshot Error", 0);
            return;
        }
        String s = null;
        try
        {
            s = getNearestScreenshotFilename();
        }
        catch(IOException ioexception)
        {
            if(flag)
            {
                 JOptionPane.showMessageDialog(frame, "A screenshot directory does not exist, and could not be created!", "No Screenshot Directory", 0);
                return;
            }
        }
        if(s == null && flag)
        {
             JOptionPane.showMessageDialog(frame, "There are too many screenshots in the screenshot directory!\n"+"Delete some screen\n" +"shots and try again." , "Screenshot Directory Full", 0);
            return;
        }
        if(!flag)
        {
            final JFileChooser fileChooser = new JFileChooser();
            final JDialog fileDialog = createFileChooserDialog(fileChooser, "Save Screenshot", this);
            final BufferedImage si = bufferedimage;
            JFileChooser _tmp = fileChooser;
            fileChooser.setFileSelectionMode(0);
            fileChooser.addChoosableFileFilter(new imageFileFilter());
            fileChooser.setCurrentDirectory(new File("../screenshots/"));
            fileChooser.setSelectedFile(new File(s));
            JFileChooser _tmp1 = fileChooser;
            fileChooser.setDialogType(1);
            fileChooser.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent actionevent)
                {
                    String s1 = actionevent.getActionCommand();
                    if(s1.equals("ApproveSelection"))
                    {
                        File file = fileChooser.getSelectedFile();
                        if(file != null && file.isFile())
                        {
                            int i = JOptionPane.showConfirmDialog(frame, (new StringBuilder()).append(file.getAbsolutePath()).append(" already exists.\n"+"Do you want to replace it?").toString(), "Save Screenshot", 2);
                            if(i != 0)
                            {
                                return;
                            }
                        }
                        try
                        {
                            ImageIO.write(si, "png", file);
                        }
                        catch(IOException ioexception2)
                        {
                             JOptionPane.showMessageDialog(frame, "An error occured while trying to save the screenshot!\n"+"Please make sure you have\n"+" write access to the screenshot directory." , "Screenshot Error", 0);
                        }
                        fileDialog.dispose();
                    } else
                    if(s1.equals("CancelSelection"))
                    {
                        fileDialog.dispose();
                    }
                }


            {

            }
            });
            fileDialog.setVisible(true);
        } else
        {
            try
            {
                ImageIO.write(bufferedimage, "png", new File((new StringBuilder()).append("../screenshots/").append(s).toString()));

		System.out.println("You took a screenshot!");
            }
            catch(IOException ioexception1)
            {
                 JOptionPane.showMessageDialog(frame, "An error occured while trying to save the screenshot!\n"+"Please make sure you have\n"+" write access to the screenshot directory." , "Screenshot Error", 0);
            }
        }
    }

public static String getNearestScreenshotFilename()
        throws IOException
    {
        File file = new File("../screenshots/");
        int i = 0;
        do
        {
            String s = " .png";
            if(i < 10)
            {
                s = s.replaceFirst(" ", (new StringBuilder()).append("000").append(i).toString());
            } else
            if(i < 100)
            {
                s = s.replaceFirst(" ", (new StringBuilder()).append("00").append(i).toString());
            } else
            if(i < 1000)
            {
                s = s.replaceFirst(" ", (new StringBuilder()).append("0").append(i).toString());
            } else
            if(i < 10000)
            {
                s = s.replaceFirst(" ", (new StringBuilder()).append(" ").append(i).toString());
            }
            if((new File(file, s)).isFile())
            {
                i++;
            } else
            {
                return s;
            }
        } while(i < 10000);
        return null;
    }


class imageFileFilter extends FileFilter
{

    imageFileFilter()
    {
    }

    public boolean accept(File file)
    {
        String s = file.getName();
        return file.isDirectory() || s.toLowerCase().endsWith(".png") && s.indexOf("$") == -1;
    }

    public String getDescription()
    {
        return "PNG (*.png)";
    }
}

 public void launchURL(String s)
    {
        String s1 = System.getProperty("os.name");
        try
        {
            
            if(s1.startsWith("Windows"))
            {
                Runtime.getRuntime().exec((new StringBuilder()).append("rundll32 url.dll,FileProtocolHandler ").append(s).toString());
            } else
            {
                String as[] = {
                    "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"
                };
                String s2 = null;
                for(int i = 0; i < as.length && s2 == null; i++)
                    if(Runtime.getRuntime().exec(new String[] {
    "which", as[i]
}).waitFor() == 0)
                        s2 = as[i];

                if(s2 == null)
                    throw new Exception("Could not find web browser");
                Runtime.getRuntime().exec(new String[] {
                    s2, s
                });
            }
        }
        catch(Exception exception)
        {
            System.out.println("An error occured while trying to open the web browser!\n");
        }
    }

	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		if (cmd != null) {
			if (cmd.equalsIgnoreCase("Quit")) {
				int i1;
				if((i1 = JOptionPane.showConfirmDialog(this, "Are you sure you want to close the client?")) == 0)
				System.exit(0);
				return;
			}
			
			if (cmd.equalsIgnoreCase("World 1 (Skilling)")) {
	            Class115.serverPort = 43594;
				Class68_Sub9.serverIP = "127.0.0.1";
				Class103.anInt1773 = Class115.serverPort;
				System.out.println("World change: world 1 port 43594");
				title();
	        }
			
			if (cmd.equalsIgnoreCase("World 2 (PVP)")) {
	            Class115.serverPort = 43595;
				Class68_Sub9.serverIP = "127.0.0.1";
				Class103.anInt1773 = Class115.serverPort;
				System.out.println("World change: world 2 port 43595");
				title();
	        }
			
			if (cmd.equalsIgnoreCase("LocalHost")) {
	            Class68_Sub9.serverIP = "127.0.0.1";
				System.out.println("Now in localhost mode");
				title();
	        }
			
	        if (cmd.equalsIgnoreCase("Screenshot")) {
	            takeScreenshot(true);
	        }
			if (cmd.equalsIgnoreCase("Register")) {
	            launchURL("http://iceyy.no-ip.biz/downloads/index.php");
	        }
	        if (cmd.equalsIgnoreCase("Site")) {
	            launchURL("http://iceyy.no-ip.biz");
	        }
	        if (cmd.equalsIgnoreCase("HighScores")) {
	            launchURL("http://iceyy.no-ip.biz/highscores/highscores.php");
	        }
		}
	}


	public String getParameter(String p){
		return (String)props.get(p);
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public URL getCodeBase() {
		try {	
			return new URL("http://iceyy.no-ip.biz");
		} catch(Exception _ex){
			//_ex.printStackTrace();
		}
		return null;
	}

 }
