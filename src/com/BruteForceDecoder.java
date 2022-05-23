package com;

import java.util.Scanner;

public class BruteForceDecoder extends Decoder  {
    Scanner scanner = new Scanner(System.in);
    private int cipherKey = 9;
    int wrongTokens = 0;
    StringBuilder builder = new StringBuilder();




    public int decodeByBruteForce(String text) {
        //String decodedText = null;
        while (wrongTokens != -1 || cipherKey == alphabet.smallLettersList().size() - 1) { //проверка на правильность подбора шифра и вообще подходит ли// шифра и вообще подходит ли
            cipherKey++;
            String[] tokens = decodingCharactersInText(cipherKey,text).split(" ");
            for (int i = 0; i < tokens.length; i++) {
                if ((!doesStartCorrectly(tokens[i]) || haveLotVowelsOrConsonantsTogether(tokens[i])
                       || hasNoVowelsInBigWord(tokens[i]))) {
                    wrongTokens++;
                }
            }
            if (wrongTokens == 0) {
//                if (isReadable()) {
                    wrongTokens--;
 //               }
                //decodedText = decodingCharactersInText(cipherKey, text);


            } else  {
                wrongTokens = 0;
            }

          //decodedText = String.valueOf(builder.append(decodedText));
        }

        return cipherKey;
    }

//    public boolean isReadable(){
//        String confirmation = scanner.nextLine();
//        System.out.println("Подтвердите читабельность текста, введите \"+\" или \"да\" иди \"yes\"");
//        if(confirmation.equals("+") || confirmation.equalsIgnoreCase("yes")
//                || confirmation.equalsIgnoreCase("да")){
//            return true;
//        } else {
//            cipherKey++;
//            return false;
//        }
//    }


}
