package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC20 {
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> dict = new HashMap<>();
        dict.put('}', '{');
        dict.put(']', '[');
        dict.put(')', '(');

        for (Character c : s.toCharArray()) {
            if (dict.containsValue(c)) {
                stack.add(c);

            } else if (dict.containsKey(c)) {
                if (!stack.isEmpty() && stack.getLast().equals(dict.get(c))) {
                    stack.removeLast();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]())"));
    }
}
