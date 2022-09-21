package week7;

import java.util.Scanner;

public class BOJ_2740_행렬곱셈_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 행렬 A
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 행렬 B
		int m = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr2 = new int[m][K];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < K; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		// 행렬 곱셈
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				int sum = 0;
				for(int k = 0; k < M; k++) {
					sum += arr[i][k]*arr2[k][j];
				}
				System.out.print(sum + " ");
			}
			// 한 행 입력 완료 후 줄바꿈
			System.out.println();
		}
		
	}
}
