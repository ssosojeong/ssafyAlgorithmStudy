package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606 {
	static int vertex;//정점의 수
	static int edge;//간선의 수
	static int cnt;//바이러스에 걸리게 되는 컴퓨터 수
	static boolean[] verVisit;//정점의 방문기록
	static ArrayList<Integer>[] arr;//간선에 대한 정보를 담은 배열
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vertex = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		verVisit = new boolean[vertex+1];//0인덱스는 제외하고 사용
		arr = new ArrayList[vertex+1];
		for(int i=1;i<=vertex;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<edge;i++) {//edge에 대한 정보 배열로 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ver = Integer.parseInt(st.nextToken());
			int nextVer = Integer.parseInt(st.nextToken());
			arr[ver].add(nextVer);//간선의 정보가 작은 정점에서 큰 정점으로 주는 것이 아니기 때문에 한 곳으로만 정보를 넣어주면 오류가 나는 케이스가 존재한다.
			arr[nextVer].add(ver);
		}//for
		
		cnt = 0;
		verVisit[1]=true;//첫번째꺼는 true로 해서 다시 못들어오게 막아둠
		dfs(1);
		
		System.out.println(cnt);
		
		br.close();
	}
	private static void dfs(int idx) {
		for(int i=0;i<arr[idx].size();i++) {
			if(!verVisit[arr[idx].get(i)]) {
				verVisit[arr[idx].get(i)] = true;
				cnt++;
				dfs(arr[idx].get(i));
			}
		}//for
	
	}
}
