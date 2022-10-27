package AppPlugins;

import java.io.File;
import java.util.Objects;

public class CachePaths {
    public static String pathToMozillaCache = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\" + getProfileDirectoryNameMozilla() + "\\cache2\\entries";
    public static String pathToBraveCache = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Local\\BraveSoftware\\Brave-Browser\\User Data\\Default\\Cache\\Cache_data";
    public static String pathToEdgeCache = "C:\\Users\\"+ System.getProperty("user.name")
            +"\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default\\Cache\\Cache_Data";

    public static String pathToChromeCache = "C:\\Users\\"+ System.getProperty("user.name")
            +  "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache";

    //Get the name of the folder that ends with a suffix in a specified path
    public static String getProfileDirectoryNameMozilla() {
        try{
            File directory = new File("C:\\Users\\" + System.getProperty("user.name")
                                + "\\AppData\\Local\\Mozilla\\Firefox\\Profiles");
            File[] listOfFiles = directory.listFiles();
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                if (file.isDirectory() && file.getName().endsWith(".default-release")) {
                    return file.getName();
                }
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;

    }
}