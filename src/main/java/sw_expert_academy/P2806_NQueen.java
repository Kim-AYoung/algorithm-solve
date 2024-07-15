package sw_expert_academy;

import java.util.Scanner;

public class P2806_NQueen {
    static boolean[][] board;
    static int N;
    static int result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            board = new boolean[N][N];
            int[] isQueen = new int[N];
            for (int i = 0; i < N; i++) {
                isQueen[i] = -1;
            }

            dfs(0, isQueen);

            System.out.println("#" + test_case + " " + result);
            result = 0;
        }
    }

    private static void dfs(int rowIdx, int[] isQueen) {

        if(rowIdx == N) {
            result++;
        }

        for (int i = 0; i < N; i++) {
            // 대각선 혹은 같은 열에 퀸 존재
            boolean isQueenInDiagonal = false;
            for (int j = 1; j <= rowIdx; j++) {
                if((isQueen[rowIdx-j] == i-j) || (isQueen[rowIdx-j] == i+j) || isQueen[rowIdx-j] == i) {
                    isQueenInDiagonal = true;
                    break;
                }
            }
            if(isQueenInDiagonal) continue;

            board[rowIdx][i] = true;
            isQueen[rowIdx] = i;
            dfs(rowIdx + 1, isQueen);
            board[rowIdx][i] = false;
            isQueen[rowIdx] = -1;
        }
    }
}
