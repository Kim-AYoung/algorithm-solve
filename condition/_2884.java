package condition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2884 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] intArr = new int[2];
		for(int j=0; j<2; j++) {
			intArr[j] = Integer.parseInt(st.nextToken());
		}
		
		if( (intArr[1] -= 45) < 0 ) {
			
			intArr[1] = 60 + intArr[1];
			
			--intArr[0];
			if(intArr[0] == -1) {
				intArr[0] = 23;
			}
		}
		
		System.out.println(intArr[0] + " " + intArr[1]);

	}

}
