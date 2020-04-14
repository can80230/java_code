package com.can8023.util;

import javax.swing.text.Document;
import java.io.*;

public class Diary {

    public static void addDiary(String pathname, String title, String txt) {
        File dirfile = new File(pathname);
        BufferedWriter bufw = null;
        dirfile.mkdir();

        File file = new File(dirfile, title + ".ky");
        try {
            bufw = new BufferedWriter(new FileWriter(file, true));
            bufw.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void read(File file, Document doc) {
        try (BufferedReader bufr = new BufferedReader(new FileReader(file));) {
            String txt = null;
            String line = System.getProperty("line.separator");
            while ((txt = bufr.readLine()) != null) {
                doc.insertString(doc.getLength(), txt + line, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
