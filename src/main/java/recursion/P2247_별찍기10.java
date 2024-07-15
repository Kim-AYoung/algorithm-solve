package recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P2247_별찍기10 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] answer = new String[N][N];;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = " ";
            }
        }

        pattern(answer, 0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(answer[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void pattern(String[][] answer, int x, int y, int N) {
        if (N == 1) {
            answer[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) pattern(answer, x + i * (N / 3), y + j * (N / 3), N / 3);
            }
        }
    }
}
