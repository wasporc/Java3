package ru.geekbrains.java2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	    Logger logger = new Logger("log.txt");
	    logger.printLog();
	    writeMessage(logger);
	    logger.printLog();
    }

    public static void writeMessage(Logger log){
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {
            System.out.println("Write something plz, or 'exit' ");
            String text;
            while(!(text=br.readLine()).equals("exit")){
                System.out.println("Write something plz, or 'exit' ");
                log.writeLog(text);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
