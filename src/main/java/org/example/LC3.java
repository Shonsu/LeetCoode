package org.example;

import java.util.HashSet;
import java.util.Set;

public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < length; right++) {
            if (set.contains(s.charAt(right))) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            } else {
                maxLength = Math.max(maxLength, right-left+1);
            }
                set.add(s.charAt(right));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "dvdfasdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
