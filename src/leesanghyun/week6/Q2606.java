package week6;

import java.io.*;
import java.util.*;

public class Q2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer>[] map = new ArrayList[N + 1];
		// 컴퓨터의 수는 100이하이므로 2차원배열로 선언해도 무방합니다.
		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
			// 양방향 간선이므로
		}
		Queue<Integer> que = new LinkedList<>();
		// bfs queue를 선언
		que.add(1);
		// 시작점을 넣어주고
		visited[1] = true;
		// 시작점을 방문처리한다.
		int cnt = -1; // 시작점까지 cnt++시키기 때문에 미리 -1로 선언한다.
		while (!que.isEmpty()) { // que가 비어있지 않다면 계속 실행한다는 뜻의 while문
			int cur = que.poll();
			cnt++;// que에서 꺼냈다면 cnt를 ++해준다.
			for (int end : map[cur]) {
				if (!visited[end]) {
					visited[end] = true; // end점을 방문처리해주고
					que.add(end); // bfs queue에 넣어준다.
				}
			}
		}
		System.out.println(cnt);
	}
}
