package lab4.dop;

import lab4.dop.message.IAmHere;
import lab4.dop.message.Message;


public class Task {
    public static void main(String[] args) {
        try {
            DIServiceLoader<Message> messageDI = DIServiceLoader.load(Message.class);
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean("S2").getMessage());
            System.out.println(messageDI.getBean(IAmHere.class).getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}