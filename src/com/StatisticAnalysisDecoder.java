package com;


import java.util.*;
import java.util.stream.Collectors;


public class StatisticAnalysisDecoder extends Decoder {

    private int cipherKey = 0;
    StringBuilder builder = new StringBuilder();
    char popularLetterInEncryptedText;
    List<Integer> keys = new ArrayList<>();



    public String decodeByStatisticAnalysis(String text) {
            cipherKey = findCipherKey(text);
            return decodingCharactersInText(cipherKey, text);


    }

    private int findCipherKey(String text) {
        text = theWholeText(text);
        char mostFrequentLetterInRussian = 'о';
        popularLetterInEncryptedText = statisticAnalysisOfUsingLetters(theWholeText(text));
        int neededKey  = alphabet.smallLettersList().indexOf(mostFrequentLetterInRussian)
                - alphabet.smallLettersList().indexOf(popularLetterInEncryptedText);
        if(neededKey != 0){
            keys.add(neededKey);

        }
        return keys.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();


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
        if(theWholeText(text).length() < 1000) {
            return false;
        } return true;
    }
}








//public class StatisticAnalysisDecoder extends Decoder {
//
//    private int cipherKey = 0;
//    StringBuilder builder = new StringBuilder();
//    char popularLetterInEncryptedText;
//
//
//    public String decodeByStatisticAnalysis(String text) {
//        if (theWholeText(text).length() < 2000) {
//            cipherKey = findCipherKey(text);
//            return decodingCharactersInText(cipherKey, text);
//        } else {
//            int certainCipherKey = findCipherKey(text);
//            return text.replace(decodingCharactersInText(cipherKey, text),
//                    decodingCharactersInText(certainCipherKey, text));
//        }
//
//
//
//    }
//
//
//    private int findCipherKey(String text) {
//            char mostFrequentLetterInRussian = 'о';
//            popularLetterInEncryptedText = statisticAnalysisOfUsingLetters(theWholeText(text));
//            cipherKey = alphabet.smallLettersList().indexOf(mostFrequentLetterInRussian)
//                    - alphabet.smallLettersList().indexOf(popularLetterInEncryptedText);
//
//        return cipherKey;
//    }
//
//
//    private String theWholeText(String text) {
//        builder.append(text);
//        String wholeText = String.valueOf(builder);
//        builder.delete(0, builder.length());
//        return wholeText;
//    }
//
//    private char statisticAnalysisOfUsingLetters(String text) {
//        String textForStatisticAnalysis = theWholeText(text.trim());
//        Map<Character, Integer> countLetters = alphabet.fillCaesarCircle();
//        if (textForStatisticAnalysis.length() > 1000) {
//            for (char c : textForStatisticAnalysis.toCharArray()) {
//                countLetters.computeIfPresent(c, (k, v) -> v = v + 1);
//            }
//
//            popularLetterInEncryptedText = countLetters
//                    .entrySet()
//                    .stream()
//                    .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
//
//
//        }
//        return popularLetterInEncryptedText;
//
//    }
////    boolean isReadyToStatisticAnalysis(String text){
////        if(text.length() < 1000) {
////            return false;
////        } return true;
////    }
//
//}
//
//
//
//
//
//
//
//
