package practice_1011;

import java.util.Scanner;

public class BJ_10월11일_직사각형네개의합집합_2669 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[][] arr = new int[100][100];
		for (int i = 0; i < 4; i++) {
			int stX = sc.nextInt();
			int stY = sc.nextInt();
			int enX = sc.nextInt();
			int enY = sc.nextInt();
			// 이번 직사각형에 1표시하고 처음 1를 표시한다면 1씩 sum을 늘려가서 면적을 구한다.
			for (int r = stY; r < enY; r++) {	
				for (int c = stX; c < enX; c++) {
					if (arr[r][c] == 0) {
						sum++;
						arr[r][c] = 1;
					}

				}
			} 
		} // 네개의 직사각형

		System.out.println(sum);

	}// main
}
