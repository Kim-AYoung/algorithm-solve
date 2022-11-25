package simulation;

/**
 * 1. 아이디어
 * - n을 1부터 10000까지 순회한다.
 * - 1. n의 생성자 유무를 확인한다.
 * - 1-1. 생성자 유무가 false이면, 해당 n을 출력한다.
 * - 2. d(n) = n + n의 각 자리 수를 구한다음, 배열의 d(n) 인덱스의 값을 true로 변경한다.
 *
 * 2. 자료구조
 * n의 생성자 유무를 저장할 배열 -> 9999 + 9 + 9 + 9 + 9 < 10040 크기의 배열
 *
 * 3. 시간복잡도
 * */
public class P4673_셀프넘버 {
    public static void main(String[] args) {
        boolean[] isExistGenerator = new boolean[10040];

        for (int i = 1; i <= 10000; i++) {
            if(!isExistGenerator[i]) {
                System.out.println(i);
            }

            int dn = i + sumOfEachDigit(i);

            isExistGenerator[dn] = true;
        }
    }

    private static int sumOfEachDigit(int number) {
        int sum = 0;

        char[] digits = String.valueOf(number).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            sum += digit;
        }

        return sum;
    }
}
