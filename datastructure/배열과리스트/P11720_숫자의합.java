package datastructure.배열과리스트;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}
