package datastructure.슬라이딩윈도우;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            // add
            while(!myDeque.isEmpty() && myDeque.getLast().value > num) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(num, i));
            // remove
            if(myDeque.getFirst().index <= i-L) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}