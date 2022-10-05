package practice_1005;

import java.util.Scanner;

public class swea_10월5일_두개의숫자열_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arrN = new int[N];
			int[] arrM = new int[M];

			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}
			//여기까지는 입력값 받기
			int max =Integer.MIN_VALUE;
			if(N<M) {// N이 M보다 작을때
				for(int i =0 ; i<= M-N;i++) {// 곱하는 시작점을 옮긴다.
					int sum =0;
					for(int j=0;j<N;j++) {// 곱을 더한다.
					sum += arrN[j] * arrM[i+j];
					}
					max = Math.max(max, sum);
				}
			}// M이 N보다 작을때
			else if(M<N) {
				for(int i =0 ; i<= N-M;i++) {
					int sum =0;
					for(int j=0;j<M;j++) {
						sum += arrM[j] * arrN[i+j];
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#"+ tc+" "+max);

		}
	}
}
