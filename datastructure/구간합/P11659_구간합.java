package datastructure.구간합;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_구간합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int answerNum = Integer.parseInt(stringTokenizer.nextToken());

        // 구간 합 배열 구하기
        long accumulatedSum[] = new long[n];
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            accumulatedSum[i] =
                    i==0 ?
                    num :
                    accumulatedSum[i-1] + num;
        }
        
        // 구간 합 구하기
        for(int i=0; i<answerNum; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken())-1;
            int end = Integer.parseInt(stringTokenizer.nextToken())-1;
            long intervalSum =
                    start==0 ?
                    accumulatedSum[end] :
                    accumulatedSum[end]-accumulatedSum[start-1];
            sb.append(intervalSum).append("\n");
        }
        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
}
