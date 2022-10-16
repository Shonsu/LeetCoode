package org.example;

import java.util.Arrays;

public class LC1337 {
    public static void main(String[] args) {

        int[][] mat = new int[][]{
                {1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1}
        };
//         mat = new int[][]{
//                {1, 0},
//                {1, 0},
//                {1, 0},
//                {1, 1}
//        };
        int k = 3;
        //Arrays.stream(mat).forEach(p-> System.out.println(Arrays.toString(p)));

        int[] tmp = kWeakestRows(mat, k);
        System.out.println(Arrays.toString(tmp));

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] tmp = new int[m][2];
        for (int i = 0; i < m; i++) {
            int idx = findLast1(mat[i]);
            tmp[i][0] = idx;
            tmp[i][1] = i;
        }

        int[][] sorted = sort(tmp, 0, tmp.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sorted[i][1];
        }
        return result;
    }

    private static int findLast1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == arr.length - 1 || arr[mid + 1] < 1 && 1 == arr[mid]) {
                return mid;
            }
            if (1 > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int[][] sort(int[][] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
        return A;
    }

    private static void merge(int[][] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[][] L = new int[n1][A[0].length];
        int[][] R = new int[n2][A[0].length];
        int i = 0;
        int j = 0;

        for (; i < n1; i++) {
            for (int k = 0; k < A[i].length; k++) {
                L[i][k] = A[p + i][k];
            }
        }
        for (; j < n2; j++) {
            for (int k = 0; k < A[i].length; k++) {
                R[j][k] = A[q + j + 1][k];
            }
        }

        i = 0;
        j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
                A[k] = L[i];
                k++;
                i++;

            } else {
                A[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < n1) {
            A[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            A[k] = R[j];
            k++;
            j++;
        }
    }
}