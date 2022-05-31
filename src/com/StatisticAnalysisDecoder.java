package com;

import java.util.List;


public class StatisticAnalysisDecoder extends Decoder {

    private int cipherKey = 0;
    private static int wrongTokens = 0;

    public String decodeByStatisticAnalysis(String text) {
        cipherKey = findCipherKey(text);
        return decodingCharactersInText(cipherKey, text);


    }
    public int findCipherKey(String text) {
        while (wrongTokens != -1) {
            cipherKey++;
            String[] tokens = decodingCharactersInText(cipherKey, text).split(" ");
            for (int i = 0; i < tokens.length; i++) {
                if ( !hasCorrectOneLetterWords(tokens[i])
                        && hasNoVowelsInBigWord(tokens[i])
                        && haveLotVowelsOrConsonantsTogether(tokens[i])
                        && !doesStartCorrectly(tokens[i])) {
                    wrongTokens++;

                }

                if (wrongTokens == 0) {
                    wrongTokens--;
                } else {
                    wrongTokens = 0;
                }

            }
        }
        return cipherKey;
    }


    public boolean countMostCommonLetters(String text) {

        char[] chars = text.trim().toCharArray();
        int oCount = 0;
        int aCount = 0;
        int eCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'о') {
                oCount++;
            } else if (chars[i] == 'а') {
                aCount++;
            } else if (chars[i] == 'е') {
                eCount++;
            }

        }
        if(((oCount * 1.0 * chars.length) / 100 >= 0.09)
                && (eCount *1.0 * chars.length) / 100 >= 0.08
                && (aCount * 1.0 * chars.length)/100 >= 0.078){
            return true;
        }
        return false;

    }





}
