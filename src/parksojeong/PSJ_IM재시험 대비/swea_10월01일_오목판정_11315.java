package practice_1001;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10월01일_오목판정_11315 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {// 입력받기
			boolean bingo = false;
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);

				}
			} // 입력받기

			outer: for (int i = 0; i < N; i++) {// 가로빙고 확인
				for (int j = 0; j < N; j++) {
					int sum = 0;
					if (j + 4 < N) {//범위 확인
						for (int k = 0; k < 5; k++) { //연속 o 나오는지 확인
							if (arr[i][j + k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // 더해서 5이면 true 하고 나가준다.
						bingo = true;
						break outer;
					}
				}
			} // 가로 빙고확인
			outer: for (int i = 0; i < N; i++) { // 세로 빙고 확인
				for (int j = 0; j < N; j++) {
					int sum = 0;
					if (j + 4 < N) {//범위 확인
						for (int k = 0; k < 5; k++) {//연속 o 나오는지 확인
							if (arr[j + k][i] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // 더해서 5이면 true 하고 나가준다.
						bingo = true;
						break outer;
					}
				}
			} // 세로 빙고확인

			outer: for (int i = 0; i < N; i++) {// 우상향 대각선 빙고확인
				for (int j = 4; j < N; j++) {
					int sum = 0;
					if (i + 4 < N && j - 4 < N) {//범위 확인
						for (int k = 0; k < 5; k++) {//연속 o 나오는지 확인
							if (arr[i + k][j - k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // 더해서 5이면 true 하고 나가준다.
						bingo = true;
						break outer;
					}
				}
			} // 대각선 우상향

			outer: for (int i = 0; i < N; i++) {// 좌상향 대각선 빙고확인
				for (int j = 4; j < N; j++) {
					int sum = 0;
					if (j - 4 >=0 && i - 4 >=0) {//범위 확인
						for (int k = 0; k < 5; k++) {//연속 o 나오는지 확인
							if (arr[j - k][i - k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // 더해서 5이면 true 하고 나가준다.
						bingo = true;
						break outer;
					}
				}
			} // 좌상향
			if (bingo) {// 출력
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}

		} // 대각선 좌상향
	}

}
