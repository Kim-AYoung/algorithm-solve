package programmers;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }

    private static boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        int pNum = 0;
        int yNum = 0;

        for(char c : chars) {
            if(c == 'P') {
                pNum++;
            }else if(c == 'Y') {
                yNum++;
            }
        }

        answer = pNum == yNum;

        return answer;
    }
}
