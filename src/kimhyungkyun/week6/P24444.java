package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P24444 {
	static int N;//정점의 수
	static int M;//간선의 수
	static int start;//시작점
	static boolean[] verBool;//정점들을 상태를 담은 배열
	static int[] verOrder;
	static ArrayList<Integer>[] edgeArr;//간선의 정보를 담은 배열
	static Queue<Integer> queue;
	static int order;
	
	public static void bfs(int root) {
		queue.offer(root);
		verBool[root] = true;
		while(!queue.isEmpty()) {
			int ver = queue.poll();
			verOrder[ver] = order++;
			for(int i=0;i<edgeArr[ver].size();i++) {
				int temp = edgeArr[ver].get(i);
				if(!verBool[temp]) {
					verBool[temp] = true;
					queue.offer(temp);
				}//if
			}//for
		}//while
	
	}//bfs
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		verBool = new boolean[N+1];
		verOrder = new int[N+1];
		edgeArr = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {//edgeArr 각 행을 배열로 초기화
			edgeArr[i] = new ArrayList<>();
		}//for
		for(int i=1;i<=M;i++) {//간선에 대한 정보 인덱스를 이용해 각 vertex에 해당하는 값 저장
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			
			edgeArr[ver1].add(ver2);
			edgeArr[ver2].add(ver1);
		}//for
		
		for(int i=1;i<=N;i++) {//들어오는 값 오름차순 정렬
			Collections.sort(edgeArr[i]);
		}//for
		
		verBool[0]=true;
		queue = new LinkedList<>();
		order=1;
		bfs(start);
		
		for(int i=1;i<=N;i++) {//vertex 순서대로 출력
			System.out.println(verOrder[i]);
		}//for
		
		
		br.close();
	}
}
