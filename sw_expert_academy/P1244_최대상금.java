package sw_expert_academy;

import java.util.Arrays;
import java.util.Scanner;

public class P1244_최대상금 {

    private static int maxPrice;
    private static int[] numbers;
    private static String str = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            maxPrice = 0;
            int numberPlate = sc.nextInt();
            int maxChangingTime = sc.nextInt();

            // 입력받은 숫자판을 숫자배열로 변경
            char[] charNumbers = Integer.toString(numberPlate).toCharArray();
            numbers = new int[charNumbers.length];
            for (int i = 0; i < charNumbers.length; i++) {
                numbers[i] = charNumbers[i] - '0';
            }

            if(numbers.length < maxChangingTime) maxChangingTime = numbers.length;
            dfs(maxChangingTime, 0);

            System.out.println("#" + test_case + " " + maxPrice);
        }
    }

    private static void dfs(int maxChangingTime, int start) {

        if(maxChangingTime == 0) {
            // 숫자 배열을 하나의 숫자로 변경
            str = "";
            Arrays.stream(numbers).forEach(v -> str += String.valueOf(v));
            int price = Integer.parseInt(str);
            if(price > maxPrice) maxPrice = price;
            return;
        }

        for(int i=start; i<numbers.length-1; i++) {
            for(int j=i+1; j< numbers.length; j++) {
                    // i번째와 j번째 숫자 교환
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;

                    dfs(maxChangingTime-1, i);

                    // 교환한 두 숫자를 다시 되돌리기
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
            }
        }
    }
}
