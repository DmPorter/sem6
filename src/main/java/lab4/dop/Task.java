package lab4.dop;

import lab4.dop.message.Message;
import lab4.dop.message.Privet;

import java.util.Iterator;
import java.util.PrimitiveIterator;


public class Task {
    public static void main(String[] args) {
        try {
            DIServiceLoader messageDI = DIServiceLoader.load();
            System.out.println(messageDI.getBean("S1").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean(Privet.class).getMessage());

            Iterator<Message> iterator = messageDI.iterator();
            System.out.println("-------------------------------");
            while(iterator.hasNext()){
                System.out.println(iterator.next().getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}