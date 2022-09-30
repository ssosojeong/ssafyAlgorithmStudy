package practice0930;

import java.util.Scanner;

public class swea_0930_농작물수확하기_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) { // 농장 숫자 입력 받기
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';

				}
			} // 농장 숫자 입력 받기

			int area = 0, sum = 0, mid = N / 2; // 영역,전체합,중앙 변수선언
			for (int i = 0; i < N; i++) {
				int st = mid - area; // 시작점은 영역을 앞으로 빼주고
				int en = mid + area; // 도착점은 영역을 뒤로 뺀다.
				for (int j = st; j <= en; j++) {
					sum += arr[i][j];
				}
				if (i < mid) { // 열이 중앙보다 작으면 영역을 점점 넓혀간다.
					area++;
				} else {// 열이 중앙보다 같거나크면 영역을 점점 줄여간다
					area--;
				}
			}
			System.out.printf("#%d %d", tc, sum);
			System.out.println();

		} // 테스트케이스
	}// main

}