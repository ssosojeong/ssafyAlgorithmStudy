package week6;

import java.io.*;
import java.util.*;

public class Q2667 {
	static int[][] map;
	static boolean[][] visited;
	static int N, cnt;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; // 그래프 배열 선언
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				map[i][j] = c[j] - '0';
		}
		// 입력값 넣어주기
		visited = new boolean[N][N]; // 방문배열 선언
		List<Integer> list = new ArrayList<>(); // 각각 단지별 아파트 숫자를 넣어줄 리스트. 이후 정렬해서 출력하기 위함
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j] && map[i][j] == 1) { // 방문한적이 없고, 그래프 배열 원소가 1이면
					dfs(i, j); // 해당 i j 에서 dfs를 실행한다.
					list.add(cnt);// dfs안에서 새로운 곳을 방문할때마다 static 변수로 cnt를 ++시켜줬으므로 이를 리스트에 넣는다.
					cnt = 0; // 다시 cnt=0으로 초기화
				}
		Collections.sort(list); // 단지별 아파트 숫자를 오름차순으로 정렬해야 하므로
		sb.append(list.size()).append("\n");
		for (int a : list) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true; // 해당 r,c를 방문처리.
		cnt++; // 단지별 아파트숫자를 체크하기 위해서
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (wall(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				// wall은 outofbound 용도. nr,nc에 방문하지 않았고, 그래프 상에서도 해당 위치가 1일때는
				dfs(nr, nc);// dfs를 실행한다.
			}
		}
	}

	static boolean wall(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}
}
