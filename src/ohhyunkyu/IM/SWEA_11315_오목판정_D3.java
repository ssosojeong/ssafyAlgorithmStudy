package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_오목판정_D3 {
	static int N;
	static char[][] map;
	static int[] dr = {0, 1, 1, 1};;
	static int[] dc = {1, 1, 0, -1};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for(int i = 0; i < N; i++)
				map[i] = br.readLine().toCharArray();
			boolean res = false;
			//순차적으로 우, 우하, 하, 좌하까지만 검사하는 걸로 돌려야지
			outer: for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'o' && chk(i, j)) {
						res = true;
						break outer;
					}
				}
			}
			if(res) {
				System.out.println("#" + t + " YES");
			} else {
				System.out.println("#" + t + " NO");
			}
		}//T
	}//main
	
	static boolean chk(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int cnt = 1; //이미 위에서 돌이 있음을 확인하고 들어왔음
			for(int j = 1; j < 5; j++) {
				int dx = x + dr[i]*j;
				int dy = y + dc[i]*j;
				if(dx >= 0 && dx < N && dy >=0 && dy < N) {
					if(map[dx][dy] != 'o') break;
					cnt++;
					if(cnt == 5) return true;
				}
			}
		}
		return false;
	}
}