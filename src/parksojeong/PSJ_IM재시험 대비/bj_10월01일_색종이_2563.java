package practice_1001;

import java.util.Scanner;

public class bj_10��01��_������_2563 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] graph = new int[100][100]; // ��ȭ�� ũ�� �迭
		int sum = 0;
		for (int c = 1; c <= count; c++) {// ���̼���ŭ ����
			int R = sc.nextInt();
			int C = sc.nextInt();
			for (int i = R; i < R + 10; i++) { // ���� ���������� 10�� �þ�� ���� 1 ���
				for (int j = C; j < C + 10; j++) {
					if (graph[i][j] == 0) {// ���� 0�̶�� 1��� sum�����ֱ�
						graph[i][j] = 1;
						sum++;
					}
				}
			}

		}
		System.out.println(sum);
	}
}
