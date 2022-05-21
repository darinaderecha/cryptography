package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        StatisticAnalysisDecoder decoder = new StatisticAnalysisDecoder();
        decoder.getStatisticCount(s.nextLine());

    }


}
