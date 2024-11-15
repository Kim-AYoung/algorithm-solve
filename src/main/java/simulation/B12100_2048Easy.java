package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/12100
 * 별해 : 블럭을 이동시키는 방향에 따라 조건문을 구현하는 것이 아니라, 배열을 회전한다면 한 방향에 대해서만 블럭을 이동시키는 코드만 구현할 수 있다.
 */
public class B12100_2048Easy {
    static int n;
    static int out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(0, board);
        System.out.println(out);
    }

    private static void move(int cnt, int[][] board) {
        if (cnt == 5) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }

            out = Math.max(out, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] afterBoard = new int[n][n];

            for (int j = 0; j < n; j++) {
                Queue<Integer> blocks = new ArrayDeque<>();
                int index = 0;

                if (i == 0) {
                    for (int k = 0; k < n; k++) {
                        if (board[k][j] != 0) blocks.add(board[k][j]);
                    }
                } else if (i == 1) {
                    for (int k = n - 1; k >= 0; k--) {
                        if (board[j][k] != 0) blocks.add(board[j][k]);
                    }
                } else if (i == 2) {
                    for (int k = n - 1; k >= 0; k--) {
                        if (board[k][j] != 0) blocks.add(board[k][j]);
                    }
                } else if (i == 3) {
                    for (int k = 0; k < n; k++) {
                        if (board[j][k] != 0) blocks.add(board[j][k]);
                    }
                }

                while (!blocks.isEmpty()) {
                    int first = blocks.poll();
                    Integer second = blocks.peek();

                    if (Objects.isNull(second)) {
                        if (i == 0) {
                            afterBoard[index][j] = first;
                        } else if (i == 1) {
                            afterBoard[j][n - 1 - index] = first;
                        } else if (i == 2) {
                            afterBoard[n - 1 - index][j] = first;
                        } else if (i == 3) {
                            afterBoard[j][index] = first;
                        }
                        continue;
                    }

                    if (first == second.intValue()) {
                        if (i == 0) {
                            afterBoard[index][j] = 2 * first;
                        } else if (i == 1) {
                            afterBoard[j][n - 1 - index] = 2 * first;
                        } else if (i == 2) {
                            afterBoard[n - 1 - index][j] = 2 * first;
                        } else if (i == 3) {
                            afterBoard[j][index] = 2 * first;
                        }

                        blocks.poll();
                    } else {
                        if (i == 0) {
                            afterBoard[index][j] = first;
                        } else if (i == 1) {
                            afterBoard[j][n - 1 - index] = first;
                        } else if (i == 2) {
                            afterBoard[n - 1 - index][j] = first;
                        } else if (i == 3) {
                            afterBoard[j][index] = first;
                        }
                    }
                    index++;
                }
            }

            move(cnt + 1, afterBoard);
        }
    }
}
