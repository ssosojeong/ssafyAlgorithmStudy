package practice_1004;

import java.util.Scanner;

public class swea_10��4��_�ĸ���ġ_2001 {
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
			for (int r = 0; r < N; r++) {// �迭 �Է¹ޱ�
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			} // �迭 �Է¹ޱ�

			for (int r = 0; r <= N - M; r++) {// �����ϴ� �ε������� Ž��
				for (int c = 0; c <= N - M; c++) {
					catchFly(r, c);// �Լ�����
				}
			} // �����ϴ� �ε������� Ž��

			System.out.println("#" + tc + " " + max);

		} // tc
	}// main

	private static void catchFly(int a, int b) {// �ε����� ���������� �������
		int count = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				count += arr[a + i][b + j];
			}
		}
		max = Math.max(count, max);

	}

}
