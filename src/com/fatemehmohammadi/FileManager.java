package com.fatemehmohammadi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
        private String path=".\\FileManager";
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }

    public void createfile(String filename) {
        File f = new File(this.path + "\\" + filename);
        if (!(f.exists()))
        { File dir=new File(path);
            dir.mkdirs();
            try { f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void writer(String filename,String date)
    {
        try {
            FileWriter w=new FileWriter(this.path+"\\"+ filename);
            w.write(date);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void movements(String filename,String date)
    {
        try {
            FileWriter m=new FileWriter(this.path+"\\"+ filename,true);
            m.write(date);
            m.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String readFile(String filename)
    {
        String totalData="";
        try {
            File r=new File(this.path+"\\"+filename);
            Scanner scanner=new Scanner(r);
            while (scanner.hasNextLine())
            {
                totalData+=scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return totalData;
    }


}
