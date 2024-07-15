package sliding_window;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<Node> myDeque = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            // add
            while(!myDeque.isEmpty() && myDeque.getLast().value > num) {
                myDeque.removeLast();
            }
            myDeque.offerLast(new Node(num, i));
            // remove
            if(myDeque.getFirst().index <= i-L) {
                myDeque.removeFirst();
            }
            sb.append(myDeque.getFirst().value).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
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