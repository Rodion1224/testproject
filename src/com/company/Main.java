package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


    public class Main {

        public static void main(String[] args) {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("C:\\Users\\FoxSe\\OneDrive\\Рабочий стол\\Старое\\Студенты.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
