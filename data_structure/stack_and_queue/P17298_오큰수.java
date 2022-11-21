package data_structure.stack_and_queue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        Stack<Integer> myIndexStack = new Stack<>();
        int[] NGE = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        myIndexStack.push(0);
        for(int i=1; i<N; i++) {
            while(!myIndexStack.isEmpty() && A[myIndexStack.peek()] < A[i]) {
                NGE[myIndexStack.peek()] = A[i];
                myIndexStack.pop();
            }
            myIndexStack.push(i);
        }

        for(int i=0; i<N; i++) {
            // 오큰수가 없는 경우
            if(NGE[i] == 0) NGE[i] = -1;
            // 오큰수 출력
            bw.write(NGE[i] + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
