package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1258SWEA {
	static class Node implements Comparable<Node>{
		int r,c,area;

		public Node(int r, int c, int area) {
			super();
			this.r = r;
			this.c = c;
			this.area = area;
		}//constructer

		public int compareTo(Node o) {
			if(this.area == o.area) 
				return this.r-o.r;
			else return Integer.compare(this.area, o.area);
		}//compareTo overriding

	}//Node
	
	static int N,cnt;
	static int[][] map;
	static boolean[][] v;
	static Queue<Node> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v =  new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}//for
			
			/////////////////////////////////입력값 받기 끝
			
			cnt = 0;
			pq = new PriorityQueue<>();
			for(int i=0;i<N;i++) 
				for(int j=0;j<N;j++)
					if(!v[i][j]&&map[i][j]!=0)
						check(i,j);//사각형의 정보를 찾아내줄 함수
			
			sb.append("#" + tc + " " + cnt + " ");
			
			while(!pq.isEmpty()) {//넓이를 오름차순으로 꺼내서 출력에 넣는 과정
				Node node = pq.poll();
				int r = node.r;
				int c = node.c;
				
				sb.append(r + " " + c + " ");
				
			}//while
			
			System.out.println(sb);
			
		}//for
		
		br.close();
	}//main

	private static void check(int row, int col) {
		int i=row,j=col;
		while(j<N && map[row][j]!=0) {//사각형의 가로 길이 구하기 
			j++;
		}//while
		while(i<N && map[i][col]!=0) {//사각형의 세로 길이 구하기 
			i++;
		}//while
		
		int r = (i - row);
		int c = (j - col);
		int area = (i-row) * (j - col);
		
		pq.add(new Node(r,c,area));		
		cnt++;
		
		for(int si=row;si<i;si++) //사각형 확인한거 다시 검사 못돌게 true로 값 변경
			for(int sj=col;sj<j;sj++) 
				v[si][sj] = true;
		
		
	}//check
	
}//class
