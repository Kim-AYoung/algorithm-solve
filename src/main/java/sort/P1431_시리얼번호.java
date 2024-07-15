package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class P1431_시리얼번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        arr.stream()
                .sorted(comparator)
                .forEach(v -> sb.append(v + "\n"));

        System.out.println(sb.toString());
    }

    private static Comparator<String> comparator = (s1, s2) -> {

        // A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
        if(s1.length() != s2.length()) {
            return s1.length() < s2.length() ? -1 : 1;
        }

        // 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
        if(s1.length() == s2.length()) {
            int sum1 = 0, sum2 = 0;

            for (char ch : s1.toCharArray()) {
                if(ch >= 'A') continue;
                sum1 += ch -'0';
            }
            for (char ch : s2.toCharArray()) {
                if(ch >= 'A') continue;
                sum2 += ch -'0';
            }

            if(sum1 < sum2) return -1;
            if(sum1 > sum2) return 1;
        }

        // 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) < s2.charAt(i)) return -1;
            if(s1.charAt(i) > s2.charAt(i)) return 1;
        }

        return 0;
    };
}
