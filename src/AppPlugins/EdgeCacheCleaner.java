package AppPlugins;

import java.io.File;
import java.io.IOException;

import static AppPlugins.CachePaths.*;
import static java.lang.Runtime.getRuntime;

public class EdgeCacheCleaner {
    public boolean cleanCache() throws IOException {
        File directory = new File(pathToEdgeCache);
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
        File directory = new File(pathToEdgeCache);
        File[] listOfFiles = directory.listFiles();
        int size = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                size += file.length();
            }
        }
        return size / 1024 / 1024;
    }

    public void cleanMemory(){
        getRuntime().gc();
    }
}
