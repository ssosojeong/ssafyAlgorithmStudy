package studysol_1;

import java.util.Scanner;

public class 직사각형_네개의_합집합_면적_구하기_2669 {
	public static void main(String[] args) {
		int[][] map = new int[101][101];
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 사각형 위치 파악 후 해당되는 영역 1로 변환
		for(int i = 0; i < 4; i++) {
			int[] sq = new int[4];
			for(int j = 0; j < 4; j++) {
				sq[j] = sc.nextInt();
			} // 위치 정보 입력
			for(int j = 0; j < sq[3] - sq[1]; j++) {
				for(int d = 0; d < sq[2] - sq[0]; d++) {
					map[sq[0]+d][sq[1]+j] = 1;
				}
			} // 위치 간 차이를 통해 1로 변환, 그 과정에서 중복 제거
		}
		
		// 1로 변환한 영역 합계를 통해 결과 도출
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j] == 1) {
					sum += 1;
				}
			}
		}
		
		System.out.println(sum);
				
	}
}
