package data_structure.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() >= 2) {
            queue.poll();
            int num = queue.poll();
            queue.add(num);
        }
        System.out.println(queue.peek());
    }
}
