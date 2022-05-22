package com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TODO: FIX FILE WRITER

public class FileChanger {
    Scanner console = new Scanner(System.in);
    List<String> lines;
    EncodeDecodeWays ways;
    Encrypter encrypt = new Encrypter();
    BruteForceDecoder decoder = new BruteForceDecoder();
    File src;
    File dst;


    public FileChanger(EncodeDecodeWays ways) {
        this.ways = ways;
    }


    public File getTargetFile() throws IOException {
        String line;
        lines = new ArrayList<>();
        src = new File(String.valueOf(Path.of(console.nextLine())));
        dst = new File(String.valueOf(Path.of(src.getParent()) + "\\XX" + src.getName()));
        try (
                BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(src)));
                BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(dst)))
        ) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);

                switch (ways) {
                    case ENCRYPT -> {
                        writer.write(encrypt.encrypt(line));
                        writer.write("\n");
                    }
                    case DECODE_BY_BRUTE_FORCE -> {
                        writer.write(decoder.decodeByBruteForce(line));
                        writer.write("\n");

                    }

                }
            }

            reader.close();
            return dst;
        }
    }
}