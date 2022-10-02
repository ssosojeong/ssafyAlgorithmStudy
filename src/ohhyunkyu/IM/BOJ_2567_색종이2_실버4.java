package IMstudy;

import java.util.Scanner;

public class BOJ_2567_색종이2_실버4 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[101][101];
		//먼저 종이가 덮는 구역 1로 채우기
		for(int k = 0; k < N; k++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(map[x+i][y+j] == 1) continue;
					map[x+i][y+j] = 1;
				}
			}
		}
		//조건 확인 //1인데 상,하,좌,우 중 하나 열려있으면 +1 //꼭짓점(두 방향 열림)에서 +2
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = 0; //답
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101;j++) {
				if(map[i][j] == 1) {
					int cnt = 0;
					for(int k = 0; k < 4; k++) {
						int dI = i + dr[k];
						int dJ = j + dc[k];
						//색종이가 도화지 밖으로 나가는 경우는 없음.
						if(dI < 0 || dI >= 101 || dJ < 0 || dJ >= 101) cnt++;
						else if(map[dI][dJ] != 1) cnt++;
						if(cnt == 2) break; //2 초과될 수가 없음
					}
					if(cnt == 1) ans++;
					if(cnt == 2) ans += 2;
				}
			}
		}
		System.out.println(ans);
	}
}
//생각보다 발상이 어려웠다..
