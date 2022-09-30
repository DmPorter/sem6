package lab4.protecteddemonstr;

import lab4.protecteddemonstr.fxghj.A;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();

        //B имеет доступ к protected полю
        System.out.println(b.getA());

        // Доступа к полю из другого пакета нет
        //System.out.println(b.a);
        //System.out.println(a.a);
    }

}
