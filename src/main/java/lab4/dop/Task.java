package lab4.dop;

import lab4.dop.message.IAmHere;
import lab4.dop.message.Message;

import java.util.Iterator;


public class Task {
    public static void main(String[] args) {
        try {
            DIServiceLoader messageDI = DIServiceLoader.load(Message.class);
            System.out.println(messageDI.getBean("S1").getMessage()); // если первый раз мы вызываем бин, то он загружается из ServiceLoader
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage()); // если бин уже был загружен, то он возвращается нам из нашего map
            System.out.println(messageDI.getBean(IAmHere.class).getMessage());

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