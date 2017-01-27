import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static String SERVER_IP = "127.0.0.1";
    public static int SERVER_PORT = 43594;

    public static void loadProperties() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = Config.class.getResourceAsStream("iceyyclient.properties");
            properties.load(inputStream);
            SERVER_IP = properties.getProperty("SERVER_IP");
            SERVER_PORT = Integer.parseInt(properties.getProperty("SERVER_PORT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
