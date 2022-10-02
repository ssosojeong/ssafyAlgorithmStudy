package pracitce_1002;

import java.util.Scanner;

//전체적으로 풀줄 몰라서 찾아봤던 문제입니다. 
public class BJ_10월2일_색종이2_2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] arr = new int[100][100];// 도화지 만들기
		for (int c = 0; c < count; c++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			for (int i = R; i < R + 10; i++) {// 전체를 색종이 있는부분을 1로 한다.
				for (int j = C; j < C + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		int[] dr = { -1, 0, 1, 0 };// 상우하좌
		int[] dc = { 0, 1, 0, -1 };
		int length = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {// 만약 색종이 부분일때 사방탐색을 해서 0인부분에서 길이를 늘려준다.
					for (int k = 0; k < 4; k++) {// 사방탐색
						int rr = i + dr[k];
						int cc = j + dc[k];
						if (rr >= 0 && cc >= 0 && rr < 100 && cc < 100 && arr[rr][cc] == 0) {// 사방탐색할때는 범위 조심
							length++;
						} else if (rr < 0 || cc < 0 || rr >= 100 || cc >= 100) {// 범위를 벗어나면 그부분은 그냥 더해준다.둘레가 되니까 내가 이걸
																				// 몰랐다...
							length++;
						}
					} // 사방탐색
				} // 만약 색종이부분일때
			}
		} // 색종이 둘레 구하기

		System.out.println(length);
	}
}
