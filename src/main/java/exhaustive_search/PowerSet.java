package exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerSet {
    static int n;
    static int[] numArr;
    static boolean[] selected;
    static int subsetCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        selected = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0);
        System.out.println("subset count : " + subsetCount);
    }

    private static void powerSet(int index) {
        if (index == n) {
            subsetCount++;
            printSubset();
            return;
        }

        selected[index] = true;
        powerSet(index + 1);

        selected[index] = false;
        powerSet(index + 1);
    }

    private static void printSubset() {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                System.out.print(numArr[i] + ", ");
            }
        }
        System.out.println("}");
    }
}
