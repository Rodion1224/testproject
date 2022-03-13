package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeReader {
    public void read(String filename) {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            boolean isNum = false; //Признак начала чтения числа в строке
            Integer intNum; // Прочитаное число тип Integer
            String strNum = "a"; // Прочитаное число тип String
            List listA = new ArrayList(); // Объявление списка A
            List listB = new ArrayList(); // Объявление списка B
            ClassLoader cl = this.getClass().getClassLoader();
            objReader = new BufferedReader(new FileReader(cl.getResource(filename).getFile())); // Открытие текстового файла
            while ((strCurrentLine = objReader.readLine()) != null) { // Чтение строки
                System.out.println(strCurrentLine); // Печать строки
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
                            listA.add(strNum); //добавление элемента в список A
                            intNum = Integer.valueOf(strNum);
                            if ((intNum % 2) == 1 ){
                                listB.add(strNum); //добавление элемента в список B
                            }
                        }
                    }
                }
                if (isNum == true){
                    isNum = false;
                    listA.add(strNum); //добавление элемента в список A
                    intNum = Integer.valueOf(strNum);
                    if ((intNum % 2) == 1 ){
                        listB.add(strNum); //добавление элемента в список B
                    }
                }
            }
            System.out.println(listA); //Печать списка A
            System.out.println(listB); //Печать списка B
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

