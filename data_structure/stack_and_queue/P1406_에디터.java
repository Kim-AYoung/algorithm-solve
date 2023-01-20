package data_structure.stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        String statement = br.readLine();
        statement.chars().forEach(v -> leftStack.add((char) v));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case "P":
                    char character = st.nextToken().charAt(0);
                    leftStack.push(character);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder("");
        leftStack.forEach(sb::append);
        Collections.reverse(rightStack);
        rightStack.forEach(sb::append);
        System.out.println(sb);

        br.close();
    }
}
