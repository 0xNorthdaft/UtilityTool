/*
 * Utility Tool Build 0.1.2
 * Made by George "Northdaft" Vilciu
 * Available for Windows and tested on Windows 8.1, 10 and 11
 *
 * */
package AppPlugins;

import java.io.File;
import java.io.IOException;

import static AppPlugins.CachePaths.*;
import static java.lang.Runtime.getRuntime;

public class BraveCacheCleaner {
    public boolean cleanCache() throws IOException {
        File directory = new File(pathToBraveCache);
        File[] listOfFiles = directory.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                // method endsWith is always True if not suffix is not specified
                // If no argument is specified, the method can throw NullPointerException
                file.getName();
                file.delete();
            }
        }
        return false;
    }

    //Get the size of the files in the directory in megabytes
    public int getCacheSize() {
        try {
            File directory = new File(pathToBraveCache);
            File[] listOfFiles = directory.listFiles();
            int size = 0;
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    size += file.length();
                }
            }
            return size / 1024 / 1024;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void cleanMemory(){
        getRuntime().gc();
    }
}
