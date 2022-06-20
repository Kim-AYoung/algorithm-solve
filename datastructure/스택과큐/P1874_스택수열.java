package datastructure.스택과큐;

import java.io.*;
import java.util.Stack;

public class P1874_스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] inputSequence = new int[n];
        Stack<Integer> myStack = new Stack<>();
        int currentNum = 0;
        int inputSequenceIdx = 0;

        for(int i=0; i<n; i++) {
            inputSequence[i] = Integer.parseInt(br.readLine());
        }

        while(currentNum <= n) {
            currentNum++;
            myStack.push(currentNum);
            sb.append("+").append("\n");

            while(!myStack.isEmpty()) {
                int checkNum = myStack.peek();
                if(checkNum == inputSequence[inputSequenceIdx]) {
                    myStack.pop();
                    sb.append("-").append("\n");
                    inputSequenceIdx++;
                    if(inputSequenceIdx == n) {
                        bw.write(sb.toString());
                        bw.flush();
                        bw.close();
                        return;
                    }
                }else {
                    break;
                }
            }
        }
        bw.write("NO");

        bw.flush();
        bw.close();
    }
}
