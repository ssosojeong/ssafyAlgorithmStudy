package week6;

import java.io.*;
import java.util.*;

public class Q24444 {
	static int N, M, R;
	static List<Integer>[] map;
	static int[] ans;
	static boolean[] visited;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		ans = new int[N + 1];
		visited = new boolean[N + 1];
		map = new ArrayList[N + 1];
		// 정점의 수가 십만개까지 있으므로 이를 이차원 배열로 하면 십만X십만으로 메모리 초과가 뜬다.
		// 그렇기 때문에 리스트를 N개만큼 메모리에 할당하여 진행한다.

		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		// 리스트를 배열로 선언하고, for문을 통해 선언한다.
		// Arrays.fill(map, new ArrayList<>()); 도 가능.

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
			// 양방향이므로 각각 리스트에 넣어준다.
		}
		for (int i = 1; i <= N; i++)
			Collections.sort(map[i]);
		// 오름차순으로 정렬해서 방문해야하므로 포문으로 각각 정렬시켜준다.
		bfs(R);// R은 시작정점

		for (int i = 1; i <= N; i++)
			sb.append(ans[i]).append("\n");

		System.out.println(sb);
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>(); // bfs Queue 선언
		visited[start] = true;
		// start 정점으로 시작하므로, start는 방문한다. 여기서 하지 않으면 밑의 58번째 줄에서 start를 재방문하게된다.
		que.add(start); // que에 넣어주고 bfs를 시작한다.(while문 조건때문에)
		while (!que.isEmpty()) {
			int cur = que.poll();
			ans[cur] = cnt++; // cnt 는 static변수로 위와같이 선언하면 후에 출력때 편하다.
			for (int end : map[cur]) // cur의 간선정보들을 전부 다 조사한다.
				if (!visited[end]) { // cur의 간선정보들 중 하나인 end에 방문하지 않았다면
					visited[end] = true; // 이를 방문처리해주고
					que.add(end); // bfs que에 넣어준다.
				}
			// for문이 종료되면 다시 while문 처음으로 돌아가서 que에 담긴 정점들을 for문을 통해 조사한다.
		}
	}
}
