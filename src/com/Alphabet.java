package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Alphabet {

    public List<Character> alphabet;

    public List<Character> ordinaryAlphabet() {
        alphabet = new ArrayList<>();
        char startAlphabet = 'А';
        char endAlphabet = 'я';
        for (int i = startAlphabet; i <= endAlphabet; i++) {
            alphabet.add((char) i);
        }
        alphabet.add(6, 'Ё');
        alphabet.add(38, 'ё');
//        alphabet.add('.');
//        alphabet.add(',');
//        alphabet.add('"');
//        alphabet.add(':');
//        alphabet.add('-');
//        alphabet.add('!');
//        alphabet.add('?');
//        alphabet.add(' ');

        return alphabet;
    }


}
