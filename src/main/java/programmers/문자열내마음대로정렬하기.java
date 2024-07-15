package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        String[] strings = new String[]{"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    private static String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                if(s1.charAt(n) > s2.charAt(n)) {
                    return 1;
                }else if(s1.charAt(n) < s2.charAt(n)) {
                    return -1;
                }else {
                    return s1.compareTo(s2);
                }
            }
        });
        answer = strings;
        return answer;
    }
}

