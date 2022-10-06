package IMstudy;

import java.util.Scanner;

public class SWEA_1959_두개의숫자열_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i = 0; i < N+M; i++) {
				if(i < N) A[i] = sc.nextInt();
				else B[i-N] = sc.nextInt();
			}
			int ans = 0;//답
			if(N >= M) {
				for(int i = 0; i <= N-M; i++) {
					int sum = 0;//각 구간 임시 합계 확인
					for(int j = 0; j < M; j++) {
						sum += A[i+j] * B[j];
					}
					ans = Math.max(ans, sum);
				}
			}
			else {
				for(int i = 0; i <= M-N; i++) {
					int sum = 0;//각 구간 임시 합계 확인
					for(int j = 0; j < N; j++) {
						sum += A[j] * B[i+j];
					}
					ans = Math.max(ans, sum);
				}
			}
			System.out.println("#" + t + " " + ans);
		}//T
	}
}
