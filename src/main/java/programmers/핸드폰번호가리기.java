package programmers;

public class 핸드폰번호가리기 {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }

    private static String solution(String phone_number) {
        String answer = "";
        int phone_number_length = phone_number.length();
        int numOfStar = phone_number_length - 4;

        for(int i=0; i<numOfStar; i++) {
            answer += "*";
        }
        answer += phone_number.substring(phone_number_length-4, phone_number_length);

        return answer;
    }
}
