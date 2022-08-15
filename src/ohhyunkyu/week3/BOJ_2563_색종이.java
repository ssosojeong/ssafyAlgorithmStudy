package week3;

import java.util.Scanner;

public class BOJ_2563_색종이 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이의 수

		// 각 색종이의 가로 세로 크기는 각각 10이다.

		// 주어지는 두 수는 색종이의 왼쪽 아래 꼭짓점.

		// 색종이가 붙은 영역을 1로 채운 후 합을 구한다.

		// 총 범위는 100 * 100.

		int[][] paper = new int[100][100];

		int sum = 0; // 색종이가 붙은 영역의 합.

		for (int i = 0; i < N; i++) {

			int r = sc.nextInt();

			int c = sc.nextInt();

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {

					paper[r + j][c + k] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += paper[i][j];
			}
		}

		System.out.println(sum);
	} // main
} // class