package com;

import com.Alphabet;

public class Encrypter {
    private final static int cipherKey = 10;
    Alphabet alphabet = new Alphabet();

    public String encrypt(String originalText) {
        String[] words = originalText.split(" ");
        StringBuilder wordsBuilder = new StringBuilder();// один стрингбилдер чтобы складывать буквы в слова
        StringBuilder sentenceBuilder = new StringBuilder(); // один чтобы предложения
        for (int i = 0; i < words.length; i++) { //цикл чтобы пробежать по всем словам в тексте
            char[] wordsChars = words[i].toCharArray();
            for (int j = 0; j < wordsChars.length; j++) {// цикл для букв
                if (Character.isLetter(wordsChars[j])) {
                    char temp = wordsChars[j];
                    temp = Character.toLowerCase(temp);
                       int indexOfAlphabet = alphabet.smallLettersList().indexOf(temp); // ввела эту переменную чтобы зациклить алфавит
                        if (indexOfAlphabet < cipherKey) {
                            temp = alphabet.smallLettersList().get
                                    (indexOfAlphabet - cipherKey + alphabet.smallLettersList().size());
                        }else {
                            temp = alphabet.smallLettersList().get(indexOfAlphabet - cipherKey);
                        }
                        if(Character.isTitleCase(wordsChars[j])) {
                        wordsChars[j] = Character.toUpperCase(temp);
                        }else{
                            wordsChars[j] = temp;
                    }
                }

                wordsBuilder.append(wordsChars[j]);

            }
            sentenceBuilder.append(wordsBuilder);
            sentenceBuilder.append(" ");
            wordsBuilder.delete(0, wordsBuilder.length());


        }
        System.out.println(sentenceBuilder);
        return String.valueOf(sentenceBuilder);
    }
}


