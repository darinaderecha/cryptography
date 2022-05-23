package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Alphabet {

    public static List<Character> alphabets;
    public  static List<Character> smallLettersList;
    public static List<Character> bigLetterList;
    List<Character> points;

    public List<Character> ordinaryAlphabet() {
        alphabets = new ArrayList<>();
        char startAlphabet = 'А';
        char endAlphabet = 'я';
        for (int i = startAlphabet; i <= endAlphabet; i++) {
            alphabets.add((char) i);
        }
        alphabets.add(6, 'Ё');
        alphabets.add(39, 'ё');
        return alphabets;

    }
    public List<Character> smallLettersList(){
        alphabets = ordinaryAlphabet();
        return smallLettersList = alphabets.subList(alphabets.indexOf('а'), alphabets.size());

    }
    public List<Character> bigLetterList(){
        alphabets = ordinaryAlphabet();
        return  bigLetterList = alphabets.subList(alphabets.indexOf('А'), alphabets.indexOf('а'));
    }
    List<Character> points(){
        points = new ArrayList<>();
        points.add('.');
        points.add(',');
        points.add('?');
        points.add('!');
        points.add(':');
        points.add('"');
        points.add(';');
        return points;
    }


}
