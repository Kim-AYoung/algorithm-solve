package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 문제 : https://www.acmicpc.net/problem/1874
 * 시간복잡도 = O(n)
 */
public class B1874_스택수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sequence = 1;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (sequence < target) {
                stack.add(sequence);
                output.append("+")
                        .append("\n");
                sequence++;
            }
            if (sequence == target) {
                stack.add(sequence);
                output.append("+")
                        .append("\n");

                stack.removeLast();
                output.append("-")
                        .append("\n");
                sequence++;
            } else {
                int removedNumber = stack.removeLast();
                output.append("-")
                        .append("\n");

                if (removedNumber != target) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(output);
    }
}
