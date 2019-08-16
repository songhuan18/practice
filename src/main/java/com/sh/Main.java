package com.sh;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author sh
 * Date 2019-08-11 15:46
 */
public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(sort(line));
        }
    }

    private static String sort(String line) {

        char[] chars = line.toCharArray();
        Map<Character, List<Character>> mapChar = new HashMap<>();
        for (int i = 0, len = chars.length; i < len; i++) {
            char aChar = chars[i];
            List<Character> charList = mapChar.getOrDefault(aChar, new ArrayList<>());
            charList.add(aChar);
            mapChar.put(aChar, charList);
        }
        Map<Character, Integer> sortedMap = new HashMap<>();
        mapChar.forEach((k, v) -> sortedMap.put(k, v.size()));
        Map<Character, Integer> result = sortedMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));
        List<String> list = new ArrayList<>();
        result.forEach((k, v) -> {
            List<Character> characters = mapChar.get(k);
            String str = "";
            for (Character c : characters) {
                str += c;
            }
            list.add(str);
        });
        String ss = "";
        for (String s : list) {
            ss += s;
        }
        return ss;
    }
}
