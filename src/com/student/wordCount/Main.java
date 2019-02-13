package com.student.wordCount;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Words text = new Words();
        String allWords = text.getWords();
        System.out.println("before regexp: " + allWords);
        String cleanText = allWords.replaceAll("[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']", "");

        System.out.println("after regex: " + cleanText);
        String[] words = cleanText.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String w : words){
            if(hashMap.containsKey(w)){
                hashMap.put(w, (hashMap.get(w) + 1));
            }else{
                hashMap.put(w, 1);
            }
        }

        for(String w : hashMap.keySet()){
            System.out.println(hashMap.get(w));
        }
    }
}
