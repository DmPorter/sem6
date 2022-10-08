package lab5.zad6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class zad6 {

    public void correct01 (){
        BufferedReader in = null;

        try {
            in = Files.newBufferedReader(Path.of("\"C:\\Users\\nasty\\Desktop\\Nastya.txt\""), StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.out.println("IOex " + e.getMessage());

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void correct3(){
        BufferedReader in = null;

        try {
            in = Files.newBufferedReader(Path.of("\"C:\\Users\\nasty\\Desktop\\Nastya.txt\""), StandardCharsets.UTF_8);
            try{
                in.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }catch (IOException ex) {
            System.out.println("IOex: " + ex.getMessage());
        }
    }

    public void correct2 (){
        try (BufferedReader in = Files.newBufferedReader(Path.of("\"C:\\Users\\nasty\\Desktop\\Nastya.txt\""), StandardCharsets.UTF_8)){
            in.lines();

        }catch (IOException ex) {
            System.out.println("IOex: " + ex.getMessage());
        }
    }}