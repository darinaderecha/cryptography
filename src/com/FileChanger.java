package com;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
//TODO: FIX FILE WRITER

public class FileChanger {
    Scanner console = new Scanner(System.in);
    FileChanging fileChanging;
    Encrypt encrypt = new Encrypt();
    BruteForceDecoder decoder = new BruteForceDecoder();

    public FileChanger(FileChanging fileChanging) {
        this.fileChanging = fileChanging;
    }


        public File createAFile() {
            File trg = null;
            try {
               trg = new File(console.nextLine());
                if (trg.createNewFile()) {
                    System.out.println("File created: " + trg.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return trg;
        }



    }












