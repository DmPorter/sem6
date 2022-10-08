package lab5.zad8;
import java.util.concurrent.locks.ReentrantLock;

public class zad8 {
    private static MethodClass getLock(){
        MethodClass myClass = new MethodClass(new ReentrantLock());
        myClass.lock();
        return myClass;
    }

    public static void main(String[] args) {
        try(MethodClass lock = getLock()){
            System.out.println("ok");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}