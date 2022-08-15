package studysol_1;

import java.util.Scanner;

public class 빙고_2578 {
	public static int[][] bingo = new int[5][5];
	public static int rst = 0;
	public static int bcnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		} // 빙고판 입력

		int[] call = new int[25];
		for (int i = 0; i < 25; i++) {
			call[i] = sc.nextInt(); // 사회자가 부르는 숫자

			for (int j = 0; j < 5; j++) {
				for (int d = 0; d < 5; d++) {
					if (call[i] == bingo[j][d]) {
						bingo[j][d] = 0; // 일치하는 빙고판 위치를 0으로 전환
						rst += 1; // 시행횟수 증가
					}
				}
			}
			rS();
			cS();
			lD();
			rD(); // 탐색 메서드

			if (bcnt >= 3) {
				System.out.println(rst);
				break; // 빙고 수가 3 이상이면 결과 출력 후 종료
			} else {
				bcnt = 0; // 재확인을 위해 빙고 수 초기화
			}
		} // 사회자가 부르는 순서 입력 후 그에 따라 빙고판의 수를 0으로 변환

	}// 메인

	public static void rS() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0) {
					cnt += 1;
				} // 행의 0 개수를 카운트
			}
			if(cnt == 5) {
				bcnt += 1;
			} // 행의 0 개수가 5개이면 빙고 1개 플러스
		}
	}

	public static void cS() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(bingo[j][i] == 0) {
					cnt += 1;
				} // 열의 0 개수를 카운트
			}
			if(cnt == 5) {
				bcnt += 1;
			} // 열의 0 개수가 5개이면 빙고 1개 플러스
		}
	}

	public static void lD() {
		if(bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0 && bingo[4][4] == 0) {
			bcnt++;
		} // 좌에서 우 대각선 탐색
	}

	public static void rD() {
		if(bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0 && bingo[4][0] == 0) {
			bcnt++;
		} // 우에서 좌 대각선 탐색
	}

}
// class
