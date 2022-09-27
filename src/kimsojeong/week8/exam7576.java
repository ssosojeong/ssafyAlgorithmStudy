package day0927.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam7576 {
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] tomatoes = new int[N][M];
		
		//하나의 토마토에서 사방으로 동시에 퍼져야하므로 bfs를 사용한다
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int val = Integer.parseInt(st.nextToken());
				tomatoes[i][j] = val;
				//토마토가 있는 자리라면 미리 큐에 넣어준다
                if(val==1) queue.offer(new int[] {i,j});
			}
		}
		
		int[] di= {0,1,0,-1}, dj= {1,0,-1,0};
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curI = cur[0];
			int curJ = cur[1];
			
			for(int d=0; d<4; d++) {
				int newI = curI+di[d];
				int newJ = curJ+dj[d];
				
				if(!check(newI, newJ) || tomatoes[newI][newJ]!=0) continue;
				
				tomatoes[newI][newJ] = tomatoes[curI][curJ]+1;
				queue.offer(new int[] {newI, newJ});
			}
		}
		
		//익어있지 않은 부분이 있는지, 그리고 익은 부분의 최대값은 며칠인지 검사한다.
		boolean flag = true;
		int ans = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomatoes[i][j]==0) {
					flag = false;
					break;
				} else {
					ans = Math.max(tomatoes[i][j], ans);
				}
			}
			if(!flag) break;
		}
		
		System.out.println(flag?ans-1:-1);

	}
	
	static boolean check(int i, int j) {
		if(i<0 || i>=N || j<0 || j>=M) return false;
		return true;
	}

}