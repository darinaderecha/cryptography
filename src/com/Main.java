package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
//        Encrypter en = new Encrypter();
//        en.encrypt(s.nextLine());
        FileChanger changer = new FileChanger(EncodeDecodeWays.ENCRYPT);
        changer.getTargetFile();



//        StatisticAnalysisDecoder decoder = new StatisticAnalysisDecoder();
//        decoder.statisticAnalysisDecoder();
//        FileChanger changer = new FileChanger(FileChanging.ENCRYPT);
//        changer.getEncoderOrDecodedFile();


    }


}