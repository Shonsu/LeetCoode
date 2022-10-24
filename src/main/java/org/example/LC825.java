package org.example;

import java.util.HashMap;
import java.util.Map;

public class LC825 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,1,1,0,1,0,0};
        //nums = new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};

        System.out.println(findMaxLength(nums));

    }

    public static int findMaxLength(int[] nums) {

        int maxLength = 0;
        int diff = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                diff++;
            }else{
                diff--;
            }
            if(map.containsKey(diff)){
                maxLength = Math.max(i - map.get(diff), maxLength);
            }else{
                map.put(diff,i);
            }
        }
        return maxLength;
    }
        public static int findMaxLength2(int[] nums) {
            int subLength = -1;
            for (int i = 0; i < nums.length; i++) {
                int zeros = 0;
                int ones = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        zeros++;
                    } else {
                        ones++;
                    }
                    if (zeros == ones) {
                        subLength = Math.max(subLength, j - i + 1);
                    }
                }
            }
            return subLength;
        }
    }
