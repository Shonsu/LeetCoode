package org.example.codewars;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.codewars.com/kata/count-ip-addresses/
public class CountIPAddresses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstIP;
        String secondIP;
        int fIP[] = new int[4];
        int sIP[] = new int[4];

        System.out.println("Input first IP address");
        firstIP = String.valueOf(s.nextLine());

        System.out.println("Input second IP address");
        secondIP = String.valueOf(s.nextLine());


        Pattern pattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
        Matcher matcherFirst = pattern.matcher(firstIP);

        matcherFirst.matches();

        for (int i = 0; i < fIP.length; i++) {
            fIP[i] = Integer.parseInt(matcherFirst.group(i + 1));
        }

        Matcher matcherSecond = pattern.matcher(secondIP);
        matcherSecond.matches();
        //System.out.println(matcher.group(0));

        for (int i = 0; i < fIP.length; i++) {
            sIP[i] = Integer.parseInt(matcherSecond.group(i + 1));
        }
        System.out.println(Arrays.toString(fIP));
        System.out.println(Arrays.toString(sIP));

        double result = 0;
        int i = 0;
        for (; i < 4; i++) {
            result += (sIP[i] - fIP[i]) * Math.pow(256,3-i);
        }

        System.out.printf("%.0f",result);

    }
}
