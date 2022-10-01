package lab4.enummetod;

public class Test {
    Alphabet a = Alphabet.A;

    //не работает
    //Alphabet a_clone = (Alphabet) a.clone();

    Alphabet a_clone = a;
}
