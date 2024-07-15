package programmers;

import java.util.Scanner;

public class 정사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 세로
        int b = sc.nextInt(); // 가로

        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
