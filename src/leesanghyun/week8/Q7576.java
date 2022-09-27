import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	static int[][] arr;
	static int N, M;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static Queue<Node> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean already = false; // 안익은 토마토가 없을경우 true로 바꾼다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					que.offer(new Node(i, j)); // 익은 토마토들을 큐에 넣어준다.
				} else if (arr[i][j] == 0) { // 안익은 토마토가 있네
					already = true;
				}
			}
		}
		if (!already) {
			System.out.println(0);
			return;
		}
		bfs(); // 큐에 넣어둔 토마토들을 토대로 bfs를 돌린다.
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		} // max값 구해서 출력한다.
		System.out.println(max);

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			Node curNode = que.poll(); // 일단 뽑아주고
			for (int i = 0; i < 4; i++) {
				int nr = curNode.r + dr[i];
				int nc = curNode.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (arr[nr][nc] == 0) { // 근처 토마토가 안익었으면
						arr[nr][nc] = curNode.cost + 1; // arr배열에 일수를 표시하고
						que.offer(new Node(nr, nc, curNode.cost + 1)); // 토마토에도 cost를 +1해서 넣어준다.
					}
				}
			}
		}
	}

	private static class Node {
		int r;
		int c;
		int cost;

		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		public Node(int r, int c) { // cost고려안하고 만들었었는데 중간에 추가해서 이미 이걸로 선언해놓은거 바꾸기는 귀찮고해서 그냥 놔둠
			this.r = r;
			this.c = c;
		}
	}
}
