package heap;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while(priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1)
                return -1;
            priorityQueue.add(priorityQueue.poll() + priorityQueue.poll() * 2);
            answer++;
        }
        return answer;
    }
}
