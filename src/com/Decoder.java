package com;

public  class Decoder implements ForDifferentChars {
    Alphabet alphabet = new Alphabet();
    StringBuilder builder = new StringBuilder();
    int key;


    //метод для перекодировки всех chars в тексте
    // на вход получает строку и подобранный ключ, на выход передвет строку, которую я использую в BruteForceDecoder
        public  String decodingCharactersInText(int cipherKey, String text){
        char[] decodingArray = text.toCharArray();
        for (int i = 0; i < decodingArray.length; i++) {
            char temp = decodingArray[i];
            key = cipherKey;
            if(Character.isUpperCase(temp)){
                forBigLetters(temp);
            } else if (Character.isLowerCase(temp)) {
                forSmallLetters(temp);
            } else {
                forOtherCharacters(temp);
            }
           builder.append(temp);
        }
        return String.valueOf(builder);
    }
 // здесь методы проверки лексем, которые одинаково подходят для двух методов
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

    @Override
    public Character forBigLetters(char temp) {
        int index = alphabet.bigLetterList().indexOf(temp);
        if(index > alphabet.bigLetterList().size() - 1 - key){
            temp = alphabet.bigLetterList().get(index + key - alphabet.bigLetterList().size());
        } else {
            temp = alphabet.bigLetterList().get(index + key);
        }
        return temp;
    }

    @Override
    public Character forSmallLetters(char temp) {
        int index = alphabet.smallLettersList().indexOf(temp);
        if(index > alphabet.smallLettersList().size() - 1 - key){
            temp = alphabet.smallLettersList().get(index + key - alphabet.smallLettersList().size());
        } else {
            temp = alphabet.smallLettersList().get(index + key);
        }
        return temp;
    }



    @Override
    public Character forOtherCharacters(char temp) {
        if(Character.isDigit(temp) || alphabet.points().contains(temp)){
            //wordsBuilder.append(temp);

        }
        return temp;
    }
}
