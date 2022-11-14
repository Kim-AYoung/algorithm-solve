package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class P10867_중복빼고정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(sc.nextInt());
        }

        ArrayList<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
