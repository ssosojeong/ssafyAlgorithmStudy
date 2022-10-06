package october_Practice;

import java.util.Scanner;

public class swea_10월6일_달팽이숫자_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = { 0, 1, 0, -1 }; // 우하좌상
		int[] dc = { 1, 0, -1, 0 };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {// 테두리 0으로 채우기
				arr[0][i] = -1;
				arr[N + 1][i] = -1;
				arr[i][0] = -1;
				arr[i][N + 1] = -1;
			} // 테두리 0으로 채우기
			int idxR = 1, idxC = 1, idxD = 0;// 처음 시작하는 인덱스와 방향인덱스 선언
			;

			for (int i = 1; i <= N * N; i++) {
				arr[idxR][idxC] = i;

				if (arr[idxR + dr[idxD]][idxC + dc[idxD]] != 0 || arr[idxR + dr[idxD]][idxC + dc[idxD]] == -1) {
					// 만약 이동했을때 0이 아니라면 혹은 -1이라면
					idxD = (idxD + 1) % 4; // 늘어나는 방향을 바꿔준다.
				}
				idxR += dr[idxD];// 다음 인덱스 지정
				idxC += dc[idxD];
			}
			System.out.println("#" + tc + " ");
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		} // tc

	}// main

}
