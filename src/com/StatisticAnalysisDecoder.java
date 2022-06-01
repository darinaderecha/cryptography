package com;

import java.util.Map;
import java.util.Optional;
//TODO пофиксить это


public class StatisticAnalysisDecoder extends Decoder {

    private int cipherKey = 0;
    StringBuilder builder = new StringBuilder();
    char popularLetterInEncryptedText;



    public String decodeByStatisticAnalysis(String text) {
        if(!isReadyToStatisticAnalysis(text)){
            return theWholeText(text);
        } else {
            cipherKey = findCipherKey(text);
            return decodingCharactersInText(cipherKey, text);
        }

    }

    private int findCipherKey(String text) {
        char mostFrequentLetterInRussian = 'о';
         popularLetterInEncryptedText = statisticAnalysisOfUsingLetters(theWholeText(text));
        cipherKey = alphabet.smallLettersList().indexOf(mostFrequentLetterInRussian)
                        - alphabet.smallLettersList().indexOf(popularLetterInEncryptedText);
        System.out.println(cipherKey);
        return cipherKey;

    }


    private String theWholeText(String text) {

        if (text.length() < 3000) {
           builder.append(text);
        }
        return String.valueOf(builder);
    }

    private char statisticAnalysisOfUsingLetters(String text) {
        String textForStatisticAnalysis = theWholeText(text.trim());
        Map<Character, Integer> countLetters = alphabet.fillCaesarCircle();
        if (textForStatisticAnalysis.length() > 1000){
        for (char c : textForStatisticAnalysis.toCharArray()) {
            countLetters.computeIfPresent(c, (k, v) -> v = v + 1);
        }
        popularLetterInEncryptedText = countLetters
                    .entrySet()
                    .stream()
                    .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();



        }

        return popularLetterInEncryptedText;

    }
    boolean isReadyToStatisticAnalysis(String text){
        if(theWholeText(text).length() < 2000) {
            return false;
        } return true;
        }
    }







