package programmers;

public class _2016년 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    private static String solution(int a, int b) {
        String answer = "";
        int[] daysPerMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int passDays = 0;

        for(int i=1; i<=(a-1); i++) {
            passDays += daysPerMonth[i-1];
        }
        passDays += b;

        switch(passDays % 7) {
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 0:
                answer = "THU";
        }

        return answer;
    }
}
