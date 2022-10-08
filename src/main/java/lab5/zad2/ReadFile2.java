package lab5.zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile2 {
    public ArrayList<Double> scanValues(String fileName)
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

    public double sumValues(String filename)
            throws FileNotFoundException {
        ArrayList<Double> fileDoub = scanValues(filename);
        double sum = 0;

        for (Double i : fileDoub){
            sum+=i;
        }
        return  sum;
    }
}
