package ru.geekbrains.java2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final File file;

    public Logger(String path) {
        this.file = new File(path);
    }

    public void writeLog(String message){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)))
        {
            bw.write("[LOGGER] " + message + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printLog(){
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String s;
            List<String> rows = new ArrayList<>();
            while((s=br.readLine())!=null){
                rows.add(s);
            }
            int i = (rows.size() > 100) ? rows.size() - 100 : 0 ;
            for (int j = i ; j < rows.size(); j++) {
                System.out.println(rows.get(j));
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
