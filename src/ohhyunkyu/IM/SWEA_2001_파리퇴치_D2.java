package IMstudy;

import java.util.Scanner;

public class SWEA_2001_파리퇴치_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			//반복문 인덱스 설정에 신경 쓸 것
			for(int i = 0; i < N-M+1; i++) {
				for(int j = 0; j < N-M+1; j++) {
					int cnt = 0;
					for(int k = 0; k < M; k++) {
						for(int d = 0; d < M; d++) {
							cnt += map[i+k][j+d];
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
