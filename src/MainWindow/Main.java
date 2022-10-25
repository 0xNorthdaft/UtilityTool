package MainWindow;

import AppPlugins.BraveCacheCleaner;
import AppPlugins.EdgeCacheCleaner;
import AppPlugins.MozillaCacheCleaner;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MozillaCacheCleaner mCleaner = new MozillaCacheCleaner();
        BraveCacheCleaner bCleaner = new BraveCacheCleaner();
        EdgeCacheCleaner eCleaner = new EdgeCacheCleaner();

        JFrame f = new JFrame("Junk Cleaner");//Instance with given name
        JButton b1 = new JButton("Clean cache of " + mCleaner.getCacheSize()+ "mbs - Firefox"); //Instance of a button
        JButton b2 = new JButton("Clean cache of " + bCleaner.getCacheSize()+ "mbs - Brave"); //Instance of a button
        JButton b3 = new JButton("Clean cache of " + eCleaner.getCacheSize()+ "mbs - Edge"); //Instance of a button

        f.setSize(500, 500);//width and height
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit on close
        f.setLocationRelativeTo(null);//Placing the main frame in the middle screen regardless of the screen size
        b1.setBounds(100, 10, 250, 40);//x axis, y axis, width, height
        b2.setBounds(100, 55, 250, 40);//x axis, y axis, width, height
        b3.setBounds(100, 100, 250, 40);//x axis, y axis, width, height
        f.add(b1);//Add button to the frame
        f.add(b2);//Add button to the frame
        f.add(b3);//Add button to the frame
        f.setLayout(null);//Setting the layout to null
        f.setVisible(true);//Setting the frame to visible

        //If the button is clicked, the cache cleaner will be executed
        b1.addActionListener(e -> {
            try {
                mCleaner.cleanCache();
                b1.setText("Clean cache of " + mCleaner.getCacheSize()+ "mbs - Firefox");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            mCleaner.cleanMemory();
        });


        //2nd button for Brave's cache
        b2.addActionListener(e -> {
            try {
                bCleaner.cleanCache();
                b2.setText("Clean cache of " + bCleaner.getCacheSize()+ "mbs - Brave");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            bCleaner.cleanMemory();
        });

        //3rd button for Edge's cache
        b3.addActionListener(e -> {
            try {
                eCleaner.cleanCache();
                b3.setText("Clean cache of " + eCleaner.getCacheSize()+ "mbs - Edge");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            eCleaner.cleanMemory();
        });
    }
}