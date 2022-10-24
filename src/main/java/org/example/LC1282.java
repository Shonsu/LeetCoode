package org.example;

//  https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1282 {
    public static void main(String[] args) {
        int[] groupSizes = new int[]{3, 3, 3, 3, 1, 3, 3};
        groupSizes = new int[]{2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3};
        List<List<Integer>> result = groupThePeople(groupSizes);

        System.out.println(result);

    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        int size = groupSizes.length;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> lastSeenEmpty = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int key = groupSizes[i];
            if (lastSeenEmpty.containsKey(key) ) {
                List<Integer> tmpList = lastSeenEmpty.get(key);
                tmpList.add(i);
                if (tmpList.size() == key) {
                    lastSeenEmpty.remove(key);
                }
            } else {

                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                result.add(tmpList);

                if(key!=1){
                    lastSeenEmpty.put(key, tmpList);
                }
            }
        }
        return result;
    }
}
