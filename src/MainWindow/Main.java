/*
* Utility Tool Build 0.1.2
* Made by George "Northdaft" Vilciu
* Available for Windows and tested on Windows 8.1, 10 and 11
*
* */

package MainWindow;

import AppPlugins.BraveCacheCleaner;
import AppPlugins.ChromeCacheCleaner;
import AppPlugins.EdgeCacheCleaner;
import AppPlugins.MozillaCacheCleaner;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MozillaCacheCleaner mCleaner = new MozillaCacheCleaner();
        BraveCacheCleaner bCleaner = new BraveCacheCleaner();
        EdgeCacheCleaner eCleaner = new EdgeCacheCleaner();
        ChromeCacheCleaner ccCleaner = new ChromeCacheCleaner();

        JFrame f = new JFrame("Junk Cleaner");//Instance with given name
        JButton b1 = new JButton("Clean cache of " + MozillaCacheCleaner.getCacheSize()+ "mbs - Firefox"); //Instance of a button
        JButton b2 = new JButton("Clean cache of " + bCleaner.getCacheSize()+ "mbs - Brave"); //Instance of a button
        JButton b3 = new JButton("Clean cache of " + eCleaner.getCacheSize()+ "mbs - Edge"); //Instance of a button
        JButton b4 = new JButton("Clean cache of " + ccCleaner.getCacheSize()+ "mbs - Chrome"); //Instance of a button
        JButton b5 = new JButton("Refresh");//Refresh button

        f.setSize(500, 500);//width and height
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit on close
        f.setLocationRelativeTo(null);//Placing the main frame in the middle screen regardless of the screen size
        //X - horizontal coordinate, Y - vertical coordinate
        //Width - width of the button, Height - height of the button
        b1.setBounds(100, 10, 250, 25);//pos for Firefox button
        b2.setBounds(100, 36, 250, 25);//pos for Brave button
        b3.setBounds(100, 63, 250, 25);//pos for Edge button
        b4.setBounds(100, 89, 250, 25);//pos for Chrome button
        b5.setBounds(180, 440, 80, 25);//pos for Refresh button

        f.add(b1);//Add button to the frame
        f.add(b2);//Add button to the frame
        f.add(b3);//Add button to the frame
        f.add(b4);//Add button to the frame
        f.add(b5);//Add button to the frame

        f.setLayout(null);//Setting the layout to null
        f.setVisible(true);//Setting the frame to visible


        //If the button is clicked, the cache cleaner will be executed
        b1.addActionListener(e -> {
            try {
                mCleaner.cleanCache();
                b1.setText("Clean cache of " + MozillaCacheCleaner.getCacheSize()+ "mbs - Firefox");
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

        //4th button for Chrome's cache
        b4.addActionListener(e -> {
            try {
                ccCleaner.cleanCache();
                b4.setText("Clean cache of " + ccCleaner.getCacheSize()+ "mbs - Chrome");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ccCleaner.cleanMemory();
        });

        //Refresh button to refresh the size of the cache of the browsers
        b5.addActionListener(e ->{
            b1.setText("Clean cache of " + MozillaCacheCleaner.getCacheSize()+ "mbs - Firefox");
            b2.setText("Clean cache of " + bCleaner.getCacheSize()+ "mbs - Brave");
            b3.setText("Clean cache of " + eCleaner.getCacheSize()+ "mbs - Edge");
            b4.setText("Clean cache of " + ccCleaner.getCacheSize()+ "mbs - Chrome");
        });
    }
}