package com;


import com.EncodeDecodeWays;
import com.Encrypter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TODO: FIX FILE WRITER

public class FileChanger {
    Scanner console = new Scanner(System.in);
    EncodeDecodeWays ways;
    Encrypter encrypt = new Encrypter();
    //    BruteForceDecoder decoder = new BruteForceDecoder();
    File src;
    File dst;


    public FileChanger(EncodeDecodeWays ways) {
        this.ways = ways;
    }

//    public File getSourceFile() {
//        System.out.println("Введите путь к файлу");
//        src = new File(String.valueOf(Path.of(console.nextLine())));
//        ;
//        return src;
//    }

    public File getTargetFile() throws IOException {
        String line;
        src = new File(String.valueOf(Path.of(console.nextLine())));
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(src)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(dst)));
        while ((line = reader.readLine()) != null) {
            switch (ways) {
                case ENCRYPT -> {
                    writer.write(encrypt.encrypt(line));
                    writer.write("\n");
                }
//                case DECODE_BY_BRUTE_FORCE -> {
//                    writer.write(decoder.decodeByBruteForce(s));
//
//                }

            }
        }

        reader.close();
        return dst;
    }
}



//    public List<String> getListFromFile(File file) throws IOException {
//        List<String> lines = new ArrayList<>();
//        String txt;
//        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(src)));
//       while ((txt = reader.readLine()) != null) {
//           lines = reader.lines().toList();
//       }
//
//        reader.close();
//        return lines;
//    }

//
//    public File getEncoderOrDecodedFile() throws IOException {
//       File src = getSourceFile();
//       List<String> lines =  getListFromFile(src);
//        dst = new File(String.valueOf(Path.of(src.getParent() + "\\REC" + src.getName())));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(dst)));
//        for (String s: lines){
//            switch (ways) {
//                case ENCRYPT -> {
//                    writer.write(encrypt.encrypt(s));
//                    writer.write("\n");
//                }
////                case DECODE_BY_BRUTE_FORCE -> {
////                    writer.write(decoder.decodeByBruteForce(s));
////
////                }
//
//            }
//
//            writer.flush();
//        }
//        writer.close();
//        return dst;
//    }
//}















