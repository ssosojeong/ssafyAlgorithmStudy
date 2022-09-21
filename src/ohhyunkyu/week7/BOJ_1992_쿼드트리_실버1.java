package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리_실버1 {
	static int N;
	static int[][] map;
	// 결과를 추출하기 위한 스트링빌더
	static StringBuilder sb = new StringBuilder();
	
	// 같은 수로 이루어져 있는지를 확인하기 위한 함수
	public static boolean check(int r, int c, int n) {
		int chk = map[r][c]; // 첫행첫열로 비교
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(chk != map[r + i][c + j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 압축을 위한 재귀 함수
	public static void zip(int r, int c, int n) {
		
		if(!check(r, c, n)) {
			// 모두 일치하지 않는다면 영역 분할 후 재귀
			int size = n / 2; // 범위 지정을 위한 변수
			sb.append("("); // 매 함수 호출 시 괄호로 감싸기
			for(int i = 0; i < 2; i++) 
				for(int j = 0; j < 2; j++)
					zip(r + i * size, c + j * size, size);
			sb.append(")"); // 영역 연산 종료 시 괄호 닫기
		} else {
			// 모두 같은 수로 이루어져 있다면 sb에 추가
			sb.append(map[r][c]);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 영상의 크기
		N = Integer.parseInt(br.readLine());
		// 영상 비트맵
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 재귀 // 행, 열, 크기
		zip(0, 0, N);
		
		System.out.println(sb.toString());
	}
}
