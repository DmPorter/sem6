package lab5.zad2;

import java.io.FileNotFoundException;

public class zad2 {
    public static void main(String[] args) {
        ReadFile2 readFile = new ReadFile2();

        try {
            double sum = readFile.sumValues("C:\\Users\\nasty\\Desktop\\Nastya.txt");
            System.out.println(sum);}

        catch (FileNotFoundException ex) {
            System.out.println("File don't found");
            ex.printStackTrace();

        }catch (NumberFormatException ex){
            System.out.println("Format don't right");
            ex.printStackTrace();
        }
    }
}