package IMstudy;

import java.util.Scanner;

public class BOJ_2563_색종이_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		int cnt = 0;
		//N번 채우기 //받으면서 좌표 받아서 동시에 처리 //이미 1인 상태이면 카운트 안 함
		for(int k = 0; k < N; k++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(map[x+i][y+j] == 1) continue;
					map[x+i][y+j] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
