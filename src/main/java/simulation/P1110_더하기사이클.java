package simulation;

import java.util.Scanner;

/**
 * 1. 아이디어
 * - while(새로운 수 != N) {
 * -    새로운 수 = 새로운 수의 가장 오른쪽 자리 수, 새로운 수의 각 자리의 숫자를 더하고난 후의 가장 오른쪽 자리 수를 이어붙인다.
 * -    사이클의 길이를 1 증가한다.
 * - }
 * - 사이클의 길이를 출력한다.
 * <p>
 * 2. 자료구조
 * <p>
 * 3. 시간복잡도
 */
public class P1110_더하기사이클 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int newNumber = N;
        int cycleLength = 0;

        do {
            newNumber = (newNumber % 10) * 10 + ((newNumber < 10 ? 0 : newNumber / 10) + (newNumber % 10)) % 10;
            cycleLength++;
        } while(newNumber != N);

        System.out.println(cycleLength);
    }
}
