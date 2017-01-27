import java.io.*;
import java.util.*;

public class ModelLoader {

	public static List<Integer> models = null;

	public ModelLoader()
	{
		loadArray();
models.add(44576);
models.add(14998);
models.add(5026);
models.add(5024);
models.add(40207);
models.add(14997);
models.add(5025);
models.add(3287);
models.add(3288);
	}

	public static byte[] loadNewModel(int i) throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream(System.getProperty("user.home") + "/Icache31/models/"+i+".dat"));
		byte[] buffer = new byte[(int) new File(System.getProperty("user.home") + "/Icache31/models/"+i+".dat").length()];
		dis.readFully(buffer);
		dis.close();
		return buffer;
	}

	public void loadArray()
	{
		models = new ArrayList<Integer>();
		File[] m = new File(System.getProperty("user.home") + "/Icache31/models").listFiles();
		for (File model : m)
			if(model.getName().contains(".dat"))
				models.add(Integer.parseInt(model.getName().substring(0, model.getName().indexOf(".dat"))));
	}

}