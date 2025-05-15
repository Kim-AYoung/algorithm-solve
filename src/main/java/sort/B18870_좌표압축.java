package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/18870
 * 시긴복잡도 = O(NlogN)
 */
public class B18870_좌표압축 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer, Integer> lowerNumCntMap = new HashMap<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            sortedArr[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);
        
        int lowerNumCnt = 0;
        for(int coordinate : sortedArr) {
            if(!lowerNumCntMap.containsKey(coordinate)) {
                lowerNumCntMap.put(coordinate, lowerNumCnt);
                lowerNumCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int coordinate : arr) {
            sb.append(lowerNumCntMap.get(coordinate)).append(' ');
        }
        System.out.println(sb);
    }
}
