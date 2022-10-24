package MainWindow;

import AppPlugins.CacheCleaner;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        CacheCleaner cCleaner = new CacheCleaner();

        JFrame f = new JFrame("Junk Cleaner");//Instance with given name
        JButton b1 = new JButton("Clean cache of " + cCleaner.getCacheSize()+ "mbs - Firefox"); //Instance of a button

        f.setSize(500, 500);//width and height
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit on close
        f.setLocationRelativeTo(null);//Placing the main frame in the middle screen regardless of the screen size
        b1.setBounds(100, 100, 300, 100);//x axis, y axis, width, height
        f.add(b1);//Add button to the frame
        f.setLayout(null);//Setting the layout to null
        f.setVisible(true);//Setting the frame to visible

        //If the button is clicked, the cache cleaner will be executed
        b1.addActionListener(e -> {
            try {
                cCleaner.cleanCacheMozilla();
                b1.setText("Clean cache of " + cCleaner.getCacheSize()+ "mbs - Firefox");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}