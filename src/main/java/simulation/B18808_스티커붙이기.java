package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 문제 : https://www.acmicpc.net/problem/18808
 */
public class B18808_스티커붙이기 {
    static int n;
    static int m;
    static boolean[][] notebook;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        notebook = new boolean[n][m];
        k = parseInt(st.nextToken());

        for (int ik = 0; ik < k; ik++) {
            st = new StringTokenizer(br.readLine());
            int r = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            boolean[][] sticker = new boolean[r][c];
            int upperLeftY = 0;
            int upperLeftX = 0;
            int rotateCnt = 0;

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = parseInt(st.nextToken()) == 1;
                }
            }

            boolean finishRotate = false;
            while (r > n || c > m) {
                if (rotateCnt == 3) {
                    finishRotate = true;
                    break;
                }

                sticker = rotate(sticker, r, c);
                int temp = r;
                r = c;
                c = temp;
                rotateCnt++;
            }
            if (finishRotate) continue;

            while (!isStick(sticker, upperLeftY, upperLeftX, r, c)) {
                if (upperLeftX == m - c) {
                    if (upperLeftY == n - r) {
                        do {
                            if (rotateCnt == 3) {
                                finishRotate = true;
                                break;
                            }

                            sticker = rotate(sticker, r, c);
                            int temp = r;
                            r = c;
                            c = temp;
                            rotateCnt++;
                        } while (r > n || c > m);
                        if (finishRotate) break;

                        upperLeftX = 0;
                        upperLeftY = 0;
                    } else {
                        upperLeftX = 0;
                        ++upperLeftY;
                    }
                } else {
                    ++upperLeftX;
                }
            }
        }

        int out = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (notebook[i][j]) out++;
            }
        }
        System.out.println(out);
    }

    private static boolean[][] rotate(boolean[][] sticker, int r, int c) {
        boolean[][] temp = new boolean[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                temp[i][j] = sticker[r - j - 1][i];
            }
        }
        return temp;
    }


    private static boolean isStick(boolean[][] sticker, int upperLeftY, int upperLeftX, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (notebook[upperLeftY + i][upperLeftX + j] && sticker[i][j]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j]) notebook[upperLeftY + i][upperLeftX + j] = true;
            }
        }
        return true;
    }
}
