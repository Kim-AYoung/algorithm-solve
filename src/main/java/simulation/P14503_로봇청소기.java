package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 아이디어
 * - while문으로, 특정 조건 만족하는 한 계속 이동
 * - 4방향을 for문으로 탐색 : 빈칸 있을 경우 이동
 * - 4방향 모두 벽이나 청소 완료일 경우 : 한칸 후진, 후진도 벽이면 종료
 *
 * 시간복잡도
 * - O(N * M * 4) = O(NM) = 2500 < 2억
 *
 * 자료구조
 * - map : int[N][M], 0(청소전), 1(벽), 2(청소 완료)
 * - 로봇 청소기의 현재 위치, 방향
 * - 청소한 칸의 개수
 */
public class P14503_로봇청소기 {
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M]; // 0(청소전), 1(벽), 2(청소 완료)
        int countClean = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if(map[r][c] == 0) {
                map[r][c] = 2;
                countClean++;
            }

            boolean findNotClean = false;
            for (int i = 1; i <= 4; i++) {
                int ny = r + dy[getIndexOfCircularArray(direction - i, dy.length)];
                int nx = c + dx[getIndexOfCircularArray(direction - i, dx.length)];
                if((ny >= 0 && ny < N) && (nx >= 0 && nx < M)) {
                    if (map[ny][nx] == 0) {
                        direction = getIndexOfCircularArray(direction - i, dy.length);
                        r = ny;
                        c = nx;
                        findNotClean = true;
                        break;
                    }
                }
            }

            if(!findNotClean) {
                int ny = r + dy[getIndexOfCircularArray(direction - 2, dy.length)];
                int nx = c + dx[getIndexOfCircularArray(direction - 2, dx.length)];
                if((ny >= 0 && ny < N) && (nx >= 0 && nx < M)) {
                    if(map[ny][nx] == 1) {
                        break;
                    }else {
                        r = ny;
                        c = nx;
                    }
                }else {
                    break;
                }
            }
        }

        System.out.println(countClean);
    }

    private static int getIndexOfCircularArray(int index, int arrayLength) {
        return  (arrayLength + index) % arrayLength;
    }
}
