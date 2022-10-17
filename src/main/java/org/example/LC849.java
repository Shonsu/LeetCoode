package org.example;

public class LC849 {
    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 0, 1, 0, 0, 1};
        System.out.println(maxDistToClosest(input));
    }

    public static int maxDistToClosest(int[] seats) {

        int firstZeros = -1;
        int lastZeros;
        int maxDist = 0;
        int zeros = 0;
        for (int seat : seats) {
            if (seat == 0) {
                zeros++;
            } else {
                if (firstZeros == -1) {
                    firstZeros = zeros;
                } else {
                    maxDist = Math.max(zeros, maxDist);
                }
                zeros = 0;
            }
        }
        lastZeros = zeros;

        return Math.max(Math.max(firstZeros, lastZeros), (maxDist + 1) / 2);
    }
}
