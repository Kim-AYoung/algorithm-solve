package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CNUSWACADEMY_지그재그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr1Length = st.countTokens();
        int[] arr1 = new int[arr1Length];
        for (int i = 0; i < arr1Length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int arr2Length = st.countTokens();
        int[] arr2 = new int[arr2Length];
        for (int i = 0; i < arr2Length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(arr1Length, arr2Length);
        for (int i = 0; i < maxLength; i++) {
            if (i < arr1Length) {
                sb.append(arr1[i]).append(' ');
            }
            if (i < arr2Length) {
                sb.append(arr2[i]).append(' ');
            }
        }
    }
}
