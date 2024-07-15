package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class P10451_순열사이클 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        while (T > 0) {
            T--;

            int N = Integer.parseInt(br.readLine()); // 순열의 크기
            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] isVisited = new boolean[N + 1];
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(arr, isVisited, i);
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int[] arr, boolean[] isVisited, int idx) {

        int nextIdx = arr[idx];
        if (!isVisited[nextIdx]) {
            isVisited[nextIdx] = true;
            dfs(arr, isVisited, nextIdx);
        }
    }
}

