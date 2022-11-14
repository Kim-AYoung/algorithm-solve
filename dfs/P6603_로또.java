package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603_로또 {
    private static int k;
    private static int[] S;
    private static int[] isSelected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            S = new int[k];
            for(int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            isSelected = new int[k];

            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int start, int depth) {
        if(depth == 6) {
            printSelected();
        }
        for(int i = start; i < k; i++) {
            isSelected[i] = 1;
            dfs(i + 1, depth + 1);
            isSelected[i] = 0;
        }
    }

    private static void printSelected() {
        for(int i =0; i < k; i++) {
            if(isSelected[i] == 1) {
                System.out.print(S[i] + " ");
            }
        }
        System.out.println();
    }
}
