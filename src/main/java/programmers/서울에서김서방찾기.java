package programmers;

public class 서울에서김서방찾기 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    private static String solution(String[] seoul) {
        String answer = "";
        for(int i=0; i<seoul.length; i++) {
            if("Kim".equals(seoul[i])) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }
}
