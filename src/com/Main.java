package com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileChanger changer;
        System.out.println("Если ты хочешь зашифровать текст - введи в консоль \"1\" \n"
        + "Если хочешь расшифровать - введи \"2\"" );
        int i = scanner.nextInt();
        if (i == 1){
            changer = new FileChanger(EncodeDecodeWays.ENCRYPT);
        } else {
            changer = new FileChanger(EncodeDecodeWays.DECODE_BY_BRUTE_FORCE);
        }
        changer.getTargetFile();






    }


}