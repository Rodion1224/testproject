package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MeReader {
    public void read(String filename) {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            boolean isNum = false; //Признак начала чтения числа в строке
            int intNum; // Прочитаное число тип Integer
            String strNum = "a"; // Прочитаное число тип String
            List<String> listAllNumbers = new ArrayList<>(); // Объявление списка всех чисел
            List<String> listOddNumbers = new ArrayList<>(); // Объявление списка нечетных чисел
            ClassLoader cl = this.getClass().getClassLoader();
            URL resource = cl.getResource(filename);
            if (resource == null){
                System.out.println("Данный файл не существует!");
                return;
            }

            objReader = new BufferedReader(new FileReader(resource.getFile())); // Открытие текстового файла
            while ((strCurrentLine = objReader.readLine()) != null) { // Чтение строки
                System.out.println(strCurrentLine); // Печать строки
                for (int i = 0; i < strCurrentLine.length(); ++i) {
                    if (Character.isDigit(strCurrentLine.charAt(i))) {
                        if (!isNum) {
                            strNum = Character.toString(strCurrentLine.charAt(i));
                            isNum = true;
                        } else {
                            strNum = strNum + strCurrentLine.charAt(i);
                        }
                    }
                    else {
                        if (isNum){
                            isNum = false;
                            listAllNumbers.add(strNum); //добавление элемента в список A
                            intNum = Integer.parseInt(strNum);
                            if ((intNum % 2) == 1 ){
                                listOddNumbers.add(strNum); //добавление элемента в список B
                            }
                        }
                    }
                }
                if (isNum){
                    isNum = false;
                    listAllNumbers.add(strNum); //добавление элемента в список A
                    intNum = Integer.parseInt(strNum);
                    if ((intNum % 2) == 1 ){
                        listOddNumbers.add(strNum); //добавление элемента в список B
                    }
                }
            }
            System.out.println(listAllNumbers); //Печать списка A
            System.out.println(listOddNumbers); //Печать списка B
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

