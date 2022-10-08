package lab5.zad4;
//ReadFileWithOutEXceptions
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class zad4 {
    public int scanValues(ArrayList<Double> a, String filename){
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
        }catch (FileNotFoundException ex) {
            return -1;
        }

        String str;

        while (sc.hasNext()) {
            str = sc.nextLine();
            try {
                a.add(Double.parseDouble(str));
            }catch (NumberFormatException e) {
                return -2;
            }
        }
        return 0;
    }

    public int SumValues(ArrayList<Double> b, String filename) {
        ArrayList<Double> fileDoub = new ArrayList<>();
        int c = scanValues(fileDoub,filename);
        if (c == 0){
            double sum = 0;
            for (Double i : fileDoub){
                sum +=i;
            }
            fileDoub.add(sum);
            return 0;
        }
        else return c;
    }
}