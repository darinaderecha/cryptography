package com;

public  class Decoder implements ForDifferentChars {
    Alphabet alphabet = new Alphabet();
    StringBuilder wordsBuilder = new StringBuilder();
    StringBuilder sentenceBuilder = new StringBuilder();
    int key;


    //метод для перекодировки всех chars в тексте
    // на вход получает строку и подобранный ключ, на выход передвет строку, которую я использую в BruteForceDecoder
        public  String decodingCharactersInText(int cipherKey, String text){
        String[] tokens = text.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            char decodingCharsArray[] = tokens[i].toCharArray();
            for (int j = 0; j < decodingCharsArray.length; j++) {
                char temp = decodingCharsArray[j];
                key = cipherKey;
                decoder(temp, key);
                decodingCharsArray[j] = temp;
            }
            sentenceBuilder.append(wordsBuilder);
            sentenceBuilder.append(" ");
            wordsBuilder.delete(0, wordsBuilder.length());
        }
            String decryptedText = String.valueOf(sentenceBuilder);
            sentenceBuilder.delete(0, sentenceBuilder.length());

            return decryptedText;
          
        }

        public void decoder(char temp, int cipherKey){
            if (Character.isUpperCase(temp)) {
                forBigLetters(temp, cipherKey);
            } else if (Character.isLowerCase(temp)) {
                forSmallLetters(temp, cipherKey);
            } else {
                forOtherCharacters(temp);
            }

        }



    @Override
    public Character forBigLetters(char temp, int cipherKey) {
        int index = alphabet.bigLetterList().indexOf(temp);
        if(index > alphabet.bigLetterList().size() - 1 - key){
            temp = alphabet.bigLetterList().get(index + key - alphabet.bigLetterList().size());
        } else {
            temp = alphabet.bigLetterList().get(index + key);
        }
        wordsBuilder.append(temp);
        return temp;
    }

    @Override
    public Character forSmallLetters(char temp, int cipherKey) {
        int index = alphabet.smallLettersList().indexOf(temp);
        if(index > alphabet.smallLettersList().size() - 1 - key){
           temp = alphabet.smallLettersList().get(index + key - alphabet.smallLettersList().size());

        } else {
            temp = alphabet.smallLettersList().get(index + key);
        }
        wordsBuilder.append(temp);
        return temp;

    }



    @Override
    public Character forOtherCharacters(char temp) {
        if(Character.isDigit(temp) || alphabet.points().contains(temp)){
        wordsBuilder.append(temp);
        }
        return temp;
    }
    // здесь методы проверки лексем, которые одинаково подходят для двух методов
    //проверка чтобы текст не начинался с этих букв
    public static boolean doesStartCorrectly(String tokens){
        if (tokens.startsWith("Ы") || tokens.startsWith("Ь")
                || tokens.startsWith("ь") || tokens.startsWith("Ъ")
                || tokens.startsWith("ъ") || tokens.startsWith("ы")) {
            return false;
        }
        return true;
    }
    //проверка на обилие гласных или согласных букв, которые не характерны для русского языка
    public static boolean haveLotVowelsOrConsonantsTogether(String tokens){
        String invalidRegex1 = "[АУИЄОЫЕЯауиэоыея+]{3}+";
        String invalidRegex2 = "[ЧСМТБЮЖДЛРПВФЙЦКНГШЩЗЪчсмтбджлрпвфйцкнгшщзхъ]{4}+";
        if (tokens.matches(invalidRegex1) || tokens.matches(invalidRegex2)) {
            return true;
        }
        return false;
    }
    //проверка на наличие гласных в больших словах
    public static boolean hasNoVowelsInBigWord(String tokens){
        String invalidRegex3 = "[^аяоиеэыюу]+";
        if(tokens.length() > 3 && tokens.matches(invalidRegex3)){
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
