package sw_expert_academy;

import java.util.Scanner;

public class P1215_회문1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        final int LETTER_BOARD_SIZE = 8;

        for (int test_case = 1; test_case <= T; test_case++) {
            int palindromeLength = Integer.parseInt(sc.nextLine());
            char[][] palinddromeBoard = new char[LETTER_BOARD_SIZE][LETTER_BOARD_SIZE];
            int palindromeCount = 0;

            // palinddrome board 생성
            for (int i = 0; i < LETTER_BOARD_SIZE; i++) {
                char[] letters = sc.nextLine().toCharArray();
                for (int j = 0; j < LETTER_BOARD_SIZE; j++) {
                    palinddromeBoard[i][j] = letters[j];
                }
            }

            // 행 방향의 회문 찾기
            for (int i = 0; i < LETTER_BOARD_SIZE; i++) {
                int startIndex = 0;
                while (startIndex <= LETTER_BOARD_SIZE - palindromeLength) {
                    boolean isPalindrome = true;
                    for (int j = 0; j < palindromeLength / 2; j++) {
                        if (palinddromeBoard[i][startIndex+j] != palinddromeBoard[i][startIndex + palindromeLength - 1 - j]) {
                            isPalindrome = false;
                        }
                    }
                    if (isPalindrome) {
                        palindromeCount++;
                    }
                    startIndex++;
                }
            }

            // 열 방향의 회문 찾기
            for (int i = 0; i < LETTER_BOARD_SIZE; i++) {
                int startIndex = 0;
                while (startIndex <= LETTER_BOARD_SIZE - palindromeLength) {
                    boolean isPalindrome = true;
                    for (int j = 0; j < palindromeLength / 2; j++) {
                        if (palinddromeBoard[startIndex+j][i] != palinddromeBoard[startIndex + palindromeLength - 1 - j][i]) {
                            isPalindrome = false;
                        }
                    }
                    if (isPalindrome) {
                        palindromeCount++;
                    }
                    startIndex++;
                }
            }

            System.out.println("#" + test_case + " " + palindromeCount);
        }
    }
}
