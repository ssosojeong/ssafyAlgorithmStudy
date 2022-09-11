package week6;

import java.io.*;
import java.util.*;

public class Q24479 {
	static boolean[] visited;
	static int[] ans;
	static List<Integer>[] map;
	static int cnt = 1;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		ans = new int[N + 1];
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
			//양방향이므로 각각 리스트에 넣어준다.
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(map[i]);
		// 오름차순으로 정렬해서 방문해야하므로 포문으로 각각 정렬시켜준다.
		dfs(R); // R은 시작정점.

		for (int i = 1; i <= N; i++)
			sb.append(ans[i]).append("\n");

		System.out.println(sb);
	}

	static void dfs(int start) {
		ans[start] = cnt++;
		//cnt는 static변수로 1로 시작한다. 이렇게 ans배열에 넣으면 나중에 순서를 출력할 때 편하다.
		visited[start] = true;
		//방문했음을 표시하고
		for (int end : map[start]) // start의 dfs이므로 start의 간선들을 하나씩 끄집어내서
			if (!visited[end]) // 방문여부를 확인하고
				dfs(end); // 다시 dfs를 실행한다.
	}
}
