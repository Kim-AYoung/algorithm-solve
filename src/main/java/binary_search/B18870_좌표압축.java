package binary_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/18870
 * 시긴복잡도 = O(NlogN)
 */
public class B18870_좌표압축 {
    static int N;
    static int[] arr;
    static int[] sortedArr;
    static ArrayList<Integer> dependentSortedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortedArr = new int[N];
        dependentSortedList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 정렬
        Arrays.sort(sortedArr);

        // 중복 제거
        for (int i = 0; i < N; i++) {
            if (i != N - 1 && sortedArr[i] == sortedArr[i + 1]) {
                continue;
            }
            dependentSortedList.add(sortedArr[i]);
        }

        int[] dependentSortedArr = new int[dependentSortedList.size()];
        for (int i = 0; i < dependentSortedList.size(); i++) {
            dependentSortedArr[i] = dependentSortedList.get(i);
        }

        // 이분 탐색후 인덱스 출력
        for (int num : arr) {
            int compressed = Arrays.binarySearch(dependentSortedArr, num);
            bw.write(compressed + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
