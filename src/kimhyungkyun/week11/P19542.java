package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class P19542 {
	static int N,S,D;//노드의 갯수, 케니의 위치, 힘
	static int distance;//주행거리(펀도) 
	static List<Integer>[] list;
	static int[] d;//사정거리 안에 드는지를 기록하기 위한 변수
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];//0인덱스 버림
		for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
		
		//간선에 대한 정보 담기 (트리의 간선의 갯수는 항상 정점의 갯수 - 1 개만큼의 존재)
		//root의 위치(S)가 고정되어 있지 않고 , 1번이 항상 root가 아니기 때문에 간선에 대한 정보를 node 번호 순서대로 준다고 해도 정보를 양방향으로 담아주어야한다.
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}//for
		
		//////////////////입력값 받기 끝
		
		d = new int[N+1];//0인덱스 버림
		//S가 root,반환값은 d 사정거리
		dfs(S,0);//시작인덱스와,부모노드의 인덱스
		//왕복으로 왔다 갔다 해야하니까 
		System.out.println(distance*2);
		
		br.close();
	}//main

	//현재 노드와 부모노드 (부모 노드에 대한 정보를 가지고 있지 않으면 boolean 타입을 사용 해야한다.)
	//반환값은 현재 노드에서 가장 깊은 leaf까지의 자식 노드의 갯수
	private static int dfs(int nodeIdx , int parentNode) {
		for(int next : list[nodeIdx]) {
			if(next != parentNode) {//자식 노드 후보 중 부모 노드랑 같지 않는 녀석들만 들어간다.
				//자식노드가 몇개까지 있는지 표현한다.
				//max를 한 이유는 자식노드가 여러개가 있을 때 가장 큰 값 기준으로 기록하기 위함
				d[nodeIdx] = Math.max(d[nodeIdx], dfs(next, nodeIdx)+1);
			}
		}
		
		//시작점을 제외하고 leaf로 부터 D만큼 떨어져 있는 녀석들의 정점을 세서 간선의 갯수로 활용
		if(nodeIdx!=S && d[nodeIdx] >=  D) {
			distance++;
		}
		return d[nodeIdx];
	
	}//dfs

}//class
