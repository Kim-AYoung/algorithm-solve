package io_operation;

import java.io.*;
import java.util.*;

public class Buffered_Reader_Writer_Example {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		
		/* n번 입력 받음 */	
		int n = Integer.parseInt(br.readLine());						

		//a b c (한 줄)
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bw.write(a + " " + b + " " +  c + "\n"); // 성능은 String의 +연산자 보다 StringBuilder가 좋음
		}

		//? (한 줄)
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] intArr = new int[st.countTokens()]; 				//한 줄에 입력받는 수
			for(int j=0; j<intArr.length; j++) {
				intArr[j] = Integer.parseInt(st.nextToken());
			}
		}
	
		/* ?번 입력받음 */
		String str; 
		while(( str = br.readLine() ) != null) {
			if(str.equals("")) { 
				continue;
			}
			
			//a b c (한 줄)
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bw.write(a + b + c + "\n");
			
			// ? (한 줄)
			st = new StringTokenizer(str);
			int[] intArr = new int[st.countTokens()];
			for(int j=0; j<intArr.length; j++) {
				intArr[j] = Integer.parseInt(st.nextToken());
			}
			
		}

		/* 2차원 array */
		//input :
		//column row
		//2차원 배열
		st = new StringTokenizer(br.readLine());
		int column = Integer.parseInt(st.nextToken()); 					
		int row = Integer.parseInt(st.nextToken());			
		
		int[][] intArr = new int[row][column];
		
		for(int i = 0; i < row; i++) {						//2李⑥썝 諛곗뿴�뿉 �엯�젰媛� ���엯
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < column; j++) {
				intArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//n踰덉쓽 臾몄옣�씠 �삩�떎
		String[] strArr = new String[n];
		for(int i=0; i<n; i++) {
			strArr[i] = br.readLine();
		}
		
		/* 1차원 array */
		//input:
		//a
		int[] intArr2 = new int[n];
		for(int i=0; i<n; i++) {
			intArr2[i] = Integer.parseInt(br.readLine());
		}
		 		 
		 
		br.close();
		bw.close();
	}

}
