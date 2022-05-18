import java.util.List;

public class Encrypt {
     private final static int cipherKey = 10;
     Alphabet alphabet = new Alphabet();


    public String encrypt(String message){
        List<Character> al = alphabet.ordinaryAlphabet();


        char[] charsFromMessage = message.toCharArray();

        StringBuilder builder = new StringBuilder(message.length());

        for (int i = 0; i < charsFromMessage.length; i++) {
            for (int j = 0; j < al.size(); j++) {

                if(al.get(j) == charsFromMessage[i]){
                    if(j >= al.size() - cipherKey){
                        charsFromMessage[i] = al.get(j - al.size() - 1 + cipherKey);
                    } else {
                        charsFromMessage[i] = al.get(j + cipherKey);
                    }
                    builder.append(charsFromMessage[i]);
                    break;



                }

            }


        }
        return String.valueOf(builder);





    }
}
