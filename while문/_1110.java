package _while;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1110 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		
		int N = Integer.parseInt(br.readLine());
		int lenOfCycle = 0;
		int num = N; 
		
		do{
			lenOfCycle++;
			
			int a = num / 10;
			int b = num % 10;
			
			num = b*10 + ((a+b)%10);
			
		}while(num != N);
		
		bw.write(lenOfCycle + "\n");
		bw.flush();
			
	}

}
