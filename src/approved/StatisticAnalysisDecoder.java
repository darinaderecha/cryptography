//package com;
//
//import java.util.*;
//
//public class StatisticAnalysisDecoder extends Decoder {
//    //Map<Character, Integer> statisticCount;
//    Scanner scanner = new Scanner(System.in);
//
//
//    public Map<Character, Integer> getStatisticCount(String text) {
//        Map<Character, Integer> statisticCount = new TreeMap<>();
//        int countCharacters = 0;
//        char[] analysisArray = decodingArray(0, text).toCharArray();
//        for (int i = 0; i < analysisArray.length; i++) {
//            if (statisticCount.containsKey(analysisArray[i])) {
//                statisticCount.put(analysisArray[i], countCharacters++);
//            } else {
//                ;
//                statisticCount.put(analysisArray[i], countCharacters++);
//            }
//        }
//        System.out.println(statisticCount.entrySet());
//
//        return statisticCount;
//    }
//
//
//    public String statisticAnalysisDecoder() {
//        List<Integer> moreCommonLetters = new ArrayList<>();
//        Map<Character, Integer> statisticCount = getStatisticCount(scanner.nextLine());
//
//        for (int i = 0; i < 5; i++) {
//            int max = statisticCount.values().stream().max(Integer::compareTo).get();
//            moreCommonLetters.add(max);
//            //statisticCount.ge
//        }
//        for (int i:moreCommonLetters ) {
//            System.out.println(i);
//
//        }
//        return null;
//
//
//    }
//}
//
//
