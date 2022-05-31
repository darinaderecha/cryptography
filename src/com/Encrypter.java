package com;

public class Encrypter implements ForDifferentChars{
    private final static int cipherKey = 10;
    Alphabet alphabet = new Alphabet();
    StringBuilder wordsBuilder = new StringBuilder();// один стрингбилдер чтобы складывать буквы в слова
    StringBuilder sentenceBuilder = new StringBuilder(); // один чтобы предложения

    public String changeTextToEncrypted(String text) {
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) { //цикл чтобы пробежать по всем словам в строке
                char[] wordsChars = words[i].toCharArray();
                for (int j = 0; j < wordsChars.length; j++) {// цикл для букв
                        char temp = wordsChars[j];
                        encrypt(temp);
                        wordsChars[j] = temp;
                }
                sentenceBuilder.append(wordsBuilder);
                sentenceBuilder.append(" ");
                wordsBuilder.delete(0, wordsBuilder.length());
            }
            String encryptedText = String.valueOf(sentenceBuilder);
            sentenceBuilder.delete(0, sentenceBuilder.length());

        System.out.println(encryptedText);
        return encryptedText;
    }

    public void encrypt(char temp) {
        if (Character.isUpperCase(temp)) {
            forBigLetters(temp, cipherKey);
        } else if (Character.isLowerCase(temp)) {
            forSmallLetters(temp, cipherKey);
        } else {
            forOtherCharacters(temp);
        }
    }

     @Override
    public Character forSmallLetters(char temp, int cipherKey) {
        int indexOfAlphabet = alphabet.smallLettersList().indexOf(temp); // ввела эту переменную чтобы зациклить алфавит
        if (indexOfAlphabet < cipherKey) {
            temp = alphabet.smallLettersList().get
                    (indexOfAlphabet - cipherKey + alphabet.smallLettersList().size());
        } else {
            temp = alphabet.smallLettersList().get(indexOfAlphabet - cipherKey);
        }
        wordsBuilder.append(temp);
        return temp;
    }
    @Override
    public Character forBigLetters(char temp, int cipherKey) {
        int indexOfAlphabet = alphabet.bigLetterList().indexOf(temp); // ввела эту переменную чтобы зациклить алфавит
        if (indexOfAlphabet < cipherKey) {
            temp = alphabet.bigLetterList().get
                    (indexOfAlphabet - cipherKey + alphabet.bigLetterList().size());
        } else {
            temp = alphabet.bigLetterList().get(indexOfAlphabet - cipherKey);
        }
        wordsBuilder.append(temp);
        return temp;

    }
    @Override
    public Character forOtherCharacters(char temp){
        if(Character.isDigit(temp) || alphabet.points().contains(temp)){
            wordsBuilder.append(temp);

        }
        return temp;
    }






}


