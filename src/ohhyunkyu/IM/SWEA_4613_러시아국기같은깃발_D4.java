package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_러시아국기같은깃발_D4 {
	static int N, M, ans;
	static char[][] map;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
			arr = new int[2];
			visited = new boolean[N];//행에 방문처리
			ans = Integer.MAX_VALUE;//최소값 구하기
		
			//N 중 순열로 기준 2개 고르기
			perm(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}//main

	static void perm(int idx, int sidx) {
		if(sidx == 2) {
			ans = Math.min(ans, count());
			return;
		}
		//맨 끝의 한 줄은 항상 빨간색이므로 i < N이 아님
		for(int i = idx; i < N-1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[sidx] = i;
				perm(i+1, sidx+1);
				visited[i] = false;
			}
		}
	}
	
	static int count() {
		int ccnt = 0;
		for(int i = 0; i < N; i++) {
			if(i <= arr[0]) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 'W') {
						ccnt++;
					}
				}
			}
			else if(i <= arr[1]) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 'B') {
						ccnt++;
					}
				}
			}
			else {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 'R') {
						ccnt++;
					}
				}
			}
		}
		return ccnt;
	}
}
//위부터 하얀색, 파란색, 빨간색
//경우의 수에 따라 바꾸어야하는 칸의 수를 구해 비교