package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Alphabet {

    public List<Character> alphabets;
    public List<Character> points;
    public Map<Character, Integer> caesarCircle;


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
    public Map<Character, Integer> fillCaesarCircle(){
        int i = 0;
        caesarCircle  = new HashMap<>();
        for(char c: ordinaryAlphabet()){
            caesarCircle.put(c, i);
        }
        return caesarCircle;
    }
    public List<Character> smallLettersList(){
        alphabets = ordinaryAlphabet();
        return  alphabets.subList(alphabets.indexOf('а'), alphabets.size());

    }
    public List<Character> bigLetterList(){
        alphabets = ordinaryAlphabet();
        return  alphabets.subList(alphabets.indexOf('А'), alphabets.indexOf('а'));
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
        points.add('-');
        return points;
    }


}
