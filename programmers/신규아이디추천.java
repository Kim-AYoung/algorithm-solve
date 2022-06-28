package programmers;

public class 신규아이디추천 {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }

    private static String solution(String new_id) {
        String answer = "";
        // 1단계
        answer = new_id.toLowerCase();
        // 2단계
        answer = answer.replaceAll("[^a-z\\d-_.]", "");
        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5단계
        if(answer.equals("")) answer="a";
        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        // 7단계
        if(answer.length() <= 2) {
            String lastStr = answer.substring(answer.length()-1, answer.length());
            int numPlus = 3-answer.length();
            for(int i=0; i<numPlus; i++) {
                answer += lastStr;
            }
        }

        return answer;
    }
}
