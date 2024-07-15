package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2588 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int b_num = (int)(Math.log10(a)+1); // b의 자릿수 
		int i_max = (int)Math.pow(10, b_num-1);
		
		for(int i=1; i<=i_max; i*=10) {
			System.out.println( a * ((b/i)%10) );
		}
		
		System.out.println(a*b);

	}

}
