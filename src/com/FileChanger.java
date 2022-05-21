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
    File src;
    File dst;


    public FileChanger(EncodeDecodeWays ways) {
        this.ways = ways;
    }

    
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

















