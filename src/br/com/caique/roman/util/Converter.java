package br.com.caique.roman.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Converter {

    private static final Map<String, Integer> ARABIC_ROMAN_MAP = new LinkedHashMap<>();

    public Converter() {
        ARABIC_ROMAN_MAP.put("M", 1000);
        ARABIC_ROMAN_MAP.put("CM", 900);
        ARABIC_ROMAN_MAP.put("D", 500);
        ARABIC_ROMAN_MAP.put("CD", 400);
        ARABIC_ROMAN_MAP.put("C", 100);
        ARABIC_ROMAN_MAP.put("XC", 90);
        ARABIC_ROMAN_MAP.put("L", 50);
        ARABIC_ROMAN_MAP.put("XL", 40);
        ARABIC_ROMAN_MAP.put("X", 10);
        ARABIC_ROMAN_MAP.put("IX", 9);
        ARABIC_ROMAN_MAP.put("V", 5);
        ARABIC_ROMAN_MAP.put("IV", 4);
        ARABIC_ROMAN_MAP.put("I", 1);
    }

    public String toRoman(Integer arabic){
        String roman = "";
        for (String romanLetter : ARABIC_ROMAN_MAP.keySet()){
            Integer aux = ARABIC_ROMAN_MAP.get(romanLetter);
            while (arabic >= aux){
                arabic -= aux;
                roman = roman.concat(romanLetter);
            }

        }
        return roman;
    }

    public Integer toArabic(String roman){
        Integer arabic = 0;
        for (String romanLetter : ARABIC_ROMAN_MAP.keySet()){
            while(roman.startsWith(romanLetter)){
                arabic += ARABIC_ROMAN_MAP.get(romanLetter);
                if (roman.length() >= romanLetter.length())
                    roman = roman.substring(romanLetter.length());
            }
        }
        return arabic;
    }

}
