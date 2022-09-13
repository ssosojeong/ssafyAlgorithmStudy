package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24479 {
	static int N;//정점의 수
	static int M;//간선의 수
	static int start;//시작 정점의 수(1부터시작)
	static boolean[] v;
	static int[] order;//순서를 기록해줄 변수
	static int ord;//순서값
	static ArrayList<Integer>[] arrEdge;//간선에 대한 정보를 담을 2차원 배열
	
	private static void dfs(int root) {
		for(int i=0;i<arrEdge[root].size();i++) {
			if(!v[arrEdge[root].get(i)]) {
				order[arrEdge[root].get(i)]=++ord;
				v[arrEdge[root].get(i)]=true;
				dfs(arrEdge[root].get(i));
			}
		}//for
	}//dfs
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		arrEdge = new ArrayList[N+1];//0인덱스는 버릴꺼기 때문에 N+1까지
		for(int i=1;i<=N;i++) {
			arrEdge[i] = new ArrayList<Integer>();
		}//for
		
		for(int i=1;i<=M;i++) {//인덱스 마다 배열을 생성해주었으니까 데이터 기입
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			
			arrEdge[ver1].add(ver2);
			arrEdge[ver2].add(ver1);
		}//for
		
		for(int i=1;i<=N;i++) {//Edge에 넣은 값들이 오름차순 정렬이 되어있어야 순서대로 방문할 수 있으므로 정렬해준다.
			Collections.sort(arrEdge[i]);
		}

        v = new boolean[N+1];//0인덱스를 버림
		v[0]=true;//안쓸꺼기 때문에 이미 들어왔다고 가정
		v[start]=true;//이 부분에 대해서는 좀 더 고려가 필요.
		order = new int[N+1];//0인덱스 버림
		ord = 1;
		order[start]=ord;
		dfs(start);
		
		for(int i=1;i<=N;i++) {
			System.out.println(order[i]);
		}
		br.close();
	}//main
}//class