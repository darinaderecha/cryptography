package com;

import com.Alphabet;

import java.util.ArrayList;
import java.util.List;

public abstract class Decoder {
    Alphabet alphabet = new Alphabet();
    List<String> decodedLines;
    //общий класс для проверки лексем

       //метод для перекодировки всех chars в тексте
        public  String decodingCharactersInText(int cipherKey, String text){
        char[] decodingArray = text.toCharArray();
        decodedLines = new ArrayList<>();
        for (int i = 0; i < decodingArray.length; i++) {
            if (Character.isLetter(decodingArray[i])) {
                int index = alphabet.smallLettersList().indexOf(decodingArray[i]);
                if(index > alphabet.smallLettersList().size() - 1 - cipherKey){
                    decodingArray[i] = alphabet.smallLettersList().get(index + cipherKey - alphabet.smallLettersList().size());
                } else {
                    decodingArray[i] = alphabet.smallLettersList().get(index + cipherKey);
                }

            } else if(Character.isSpaceChar(decodingArray[i])){
                decodingArray[i] = ' ';
            }
            //
        }


        return null;
    }

    public static boolean doesStartCorrectly(String tokens){
        if (tokens.startsWith("Ы") || tokens.startsWith("Ь")
                || tokens.startsWith("ь") || tokens.startsWith("Ъ")
                || tokens.startsWith("ъ") || tokens.startsWith("ы")) {
            return false;
        }
        return true;
    }
    public static boolean haveLotVowelsOrConsonantsTogether(String tokens){
        String invalidRegex1 = "[АУИЄОЫЕЯауиэоыея+]{3}+";
        String invalidRegex2 = "[ЧСМТБЮЖДЛРПВФЙЦКНГШЩЗЪчсмтбджлрпвфйцкнгшщзхъ]{4}+";
        if (tokens.matches(invalidRegex1) || tokens.matches(invalidRegex2)) {
            return true;
        }
        return false;
    }
    public static boolean hasNoVowelsInBigWord(String tokens){
        String invalidRegex3 = "[^аяоиеэыюу]+";
        if(tokens.length() > 3 && tokens.matches(invalidRegex3)){
            return true;
        }
        return false;
    }
}
