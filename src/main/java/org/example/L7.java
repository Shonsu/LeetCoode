package org.example;

public class L7 {
    public static int reverse(int x) {

        int number = Math.abs(x);
        int reversed = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            if (reversed > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reversed = (reversed * 10) + lastDigit;
            number = number / 10;
        }

        return ((x < 0) ? -reversed : reversed);
    }

    public static void main(String[] args) {
        int x = -153423699;
        System.out.println(reverse(x));
    }
}
