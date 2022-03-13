package main.java.com.company;
import com.company.MeReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


    public class Main {

        public static void main(String[] args) {
            MeReader meReader = new MeReader();
            meReader.read("14.txt");
        }
    }