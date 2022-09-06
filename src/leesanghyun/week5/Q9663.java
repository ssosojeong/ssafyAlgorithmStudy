package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9663 {
	static Stack<Integer> stack1 = new Stack<>(); // r좌표를 넣어줄 stack
	static Stack<Integer> stack2 = new Stack<>(); // c좌표를 넣어줄 stack
	static int N;
	static int ans = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N]; // NxN의 방문배열 선언
		dfs(0); // dfs시작
		System.out.println(ans);
	}

	static void dfs(int r) {
		if (r == N) { // r이 N이면 ans를 하나 더해주고 리턴한다. 
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) { // 열을 0부터 N까지 탐색한다.
			if (!visited[r][i]) { // 만약 해당 자리에 퀸이 들어갈 수 있을 경우
				int tmp = move(r, i); // move함수를 통해 방문배열에 퀸이 이동할 수 있는 부분들을 true로 바꿔준다.
				//이때 dfs(r+1)을 실행하고 그 부분들을 다시 false로 바꿔줘야 하므로 move를 int형으로 선언하고 tmp에 값을 저장해둔다.
				dfs(r + 1); // dfs 파고들기
				for (int j = 0; j < tmp; j++) {//dfs가 끝났으면 위의 move를 통해서 true로 바꿨던 부분들을 다시 false로 바꿔준다.
					visited[stack1.pop()][stack2.pop()] = false;
				}
			}
		}
	}

	static boolean wall(int r, int c) { // 범위 밖으로 움직이려 하면 false, 괜찮으면 true반환하는 함수
		if (r >= N || r < 0 || c >= N || c < 0)
			return false;
		return true;
	}

	static int move(int r, int c) {
		int cnt = 0; // stack에 넣어주고 빼줘야하므로 cnt를 해준다.
		for (int i = r + 1; i < N; i++) {
			if (!visited[i][c]) {
				visited[i][c] = true;
				stack1.add(i);
				stack2.add(c);
				cnt++;
			}
		}
		int nr = r;
		int nc = c;
		while (wall(nr, nc)) {
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				stack1.add(nr);
				stack2.add(nc);
				cnt++;
			}
			nr++;
			nc++;
		}
		nr = r;
		nc = c;
		while (wall(nr, nc)) {
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				stack1.add(nr);
				stack2.add(nc);
				cnt++;
			}
			nr++;
			nc--;
		}
		return cnt;
	}
}
