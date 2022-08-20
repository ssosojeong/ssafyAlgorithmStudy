package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NK.nextToken()); //수열의 길이
		int K = Integer.parseInt(NK.nextToken());  //합을 할 길이
		
		StringTokenizer arr = new StringTokenizer(br.readLine());// 수열 받기	
		int[] arrList = new int[N];
		for(int i=0;i<N;i++) {//수열을 배열로 받기
			arrList[i] = Integer.parseInt(arr.nextToken());
		}
		
		/////////////////////////////////////////값 입력 받기 끝
		
		
		int sum=0;
		for(int i=0;i<K;i++) {
			sum += arrList[i];
		}
		int max = sum;
		
		for(int i=0;i<N-K;i++) {
			sum = sum -arrList[i] +arrList[i+K];
			if (sum>max) max=sum;
		}
		
		System.out.println(max);
		
		
		br.close();
	}
}
