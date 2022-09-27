package day0927.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14889 {
	static int[][] map;
	static boolean[] visit;
	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {        //첫번째 선수는 외부에서 구해준다.
			visit[i] = true;
			dfs(1,i);
			visit[i] = false;
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int cnt, int last) {
		if(cnt==N/2) {
			//시너지의 합을 모두 구해준다.
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(visit[i]) {			//true면 1팀 -> sum에 더해주기
					for(int j=0; j<N; j++) {
						if(visit[j]) {	//j역시 1팀이면
							sum += map[i][j];
						}
					}
				} else {				//false면 2팀 -> sum에서 까주기
					for(int j=0; j<N; j++) {
						if(!visit[j]) {
							sum -= map[i][j];
						}
					}
				}
			}
			ans = Math.min(ans, Math.abs(sum));
			
		} else {
			//내가 직전에 3번 선수를 선택했다면, 4번선수부터 판단한다.
			//(3,1)의 경우의 수는 1번 선수를 선택했을 때 (1,3)으로 검사했을것이기 때문
			for(int i=last+1; i<N; i++) {
				visit[i] = true;
				dfs(cnt+1, i);
				visit[i] = false;
			}
		}
	}
    
}
