package practice_1011;

import java.util.Scanner;

public class BJ_10월11일_수열_2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 2이상 100000 이하
		int K = sc.nextInt(); // 1과 N사이 정수

		// -100 ~ 100
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=N-K;i++) {
			int sum=0;//온도더할거임
			for(int j=0;j<K;j++) {
				sum+=arr[i+j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
