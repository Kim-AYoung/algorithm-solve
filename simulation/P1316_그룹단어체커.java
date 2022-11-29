package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. 아이디어
 * 각 단어에서 문자를 차례대로 순회한다.
 * 해당 문자가 집합에 존재하는지 확인한다.
 * * 존재하지 않으면 문자를 집합에 넣는다.
 * * 존재하면서 이전 문자와 같다면 다음 문자로 넘어간다.
 * * 존재하면서 이전 문자와 다르다면 그룹 단어가 아니다.
 * <p>
 * 2. 자료구조
 * 문자를 넣어둘 집합
 * <p>
 * 3. 시간복잡도
 * 100 * N
 */
public class P1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countWord = Integer.parseInt(br.readLine());
        int answer = 0;

        while (countWord-- > 0) {
            char[] chars = br.readLine().toCharArray();

            Set<Character> charSet = new HashSet<>();
            char prevChar = ' ';
            boolean isGroupWord = true;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (!charSet.contains(c)) {
                    charSet.add(c);
                } else {
                    if (c != prevChar) {
                        isGroupWord = false;
                        break;
                    }
                }
                prevChar = c;
            }

            if (isGroupWord) answer++;
        }
        System.out.println(answer);
    }
}
