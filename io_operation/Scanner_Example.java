package io_operation;

import java.util.Scanner;

public class Scanner_Example {
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//n踰�
		//a b h  
		int n = sc.nextInt();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for(int i=0; i<n; i++) {
			String[] strArr = sc.nextLine().split(" ");
			
			//1踰�
			int a = Integer.parseInt(strArr[0]); 
			int b = Integer.parseInt(strArr[1]);
			int h = Integer.parseInt(strArr[2]);
			
			//2踰�
			int[] temp = new int[3];
			for(int j=0; j<3; j++) {
				temp[j] = Integer.parseInt(strArr[j]); 
			}
			
		}
		
		//臾댄븳 踰�
		//a b h
		while(sc.hasNextLine()) { 
			String str = sc.nextLine();
			if(str.equals(" ")) { //鍮� 臾몄옄�뿴�� �옒 泥섎━�븯�옄!
				continue;
			}
		  	String[] strArr2 = str.split(" "); 
		  	
		  	//1踰�
		  	int a = Integer.parseInt(strArr2[0]); 
			int b = Integer.parseInt(strArr2[1]);
			int h = Integer.parseInt(strArr2[2]);
			
			//2踰�
			int[] temp = new int[3];
			for(int j=0; j<3; j++) {
				temp[j] = Integer.parseInt(strArr2[j]); 
			}
		 }
		
		//column row
		//2移섏썝 array
		int column = sc.nextInt(); 		//�뿴 			
		int row = sc.nextInt();			//�뻾
		
		int[][] intArr = new int[row][column];
		
		for(int i = 0; i < row; i++) {						//2李⑥썝 諛곗뿴�뿉 �엯�젰媛� ���엯
			for(int j = 0; j < column; j++) {
				intArr[i][j] = sc.nextInt();
			}
		}
		
		//n踰덉쓽 臾몄옣�씠 �삩�떎
		String[] strArr = new String[n];
		for(int i=0; i<n; i++) {
			strArr[i] = sc.nextLine();
		}
		
		//n踰덉쓽 �닽�옄媛� �삩�떎
		int[] intArr2 = new int[n];
		for(int i=0; i<n; i++) {
			intArr2[i] = sc.nextInt();
		}
		
		 
		
		sc.close();
		
	}

}
