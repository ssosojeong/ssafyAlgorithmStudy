package bingo;

import java.util.*;

public class bingo_2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] bingo = new int[26]; // 1부터 25까지 빙고숫자를 index로 기록하여 몇번째순서에 나오는지를 값으로 기록하기 위한 배열
		int order = 1;// 순서 1에서 시작하기 위한 변수
		for (int i = 1; i <= 25; i++) {
			bingo[sc.nextInt()] = order;
			order++; // 빙고판의 숫자의 순서를 배열에 기록
		}

		int count = 0;// 빙고 카운트

		for (int i = 1; i <= 25; i++) {
		
			int sum_ver = 0;// 세로 빙고 확인
			int sum_hor = 0;// 가로 빙고 확인
			int sum_cross1 = 0; // 대각선 1 빙고 확인
			int sum_cross2 = 0; // 대각선 2 빙고 확인
			bingo[sc.nextInt()] = -1; 	// 표시가 되면 -1이라고 한다. 한줄에 -5가되면 빙고가되는겨

			// 세로 빙고 카운트
			for (int j = 1; j <= 5; j++) {
				for (int k = 0; k < 5; k++) {
					sum_ver += bingo[j + 5 * k];
				}
				if (sum_ver == -5) {
					count++;
				}
				 sum_ver = 0;
			}

			// 가로빙고 카운트
			for (int j = 1; j <= 21; j = j + 5) {
				for (int k = 0; k < 5; k++) {
					sum_hor += bingo[j + k];
				}
				if (sum_hor == -5) {
					count++;
				}
				sum_hor = 0;
			}

			// 대각선 빙고 카운트1
			for (int j = 1; j <= 25; j = j + 6) {
				sum_cross1 += bingo[j];
			}
			if (sum_cross1 == -5) {
				count++;
			}
			// 대각선 빙고 카운트2
			for (int j = 5; j <= 21; j = j + 4) {
				sum_cross2 += bingo[j];
			}

			if (sum_cross2 == -5) {
				count++;
			}
			//빙고가 세개가 되면 몇번째인지 출력하고 반복문 종료
			if (count == 3) {
				System.out.println(i);
				break;
			}
		}

	}

}
// 저 본인인데 틀렸답니다~
// 스터디때 까지 못찾으면 같이 찾아봐도 괜찮겠네요~ -김형균-
