package text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam19542 {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph ;
	static int D, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		//나를 루트 노드로 하는 서브트리의 depth가 d와 같다면 그 이하로는 내려가지 않아도 된다.
		//즉, 서브트리의 depth를 구해야 한다!
		//어떤 노드를 루트로 하는 트리의 depth
		//	= 해당 노드의 자식 노드들 각각의 서브트리의 depth들의 최대값
		
		graph = new ArrayList<>();
		for(int n=0; n<=N; n++) {
			graph.add(new ArrayList<>());
		}
		
		for(int n=0; n<N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//시작점이 1이 아닐 수 있으므로 우선 그래프처럼 양 노드에 모두 간선 정보를 저장해줘야한다.
			graph.get(p).add(c);
			graph.get(c).add(p);
		}
		
		visited = new boolean[N+1];
		
		dfs(S);
		System.out.println(ans);
	
		
	}
	
	public static int dfs(int cur) {
		//내가 단말노드인지 아는 방법
		//내가 가진 모든 연결 관계가 이미 다 방문된 상태라면 단말노드이다.
		//내가 단말노드라면 -> 0을 리턴한다
		if(isLeaf(cur)) {
			return 0;
		} else {
			int curD = 0;
			visited[cur] = true;
			for(int next : graph.get(cur)) {
				if(visited[next]) continue;
				//어떤 노드의 깊이는
				//해당 노드의 자식 노드의 깊이들의 최대값을 통해 구할 수 있음
				//d: 자식 노드의 깊이
				int d = dfs(next);
				//이 때 자식 노드의 깊이가 D보다 크거나 같으면 ans +2
				//자식 노드의 깊이가 D보다 크거나 같다는 것은
				//해당 자식 노드로 가서 우선 전단지를 뿌려야 한다는 것
				//왕복이니까 2 더해주기
				if(d>=D) ans+=2;
				curD = Math.max(curD, d+1);
			}
			return curD;
		}
	}
	
	//해당 노드가 단말 노드인지 판단
	public static boolean isLeaf(int node) {
		for(int next:graph.get(node)) {
			if(!visited[next]) {
				return false;
			}
		}
		return true;
	}
	

}
