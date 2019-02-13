package com.student.wordCount;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Words text = new Words();
        String allWords = text.getWords();
        System.out.println("before regexp: " + allWords);
        String cleanText = allWords.replaceAll("[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']", "").toLowerCase();

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
            System.out.println("count: " + hashMap.get(w) + " Word: " + w);
        }

        ArrayList<HashMap.Entry<String, Integer>> sortedMap = new ArrayList<HashMap.Entry<String, Integer>>();
        sortedMap.addAll(hashMap.entrySet());
        Collections.sort(sortedMap, new Comparator<HashMap.Entry<String, Integer>>(){
            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2){
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        System.out.println(sortedMap);
    }
}
