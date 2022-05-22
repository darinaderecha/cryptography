package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Alphabet a = new Alphabet();
        System.out.println(a.smallLettersList());
//        Encrypter en = new Encrypter();
//        en.encrypt(s.nextLine());
        FileChanger changer = new FileChanger(EncodeDecodeWays.DECODE_BY_BRUTE_FORCE);
        changer.getTargetFile();



//        StatisticAnalysisDecoder decoder = new StatisticAnalysisDecoder();
//        decoder.statisticAnalysisDecoder();
//        FileChanger changer = new FileChanger(FileChanging.ENCRYPT);
//        changer.getEncoderOrDecodedFile();


    }


}