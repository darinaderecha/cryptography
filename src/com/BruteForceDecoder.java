package com;

public class BruteForceDecoder extends Decoder {
    private int cipherKey = 0;
    int wrongTokens = 0;
    String decodedText = null;



    public String decodeByBruteForce(String text) {
        while (wrongTokens != -1 || cipherKey == 100) { //проверка на правильность подбора шифра и вообще подходит ли// шифра и вообще подходит ли
            cipherKey++;
            StringBuilder builder = new StringBuilder();
            String[] tokens = decodingArray(cipherKey,text).split(" ");
            for (int i = 0; i < tokens.length; i++) {
                if ((!doesStartCorrectly(tokens[i]) || haveLotVowelsOrConsonantsTogether(tokens[i])
                        ||tokens[i].length() > 15 || hasNoVowelsInBigWord(tokens[i]))) {
                    wrongTokens++;
                }
            }
            if (wrongTokens == 0) {
                wrongTokens--;
                decodedText = decodingArray(cipherKey, text);


            } else  {
                wrongTokens = 0;
            }

          decodedText = String.valueOf(builder.append(decodedText));
        }

        return decodedText;
    }

    
    
}
