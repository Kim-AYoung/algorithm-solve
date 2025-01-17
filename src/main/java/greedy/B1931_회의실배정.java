package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1931
 */
public class B1931_회의실배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();
        int out = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        meetings.sort((m1, m2) -> {
            if (m1.e != m2.e) return Integer.compare(m1.e, m2.e);
            return Integer.compare(m1.s, m2.s); // 시작 시간과 끝 시간이 같은 회의를 고려하여 시작 시간을 기준으로 오름차순 정렬
        });

        int lastMeetingEnd = 0;
        for (int i = 0; i < N; i++) {
            Meeting meeting = meetings.get(i);
            if (lastMeetingEnd > meeting.s) continue;
            out++;
            lastMeetingEnd = meeting.e;
        }

        System.out.println(out);
    }

    static class Meeting {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
