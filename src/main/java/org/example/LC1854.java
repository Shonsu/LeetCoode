package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LC1854 {
    public static void main(String[] args) {
        int[][] logs = new int[][]{
                {1950, 1975},
                {1960, 1971},
                {1970, 1981},
                {1972, 1987},
                {1973, 1990},
        };
        int result = maximumPopulation(logs);
        System.out.println(result);
    }

    public static int maximumPopulation(int[][] logs) {
        int m = logs.length;
        int n = logs[0].length;
        int earliestYear = 2050;
        int maxPopulation = 0;
        for (int i = 1950; i <= 2050; i++) {
            int tmpPopulation = 0;
            for (int[] log : logs) {
                if (i >= log[0] && i < log[1]) {
                    tmpPopulation++;
                }
            }
            if (tmpPopulation > maxPopulation) {
                maxPopulation = tmpPopulation;
                earliestYear = i;
            }
        }
        return earliestYear;
    }

    public static int maximumPopulation2(int[][] logs) {
        int pop[] = new int[2051], res = 0;
        for (var l : logs) {
            ++pop[l[0]];
            --pop[l[1]];
        }
        for (int i = 1950; i < 2050; ++i) {
            pop[i] += pop[i - 1];
            System.out.println(i + " = " + pop[i]);
            res = pop[i] > pop[res] ? i : res;
        }
        return res;
    }

}
