package com;

import com.Alphabet;

public abstract class Decoder {
    Alphabet alphabet = new Alphabet();
    //общий класс для проверки лексем

       //метод для перекодировки всех chars в тексте
        public  String decodingCharactersInText(int cipherKey, String text){
        char[] decodingArray = text.toCharArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < decodingArray.length; i++) {
            if (Character.isLetter(decodingArray[i])) {//здесь я пожертвовала символами препинания, сравнивала знаки по char кодировке
                int index = alphabet.ordinaryAlphabet().indexOf(decodingArray[i]);
                decodingArray[i] = alphabet.ordinaryAlphabet().get(index + cipherKey);

            }
        }
        return String.valueOf(b);
    }

    public static boolean doesStartCorrectly(String tokens){
        if (tokens.startsWith("Ы") || tokens.startsWith("Ь")
                || tokens.startsWith("ь") || tokens.startsWith("Ъ")
                || tokens.startsWith("ъ")) {
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