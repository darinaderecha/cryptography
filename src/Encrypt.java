import java.util.ArrayList;
import java.util.List;

public class Encrypt {
     private final int cipherKey = 10;


    public String encrypt(String message, List<Character> alphabet){

        char[] charsFromMessage = message.toCharArray();

        StringBuilder builder = new StringBuilder(message.length());

        for (int i = 0; i < charsFromMessage.length; i++) {
            for (int j = 0; j < alphabet.size(); j++) {

                if(alphabet.get(j) == charsFromMessage[i]){
                    if(j >= alphabet.size() - cipherKey){
                        charsFromMessage[i] = alphabet.get(j - alphabet.size() - 1 + cipherKey);
                    } else {
                        charsFromMessage[i] = alphabet.get(j + cipherKey);
                    }
                    builder.append(charsFromMessage[i]);
                    break;



                }

            }


        }
        return String.valueOf(builder);





    }
}
