package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1206_View {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int numOfBuilding = Integer.parseInt(br.readLine());
            int[] heightArr = new int[numOfBuilding];
            int answer = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<numOfBuilding; i++) {
                int height = Integer.parseInt(st.nextToken());
                heightArr[i] = height;
            }
            for (int i = 2; i <numOfBuilding - 2; i++) {
                int prevPrevBuildingHeight = heightArr[i-2];
                int prevBuildingHeight = heightArr[i-1];
                int currentBuildHeight = heightArr[i];
                int nextBuildingHeight = heightArr[i+1];
                int nextNextBuildingHeight = heightArr[i+2];

                int maxBuildingHeight = Math.max(Math.max(prevPrevBuildingHeight, prevBuildingHeight), Math.max(nextBuildingHeight, nextNextBuildingHeight));
                int cntGoodHouseHold = currentBuildHeight - maxBuildingHeight;
                if(cntGoodHouseHold < 0) cntGoodHouseHold = 0;
                answer += cntGoodHouseHold;
            }
            System.out.println("#" + test_case + " " + answer );
        }

        br.close();
    }
}
