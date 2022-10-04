package practice_1004;

import java.util.Scanner;

public class swea_10월4일_파리퇴치_2001 {
	static int N, M, max;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			max = 0;
			for (int r = 0; r < N; r++) {// 배열 입력받기
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			} // 배열 입력받기

			for (int r = 0; r <= N - M; r++) {// 시작하는 인덱스부터 탐색
				for (int c = 0; c <= N - M; c++) {
					catchFly(r, c);// 함수연결
				}
			} // 시작하는 인덱스부터 탐색

			System.out.println("#" + tc + " " + max);

		} // tc
	}// main

	private static void catchFly(int a, int b) {// 인덱스별 퍼져나가서 구역잡기
		int count = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				count += arr[a + i][b + j];
			}
		}
		max = Math.max(count, max);

	}

}
