package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


    public class Main {

        public static void main(String[] args) {

        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            boolean isNum = false;
            Integer intNum;
            String strNum = "a";
            List listA = new ArrayList();
            List listB = new ArrayList();
            objReader = new BufferedReader(new FileReader("C:\\Users\\FoxSe\\OneDrive\\Рабочий стол\\Старое\\14.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                System.out.println(strCurrentLine);
                for (int i = 0; i < strCurrentLine.length(); ++i) {
                    if (Character.isDigit(strCurrentLine.charAt(i))) {
                        if (isNum == false) {
                            strNum = Character.toString(strCurrentLine.charAt(i));
                            isNum = true;
                        } else {
                            strNum = strNum + Character.toString(strCurrentLine.charAt(i));
                        }
                    }
                    else {
                       if (isNum == true){
                           isNum = false;
                          listA.add(strNum);
                           intNum = Integer.valueOf(strNum);
                           if ((intNum % 2) == 1 ){
                               listB.add(strNum);
                           }
                       }
                    }
                }
                if (isNum == true){
                    isNum = false;
                    listA.add(strNum);
                    intNum = Integer.valueOf(strNum);
                    if ((intNum % 2) == 1 ){
                        listB.add(strNum);
                    }
                }
            }
        System.out.println(listA);
        System.out.println(listB);
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
