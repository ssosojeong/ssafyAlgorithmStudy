package practice_1013;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10월13일_체스판위의룩배치_15612 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			} // 배열입력받기

//			for (int i = 0; i < 8; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			int count = 0;
			for (int i = 0; i < 8; i++) {// o의 개수 세기
				for (int j = 0; j < 8; j++) {
					if (arr[i][j] == 'O') {
						count++;
					}
				}
			} // o세기

			if (count != 8) {
				System.out.println("#" + tc + " " + "no");
				continue;
			}

			boolean isSafe = true;
			int[] dr = {  0, 1 };// 상우하좌
			int[] dc = {  1, 0};
			outer: for (int i = 0; i < 8; i++) {// o공격성검사
				for (int j = 0; j < 8; j++) {
					if (arr[i][j] == 'O') {
						// 상
						for (int k = 0; k < 2; k++) {
							for (int num = 1; num <= 7; num++) {//최대 7칸 갈수 있으니까
								int rr = i + dr[k] * num;
								int cc = j + dc[k] * num;  
								if (0 <= rr && 0 <= cc && rr < 8 && cc < 8) {
									if (arr[rr][cc] == 'O') {
										isSafe = false;
										break outer;
									}
								}
							}
						}
					}
				}
			} // o공격안하는지 검사하기
//			System.out.println(isSafe);
			if (isSafe) {
				System.out.println("#" + tc + " " + "yes");

			} else {
				System.out.println("#" + tc + " " + "no");

			}

		} // tc

	}

}
