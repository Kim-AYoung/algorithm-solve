package simulation;

import java.util.*;

/**
 * 1. 아이디어
 * - 문자열을 문자 배열로 변환한다.
 * - 각각의 문자를 돌면서 이진수로 변환한다.
 * - 이진수를 돌면서 series를 추출한다.
 * - 이때, series의 길이와 종류를 기록한다.
 * - 위를 바탕으로 인코딩한다.
 *
 * 2. 시간복잡도 : O(N)
 *
 * 3. 자료구조
 * 문자열이 변환된 이진수 저장 : ArrayList
 * */
class Unary {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        List<Integer> binaryChars = new ArrayList<>();
        String answer = "";

        char[] chars = MESSAGE.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int decimal = chars[i];
            List<Integer> binaryChar = toBinary(decimal);
            binaryChars.addAll(binaryChar);
        }

        int prevBinary = -1;
        int count = 0;
        for (int i = 0; i < binaryChars.size(); i++) {
            int binary = binaryChars.get(i);

            if(prevBinary != binary) {
                if(prevBinary != -1) {
                    if(prevBinary == 0) {
                        answer += "00";
                    }else {
                        answer += "0";
                    }
                    answer += " ";
                }
                for (int j = 0; j < count; j++) {
                    answer += "0";
                }
                if(count > 0) answer += " ";
                count = 1;
            }else {
                count++;
            }
            prevBinary = binary;
        }

        if(prevBinary == 0) {
            answer += "00";
        }else {
            answer += "0";
        }
        answer += " ";
        for (int j = 0; j < count; j++) {
            answer += "0";
        }

        System.out.println(answer);

        in.close();
    }

    private static List<Integer> toBinary(int decimal) {
        List<Integer> binaryChar = new LinkedList<>();
        while(decimal / 2 > 0) {
            binaryChar.add(0, decimal % 2);
            decimal /= 2;
        }
        binaryChar.add(0, decimal % 2);

        int zeroPaddingCount = 7 - binaryChar.size();
        for (int i = 0; i < zeroPaddingCount; i++) {
            binaryChar.add(0, 0);
        }

        return binaryChar;
    }
}

