package com;

import java.util.Map;
import java.util.Optional;


public class StatisticAnalysisDecoder extends Decoder {

    private int cipherKey = 0;
    StringBuilder builder = new StringBuilder();
    char popularLetter;

    public String decodeByStatisticAnalysis(String text) {
        cipherKey = findCipherKey(popularLetter);
        return decodingCharactersInText(cipherKey, text);

    }

    private int findCipherKey(char letter){
        char mostFrequentLetterInRussian = 'о';
        char popularLetterInEncryptedText = letter;
        cipherKey = alphabet.smallLettersList().indexOf(mostFrequentLetterInRussian - popularLetterInEncryptedText);
        return cipherKey;

    }



    private String theWholeText(String text) {
        if (text.length() < 3000) {
            builder.append(text);

        }
        return String.valueOf(builder.append(text));
    }
    private char statisticAnalysisOfUsingLetters(String text){
        String textForStatisticAnalysis = theWholeText(text.trim());
        Map<Character, Integer> countLetters = alphabet.fillCaesarCircle();
        char popularLetter;
        for (char c: textForStatisticAnalysis.toCharArray()){
                countLetters.computeIfPresent(c, (k, v) -> v = v + 1);
        }
        popularLetter = countLetters
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        return popularLetter;

    }


}






