package com;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileChanger changer;
        Alphabet a = new Alphabet();
        System.out.println(a.bigLetterList().size());
        System.out.println(a.smallLettersList().size());
        System.out.println(a.ordinaryAlphabet().size());

        System.out.println("Если ты хочешь зашифровать текст - введи в консоль \"1\" \n"
        + "Если хочешь расшифровать методом Brute Force - введи \"2\"  \n" +
                "Если расшифровать методом статистического анализа - \"3\"" );
        int i = scanner.nextInt();
        if (i == 1){
            changer = new FileChanger(EncodeDecodeWays.ENCRYPT);
        } else if(i == 2){
            changer = new FileChanger(EncodeDecodeWays.DECODE_BY_BRUTE_FORCE);
        } else {
            changer = new FileChanger(EncodeDecodeWays.DECODE_BY_STATISTIC_ANALYSIS);
        }
        changer.getTargetFile();






    }


}