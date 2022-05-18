import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Encrypt encrypt = new Encrypt();


        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(encrypt.encrypt(string, alphabet.ordinaryAlphabet()));


    }
}
