package lab4.protecteddemonstr.fxghj;

public class Test {
    public static void main(String[] args) {
        // Показываем, что поле доступно из пакета (как package private)
        A a = new A();
        System.out.println(a.a);
    }
}
