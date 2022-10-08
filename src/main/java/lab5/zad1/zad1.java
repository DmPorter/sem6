package lab5.zad1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class zad1 {
    public static void main(String[] args) {
        ReadFile1 readFile = new ReadFile1();
        try {
            ArrayList<Double> fileDbl = readFile.readValues("C:\\Users\\nasty\\Desktop\\Nastya.txt");
            System.out.println(fileDbl);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();}
    }
}