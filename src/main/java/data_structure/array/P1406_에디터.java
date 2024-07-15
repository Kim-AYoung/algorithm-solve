package data_structure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class P1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String statement = br.readLine();
        LinkedList<Character> editor = new LinkedList<>();
        statement.chars().forEach(v -> editor.add((char) v));
        int M = Integer.parseInt(br.readLine());

        ListIterator<Character> iterator = editor.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case "D":
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case "P":
                    char character = st.nextToken().charAt(0);
                    iterator.add(character);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder("");
        editor.forEach(sb::append);
        System.out.println(sb);

        br.close();
    }
}
