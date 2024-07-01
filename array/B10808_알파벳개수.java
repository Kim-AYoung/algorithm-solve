package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간복잡도 = O(n)
 */
public class B10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        int[] alphabetCount = new int[26];
        char[] inputWord;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputWord = br.readLine().toCharArray();

        for (char alphabet : inputWord) {
            alphabetCount[alphabet - 'a']++;
        }

        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
    }
}
