package com;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StatisticAnalysisDecoder extends Decoder{
    Map <Character, Integer> statisticCount;




    public Map<Character, Integer> getStatisticCount(String text){
        statisticCount = new TreeMap<>();
        int countCharacters = 0;
        char[] analysisArray = decodingArray(0, text).toCharArray();
        for (int i = 0; i < analysisArray.length; i++) {
                if(statisticCount.containsKey(analysisArray[i])){
                    statisticCount.put(analysisArray[i], countCharacters++);
                } else {;
                    statisticCount.put(analysisArray[i], countCharacters++);
                }

        }
        System.out.println(statisticCount.entrySet());

        return statisticCount;
        }

        private Map<Character, Integer> getFiveMostCommonLetters( Map<Character, Integer> statisticCount){
        Map<Character, Integer> fiveMostCommonLetters = new TreeMap<>();
//        int max = statisticCount.values().stream().max(Integer::compare).get();
//        fiveMostCommonLetters = statisticCount.values()
//                .stream()
//                .sorted(Integer::compareTo).
//                collect(Collectors.toCollection(fiveMostCommonLetters));


 return null;
        }
         public String statisticAnalysisDecoder(String text){
return null;
         }



    }


