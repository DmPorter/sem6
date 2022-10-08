package lab5.zad5;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class zad5 {
    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            sc = new Scanner(Paths.get("C:\\Users\\nasty\\IdeaProjects\\sem6\\src\\main\\resources\\in"));
            pw = new PrintWriter("C:\\Users\\nasty\\IdeaProjects\\sem6\\src\\main\\resources\\out");
            while (sc.hasNext()) {
                pw.println(sc.next().toLowerCase());
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            close(sc);
            close(pw);
        }
    }

    private static void close(Closeable out) {
        if (out != null) {

            try {
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}