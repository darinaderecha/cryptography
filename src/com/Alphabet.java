package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Alphabet {

    public List<Character> alphabets;

    public List<Character> ordinaryAlphabet() {
        alphabets = new ArrayList<>();
        char startAlphabet = 'А';
        char endAlphabet = 'я';
        for (int i = startAlphabet; i <= endAlphabet; i++) {
            alphabets.add((char) i);
        }
        alphabets.add(6, 'Ё');
        alphabets.add(38, 'ё');

        return alphabets;
    }


}
