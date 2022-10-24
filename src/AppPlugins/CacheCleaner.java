package AppPlugins;


import java.io.File;
import java.io.IOException;

public class CacheCleaner {

    final static String pathToMozillaCache = "C:\\Users\\"+ System.getProperty("user.name")+"\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\bju3y0sh.default-release\\cache2\\entries";

    public boolean cleanCacheMozilla() throws IOException {
        File directory = new File(pathToMozillaCache);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().endsWith("")) {
                    file.delete();
                }
            }
        }
        return false;

    }

    //Get the size of the files in the directory in megabytes
    public int getCacheSize() {
        File directory = new File(pathToMozillaCache);
        File[] listOfFiles = directory.listFiles();
        int size = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                size += file.length();
            }
        }
        return size / 1024 / 1024;
    }
}
