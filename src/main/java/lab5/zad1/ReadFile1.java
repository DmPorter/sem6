package lab5.zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile1 {
    public ArrayList<Double> readValues(String fileName)
            throws FileNotFoundException, NumberFormatException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<Double> fileDbl = new ArrayList<>();
        String str ;
        while (sc.hasNext()) {
            str = sc.nextLine();
            fileDbl.add(Double.parseDouble(str));
        }
        return fileDbl;
    }
}