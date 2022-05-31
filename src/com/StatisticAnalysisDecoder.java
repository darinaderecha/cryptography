package com;

import java.util.List;


public class StatisticAnalysisDecoder extends Decoder {

    private int cipherKey = 0;
    private static int wrongTokens = 0;

    public String decodeByStatisticAnalysis(String text) {
        cipherKey = findCipherKey(text);
        return decodingCharactersInText(cipherKey, text);


    }
// написать цикл которій посчитает количесво

    private int findCipherKey(String text) {
        if (!countMostCommonLetters(text)) {
            wrongTokens++;
            System.out.println(cipherKey);
        }
        return 1;
    }






//    private int findCipherKey(String text) {
//        String wholeText = null;
//        while (wrongTokens != -1) {
//            this.cipherKey++;
//            String[] tokens = decodingCharactersInText(cipherKey, text).split(" ");
//            for (int i = 0; i < tokens.length; i++) {
//                if ( !hasCorrectOneLetterWords(tokens[i])
//                        && hasNoVowelsInBigWord(tokens[i])
//                        && haveLotVowelsOrConsonantsTogether(tokens[i])
//                        && !doesStartCorrectly(tokens[i])) {
//                    wrongTokens++;
//
//                }
//                if (wrongTokens == 0) {
//                    return wrongTokens--;
//                } else {
//                    return wrongTokens = 0;
//                }
//
//            }
//        }
//        return cipherKey;
//    }


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

    //проверка на корректные прелоги, местоимения
    public static boolean hasCorrectOneLetterWords(String tokens){
        if(tokens.length() == 1 &&(tokens.equalsIgnoreCase("я") ||
                tokens.equalsIgnoreCase("о") ||
                tokens.equalsIgnoreCase("у") ||
                tokens.equalsIgnoreCase("к") ||
                tokens.equalsIgnoreCase("в") ||
                tokens.equalsIgnoreCase("с") ||
                tokens.equalsIgnoreCase("и") ||
                tokens.equalsIgnoreCase("а") ||
                tokens.equalsIgnoreCase("б"))){
            return true;
        }
        return false;
    }
}






