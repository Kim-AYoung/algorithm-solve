package datastructure.배열과리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10818 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		StringTokenizer st;
		
		//입력받는 수의 개수
		int n = Integer.parseInt(br.readLine());	
		
		st = new StringTokenizer(br.readLine());
		int[] intArr = new int[n]; 				
		for(int j=0; j<n; j++) {
			intArr[j] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(min(intArr, 0, n-1) + " " + max(intArr, 0, n-1) + "\n");
		
		bw.flush();
	}
	
	public static int max(int[] arr, int start, int end) { //max from start to end
		
		int m, leftMax, rightMax; 
		m = (start + end) / 2; 					//mid index
		
		if(start == end) {						//재귀 종료 조건
			return arr[start];
		}
		
		leftMax = max(arr, start, m); 			//왼쪽의 max
		rightMax = max(arr, m + 1, end); 		//오른쪽의 max
		
		return (leftMax > rightMax) ? leftMax : rightMax; 
	}
	
	public static int min(int[] arr, int start, int end) { //min from start to end
		
		int m, leftMin, rightMin; 
		m = (start + end) / 2; 					//mid index
		
		if(start == end) {						//재귀 종료 조건
			return arr[start];
		}
		
		leftMin = min(arr, start, m); 			//왼쪽의 min
		rightMin = min(arr, m + 1, end); 		//오른쪽의 min
		
		return (leftMin < rightMin) ? leftMin : rightMin; 
	}

}
