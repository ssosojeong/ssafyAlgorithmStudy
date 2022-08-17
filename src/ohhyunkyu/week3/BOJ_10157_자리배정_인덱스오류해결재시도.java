package week3;

import java.util.Scanner;

public class BOJ_10157_자리배정_인덱스오류해결재시도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 5 <= C, R <= 1,000 1 <= K <= 100,000,000

		int C = sc.nextInt(); // 가로 길이 (배열의 행 수)

		int R = sc.nextInt(); // 세로 길이 (배열의 열 수)

		int K = sc.nextInt(); // 관객의 대기번호

		int[][] map = new int[C][R]; // 좌석 배열 생성

		int idx = 1; // 좌석 인덱스

		int cnt = 0; // 방향 바꾸기

		int r = 0, c = 0; // 행, 열 인덱스

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 }; // 우 하 좌 상

		if (K > C * R) { // 좌석 배정 불가인 경우 0을 리턴
			System.out.println(0);
			return;

		} else { // K <= C*R 인 경우 좌석이 존재하므로 while문 시행
			
			while (idx != K) { // idx가 K가 되면 원하는 값이 도출되었으므로 탈출
				
				map[r][c] = idx;

				int rm = r + dr[cnt];
				int cm = c + dc[cnt];
				
				// 아래의 조건 충족 시 카운트 변경(범위 벗어남, 값 존재)
				if (rm < 0 || rm >= C || cm < 0 || cm >= R || map[rm][cm] != 0) {
					
					cnt++; // 방향 변경
					
					if (cnt == 4) { // 카운트가 4에 도달하면 다시 0으로 변환
						cnt = 0;
					}
					
					rm = r + dr[cnt]; // 인덱스 오류가 나지 않도록 다시 정의
					cm = c + dc[cnt];
				}
				
				// 인덱스 위치 변화 반영
				r = rm;
				c = cm;
				idx++; // 순번 증가
			}

			System.out.println((r + 1) + " " + (c + 1)); // 문제는 1,1부터 시작
		}

	} // main
} // class
//P소정 : 현규님이 코드에 일일히 설명을 다 달아놓으셔서 이해에 쉽게 도움이 되었습니다! 델타이동 순서를 원래자리배치처럼 상우하좌로 해보시는것도 좋은것 같아요! 
