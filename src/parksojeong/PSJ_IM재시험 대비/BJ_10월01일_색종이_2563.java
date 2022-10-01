package practice_1001;

import java.util.Scanner;

public class bj_10월01일_색종이_2563 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] graph = new int[100][100]; // 도화지 크기 배열
		int sum = 0;
		for (int c = 1; c <= count; c++) {// 종이수만큼 진행
			int R = sc.nextInt();
			int C = sc.nextInt();
			for (int i = R; i < R + 10; i++) { // 좌하 꼭지점부터 10씩 늘어나는 곳에 1 찍기
				for (int j = C; j < C + 10; j++) {
					if (graph[i][j] == 0) {// 만약 0이라면 1찍고 sum더해주기
						graph[i][j] = 1;
						sum++;
					}
				}
			}

		}
		System.out.println(sum);
	}
}
