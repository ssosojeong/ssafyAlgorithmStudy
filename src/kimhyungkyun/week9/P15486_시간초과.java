package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P15486_시간초과 {
	static int[] Ti,Pi;
	static int[] sum;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		Ti = new int[N+1]; 
		Pi = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			Ti[i] = Integer.parseInt(st.nextToken());
			Pi[i] = Integer.parseInt(st.nextToken());
		}//for
		
		/////////////////입력값 받기 
		
		sum = new int[N+1];
		dp();

//		System.out.println(Arrays.toString(sum));
		
		System.out.println(sum[N]);
		
		br.close();
	}//main

	private static void dp() {
		
		for(int i=1;i<=N;i++) {
			sum[i] = sum[i-1];
			for(int j=1;j<=i;j++){
				if(j+Ti[j]-1==i) {
					if(sum[i]<sum[j]+Pi[j]) { 
						if(i==j) sum[i] = sum[j-1]+Pi[j];
						else sum[i] = sum[j] + Pi[j];
					}//if
				}//if
			}//for
		}//for
		
	}//dp

}//class
