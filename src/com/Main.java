package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);
//        StatisticAnalysisDecoder decoder = new StatisticAnalysisDecoder();
//        decoder.statisticAnalysisDecoder();
        FileChanger changer = new FileChanger(FileChanging.ENCRYPT);
        changer.getEncoderOrDecodedFile();


        }


    }

