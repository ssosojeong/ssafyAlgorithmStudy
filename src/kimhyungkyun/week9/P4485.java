package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4485{
	static int[][] arr;
	static int[][] lostCoin;
	static int minVal,N;
	static int[] dr = {0,1,0,-1};//3시부터 시계방향탐색
	static int[] dc = {1,0,-1,0};
	static boolean[][] v;
	
	static class Node implements Comparable<Node>{
		int vCol,vRow,weight;

		public Node(int vCol, int vRow, int weight) {
			super();
			this.vCol = vCol;
			this.vRow = vRow;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			tc++;
			lostCoin = new int[N][N];
			if (N<=0) break;//N이 음수로 들어오면 while 끝
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					lostCoin[i][j] = Integer.MAX_VALUE;
				}//for
			}//for
			
			////////////////////////입력값 끝
			
			v = new boolean[N][N];
			 	
			
			bfs(0,0);
			
			minVal = lostCoin[N-1][N-1];

			sb.append("Problem ").append(tc).append(": ").append(minVal).append("\n");
			
		}//while
		
		System.out.println(sb);
		br.close();
	}//main


	private static void bfs(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(r,c,arr[r][c]));
		lostCoin[r][c] = arr[r][c];
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int row = curr.vRow;
			int col = curr.vCol;
			int wei = curr.weight;
			
			
			for(int d=0;d<4;d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				boolean boundary = (nr>=0 && nr<N) && (nc>=0 && nc<N);
				if (boundary&&(lostCoin[nr][nc] > wei+arr[nr][nc])) {
					lostCoin[nr][nc] = wei+arr[nr][nc];
					pq.add(new Node(nc,nr,lostCoin[nr][nc]));
				}//if
			}//for
			
		}//while
	}//bfs ( dijkstra )
}//class
