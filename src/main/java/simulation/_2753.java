package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2753 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		
		int year = Integer.parseInt(br.readLine());
		
		if( (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) ) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
