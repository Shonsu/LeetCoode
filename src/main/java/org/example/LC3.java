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
                maxLength = Math.max(maxLength, right - left + 1);
            }
            set.add(s.charAt(right));
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        int[] chars = new int[256];
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c] > 0) {
                System.out.println(c + ": " + chars[c] + " start: " + start);
                start = Math.max(chars[c], start);
                //start = chars[c];
            }
            chars[c] = i + 1 ;
            int res = i - start + 1;
            if (max < res) {
                max = res;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstringV2(s));
    }
}
