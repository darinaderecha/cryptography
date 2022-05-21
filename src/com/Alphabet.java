package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Alphabet {

    public List<Character> alphabet;
    public Map<Character, Integer> moreCommonLetters;


    public  List<Character> ordinaryAlphabet(){
        alphabet = new ArrayList<>();
        char startAlphabet = 'А';
        char endAlphbet = 'я';
        for (int i = startAlphabet; i <= endAlphbet; i++) {
            alphabet.add((char) i);
        }
        alphabet.add( 'Ё');
        alphabet.add( 'ё');
        alphabet.add('.');
        alphabet.add(',');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('!');
        alphabet.add('?');
        alphabet.add(' ');

        return alphabet;
    }
    public Map<Character, Integer> moreCommonLetters(){
        moreCommonLetters = new TreeMap<>();
        moreCommonLetters.put('о', 5);
        moreCommonLetters.put('а', 5);
        moreCommonLetters.put('е', 5);
        moreCommonLetters.put('и', 5);
        moreCommonLetters.put('к', 5);
        moreCommonLetters.put('в', 5);
        moreCommonLetters.put('н', 5);
        moreCommonLetters.put('с', 5);
        moreCommonLetters.put('п', 5);

        return moreCommonLetters;
    }




}
