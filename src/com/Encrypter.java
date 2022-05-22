package com;

import com.Alphabet;

import java.util.ArrayList;
import java.util.List;

public class Encrypter {
    private final static int cipherKey = 10;
    Alphabet alphabet = new Alphabet();
    StringBuilder wordsBuilder = new StringBuilder();// один стрингбилдер чтобы складывать буквы в слова
    StringBuilder sentenceBuilder = new StringBuilder(); // один чтобы предложения

    public String encrypt(String text) {
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) { //цикл чтобы пробежать по всем словам в строке
                char[] wordsChars = words[i].toCharArray();
                for (int j = 0; j < wordsChars.length; j++) {// цикл для букв
                        char temp = wordsChars[j];
                        if (Character.isUpperCase(temp)) {
                            bigLetterEncoder(temp);
                        } else if (Character.isLowerCase(temp)) {
                            smallLettersEncoder(temp);
                        } else {
                            pointsEncoder(temp);

                        }
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

    public Character smallLettersEncoder(char temp) {
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

    public Character bigLetterEncoder(char temp) {
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

    public Character pointsEncoder(char temp){
        if(Character.isDigit(temp) || alphabet.points().contains(temp)){
            wordsBuilder.append(temp);

        }
        return temp;
    }

}


