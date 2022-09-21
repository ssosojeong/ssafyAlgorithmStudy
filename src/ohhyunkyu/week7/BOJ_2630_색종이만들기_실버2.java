package week7;

import java.util.Scanner;

public class BOJ_2630_색종이만들기_실버2 {
	static int N;
	static int[][] paper;
	static int[] res; // 결과를 저장하기 위한 배열
	
	// 지정된 구역이 모두 같은 색인지를 확인하기 위한 함수
	// 반복문을 통해 첫행 첫열 기준으로 검사
	public static boolean check(int row, int col, int num) {
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(paper[row][col] != paper[row + i][col + j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 재귀를 위한 함수 설정. 시작행, 시작열, 구역의 크기를 인수로 받는다. 
	public static void split(int row, int col, int num) {
//		if(num == 1) {
//			res[paper[row][col]]++;
//			return;
//		} // 없어도 되는 부분이긴 함 // num이 1이면 check에서 true로 반환하므로
		
		if(!check(row, col, num)) {
			// 구역의 크기는 2분의 1
			int size = num / 2;
			// 새로 분할된 각 구역을 순회
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					split(row + size * i, col + size * j, size);
				}
			}
		} else {
			// 구역 내의 색이 모두 동일하면 그 내부 값을 결과에 반영
			res[paper[row][col]]++;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N][N];
		res = new int[2]; // 0, 1의 두 가지 속성

		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++)
				paper[i][j] = sc.nextInt();
		
		split(0, 0, N);
		
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
