package com;

import com.Alphabet;

public class Encrypter {
    private final static int cipherKey = 10;
    Alphabet alphabet = new Alphabet();

    // здесь текст зашифровуется с с учетом регистра, то есть "р" маленькая
    // и "Р" большая будут означать разные символы.
    public String encrypt(String originalText) {
        String[] words = originalText.split(" ");
        StringBuilder wordsBuilder = new StringBuilder();// один стрингбилдер чтобы складывать буквы в слова
        StringBuilder sentenceBuilder = new StringBuilder(); // один чтобы предложения
        for (int i = 0; i < words.length; i++) { //цикл чтобы пробежать по всем словам в тексте
            char[] wordsChars = words[i].toCharArray();
            for (int j = 0; j < wordsChars.length; j++) {// цикл для букв
                if (Character.isLetter(wordsChars[j])) {
                    char temp = wordsChars[j];
                    int index = alphabet.ordinaryAlphabet().indexOf(temp); // ввела эту переменную чтобы зациклить алфавит
                    if (index < cipherKey) {
                        index = alphabet.ordinaryAlphabet().size() - 1 - cipherKey;
                    }
                    wordsChars[j] = alphabet.ordinaryAlphabet().get(index - cipherKey);
                } else if (Character.isSpaceChar(wordsChars[j])) {
                    wordsChars[j] = ' ';
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


//        List<String> al = alphabet.ordinaryAlphabet();
//        char[] charsFromMessage = originalText.toCharArray();
//        StringBuilder builder = new StringBuilder(message.length());
//
//        for (int i = 0; i < charsFromMessage.length; i++) {
//            for (int j = 0; j < al.size(); j++) {
//
//                if(al.get(j) == charsFromMessage[i]){
//                    if(j >= al.size() - cipherKey){
//                        charsFromMessage[i] = al.get(j - al.size() - 1 + cipherKey);
//                    } else {
//                        charsFromMessage[i] = al.get(j + cipherKey);
//                    }
//                    builder.append(charsFromMessage[i]);
//                    break;
//                }
//
//            }
//
//        }
//        return String.valueOf(builder);
//
//
//    }
