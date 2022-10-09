package practice_1009;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10월9일_빙고_2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int[] mc = new int[25]; // 사회자가 부른 숫자 저장하는 배열

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 철수의 빙고판

		for (int i = 0; i < 25; i++) {
			mc[i] = sc.nextInt();// 사회자가 부른 숫자
		}
		int count = 0;// 사회자가 숫자를 부른 횟수
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int mcSay = mc[count];// 사회자가 부른 숫자
				count++; // 횟수를 추가한다.

				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (arr[r][c] == mcSay) {
							arr[r][c] = -1;
						}
					}
				} // 사회자가 부른 수를 -1로 표기한다.

				int bingo = 0; // 세개의 빙고를 셀 변수

				for (int r = 0; r < 5; r++) {// 가로 빙고 세기
					int tmpsum = 0;
					for (int c = 0; c < 5; c++) {
						tmpsum += arr[r][c];
					}
					if (tmpsum == -5) {
						bingo++;
					}
				} // 가로 빙고

				for (int c = 0; c < 5; c++) {// 세로 빙고 세기
					int tmpsum = 0;
					for (int r = 0; r < 5; r++) {
						tmpsum += arr[r][c];
					}
					if (tmpsum == -5) {
						bingo++;
					}
				} // 세로 빙고

				int tmpsum = 0;// 좌상향 대각선
				for (int k = 0; k < 5; k++) {
					tmpsum += arr[k][k];
				} // 좌상향 대각선
				if (tmpsum == -5) {
					bingo++;
				}
				
				tmpsum = 0;// 우상향 대각선
				for (int k = 0; k < 5; k++) {
					tmpsum += arr[k][4 - k];
				} // 우상향 대각선
				if (tmpsum == -5) {
					bingo++;
				}
				

				if (bingo >= 3) {
					System.out.println(count);
					break outer;
				}

			}
		} // 사회자

	}

}
