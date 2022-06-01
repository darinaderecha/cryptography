package com;


public class BruteForceDecoder extends Decoder {

    private int cipherKey = 0;
    private int wrongTokens = 0;

    public String decodeByBruteForce(String text) {
        return decodingCharactersInText(findCipherKey(cipherKey, text), text);


    }


    private int findCipherKey(int cipherKey, String text) {
        while (wrongTokens != -1 || cipherKey > alphabet.alphabets.size() / 2) { //проверка на правильность подбора шифра и вообще подходит ли// шифра и вообще подходит ли
            this.cipherKey++;
            String[] tokens = decodingCharactersInText(this.cipherKey, text).split(" ");
            for (int i = 0; i < tokens.length; i++) {
                if ((!doesStartCorrectly(tokens[i]) || haveLotVowelsOrConsonantsTogether(tokens[i])
                        || hasNoVowelsInBigWord(tokens[i]))) {
                    wrongTokens++;
                }
            }
            if (wrongTokens == 0) {
                wrongTokens--;
            } else {
                wrongTokens = 0;
            }

        }
        return this.cipherKey;
    }


}


