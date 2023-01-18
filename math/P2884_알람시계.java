package math;

import java.util.Scanner;

public class P2884_알람시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int totalMinute = hour * 60 + minute;

        int afterTotalMinute = totalMinute - 45;
        if (afterTotalMinute < 0) afterTotalMinute = 60 * 24 + afterTotalMinute;

        int afterHour = afterTotalMinute / 60;
        int afterMinute = afterTotalMinute % 60;
        System.out.println(afterHour + " " + afterMinute);
    }
}
