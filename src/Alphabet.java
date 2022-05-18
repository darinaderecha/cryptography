import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public List<Character> alphabet;


    public  List<Character> ordinaryAlphabet(){
        alphabet = new ArrayList<>();
        char startAlphabet = 'А';
        char endAlphbet = 'я';
        for (int i = startAlphabet; i <= endAlphbet; i++) {
            alphabet.add((char) i);

        }
        alphabet.add('Ё');
        alphabet.add('ё');
        alphabet.add('.');
        alphabet.add(',');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('!');
        alphabet.add('?');
        alphabet.add(' ');


        return alphabet;

    }


}
