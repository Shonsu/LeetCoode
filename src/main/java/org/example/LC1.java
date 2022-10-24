package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC1 {
    public static void main(String[] args) {

        int[] input = new int[]{2,5,11,15};
        int target = 16;
        int[] result = twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compl = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            int key = nums[i];
            if(compl.containsKey(key)){
                return new int[]{compl.get(key),i};
            }else{
                compl.put(target-key, i);
            }
        }
        return new int[]{};
    }
}
