package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 1. 아이디어
 * A를 순회하면서 각 원소가 단어에 존재하면 !로 치환
 * A 순회를 마치고 난 후의 단어의 길이가 정답!
 * <p>
 * 2. 자료구조
 * 변경된 크로아티아 알파벳 저장 -> String 리스트 = A
 * <p>
 * 3. 시간복잡도
 */
public class P2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> croatiaAlphabets = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (int i = 0; i < croatiaAlphabets.size(); i++) {
            String croatiaAlphabet = croatiaAlphabets.get(i);

            if (word.contains(croatiaAlphabet)) {
                word = word.replace(croatiaAlphabet, "!");
            }
        }

        System.out.println(word.length());
    }
}
