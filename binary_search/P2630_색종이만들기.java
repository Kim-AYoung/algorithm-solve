package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630_색종이만들기 {
    private static int[][] paper;
    private static int whitePaperCount = 0;
    private static int blackPaperCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(0, 0, N);

        System.out.println(whitePaperCount);
        System.out.println(blackPaperCount);
    }

    private static void countPaper(int row, int col, int size) {

        if(checkSameColor(row, col, size)) {
           if(paper[row][col] == 0) {
               whitePaperCount++;
           }else {
               blackPaperCount++;
           }
           return;
        }

        int halfSize = size / 2;
        countPaper(row, col, halfSize);
        countPaper(row, col + halfSize, halfSize);
        countPaper(row + halfSize, col, halfSize);
        countPaper(row + halfSize, col + halfSize, halfSize);
    }

    private static boolean checkSameColor(int row, int col, int size) {

        int color = paper[row][col];
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
