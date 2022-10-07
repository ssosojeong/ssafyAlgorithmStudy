package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P23288 {
	static int N,M,K,direct,sum; //행렬크기, 굴리는 횟수 , 굴릴 방향 , 더한 값
	static int[][] map;//지도
	static int[] diceAfter,diceBefore;//주사위에 대한 정보를 행으로 쭉 받는다. 주사위를 굴릴 때 마다 값을 갱신 해줘야하기 때문에 2개를 가지고 있음
	static boolean[][] v; //주사위가 굴려졌을 때 계속해서 값을 반복해서 가질 수 있어서 계속 초기화해줘야함 그래서 여기서 선언 말고 나중에 dfs 들어가기전에 선언하면된다.
	static int[] diceIdx = {1,1};// 주사위의 정보도 계속 갱신되어야 해서 static 선언
	static int[] dr = {0,1,0,-1}; //0인덱스 3시방향으로 시계방향으로 돔(나중에 direct 사용하기 위해서 맞춤)
	static int[] dc = {1,0,-1,0};
	static int cnt;//dfs를 할 때 같은 수 갯수 셀 때 이용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		diceAfter = new int[] {2,4,1,3,5,6};
		diceBefore = new int[] {2,4,1,3,5,6};
		
		map = new int[N+1][M+1];// 0인덱스 버림
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}//for
		
		//////////////////////입력값 받기 끝
		
		direct = 0; // %4를 이용해서 0은 동, 1은 남 ,2는 서, 3은 북쪽 방향으로 주사위를 굴리는 것을 의미한다.
		sum = 0;
		for(int k=1;k<=K;k++) {//주사위 굴리기
			roll(k);
		}//for
		
//		System.out.printf("result : %d \n",sum);
		System.out.println(sum);
		
		br.close();
	}//main
	private static void roll(int k) {
		//굴려야할 방향 결정
		//처음에는 주사위 밑에 숫자와 그 위치의 map값과 상관없이 동쪽으로 이동하니까 그거에 대한 처리를 해주어야한다.
		if(k==1) {
			diceIdx[1]++;
			right();
		}
		else selectDir();
			
		//방향과 주사위의 인덱스 변경 끝
		
		//주사위가 위치한 값과 같은 값을 가진 곳들 dfs로 돌면서 구해와야한다.
		v = new boolean[N+1][M+1];
		cnt = 0;
		int val = map[diceIdx[0]][diceIdx[1]];
		dfs(diceIdx[0],diceIdx[1],val);
//		System.out.println("-----------------");
//		System.out.printf("#%d\n",k);
//		System.out.println(Arrays.toString(diceAfter));
//		System.out.printf("bottom :%d\n",diceAfter[5]);
//		System.out.println(cnt);
//		System.out.println(val);
//		System.out.printf("r:%d c:%d\n",diceIdx[0],diceIdx[1]);
		sum += cnt*val;
		
	}
	private static void dfs(int r, int c , int val) {
		v[r][c] = true;
		cnt++;
		
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean boundary = (nr>0&& nr<=N)&&(nc>0&&nc<=M);//이건 dfs에서 하는 경계이기 때문에 따로 해줘야한다
			if(boundary && !v[nr][nc] && map[nr][nc]==val) {
				dfs(nr,nc,val);
			}//if
		}//for
		
	}//dfs
	
	private static void selectDir() {
		if(diceAfter[5]>map[diceIdx[0]][diceIdx[1]]) {
			direct++;
			direct %= 4;
		}else if(diceAfter[5]<map[diceIdx[0]][diceIdx[1]]) {
			if(direct==0) direct = 4;
			direct--; //여기서는 %4를 해줄 필요가 없다.
		}//값이 같을 때는 방향이 안바뀌니까 그대로 두면된다.
		
		int nr = diceIdx[0] + dr[direct];
		int nc = diceIdx[1] + dc[direct];
		
		boolean boundary = (nr<=0||nr>N)||(nc<=0||nc>M);
		if(boundary) {//벽을 만나면 방향이 180도 도는 것을 고려
			direct = (direct+2)%4;
			nr = diceIdx[0] + dr[direct];
			nc = diceIdx[1] + dc[direct];
		}//if
		
		//바뀐 위치가 다음에 굴릴때도 유지 되기 때문에 diceIdx가 변경된 값을 지니고 있어야 한다.
		//값을 바로 바꿔 주지 않고 nr,nc를 경유한 건 boundary 때문
		diceIdx[0] = nr;
		diceIdx[1] = nc;
		
		//주사위의 위치가 정해졌다.
		//이제 주사위에 있는 숫자에 대한 정보를 수정해주어야한다.
		
		if(direct==0) right();
		else if(direct==1) down();
		else if(direct==2) left();
		else if(direct==3) up();
		
		
	}
	private static void up() {
		diceAfter[0]=diceBefore[2];
		diceAfter[2]=diceBefore[4];
		diceAfter[4]=diceBefore[5];
		diceAfter[5]=diceBefore[0];
		//다음에도 값 변경해주기 위해서 Before도 갱신해둔다.
		for(int i=0;i<6;i++) diceBefore[i] = diceAfter[i];
	}//up
	private static void left() {
		diceAfter[1]=diceBefore[2];
		diceAfter[2]=diceBefore[3];
		diceAfter[3]=diceBefore[5];
		diceAfter[5]=diceBefore[1];
		//다음에도 값 변경해주기 위해서 Before도 갱신해둔다.
		for(int i=0;i<6;i++) diceBefore[i] = diceAfter[i];
	}//left
	private static void down() {
		diceAfter[0]=diceBefore[5];
		diceAfter[2]=diceBefore[0];
		diceAfter[4]=diceBefore[2];
		diceAfter[5]=diceBefore[4];
		//다음에도 값 변경해주기 위해서 Before도 갱신해둔다.
		for(int i=0;i<6;i++) diceBefore[i] = diceAfter[i];
	}//down
	private static void right() {
		diceAfter[1]=diceBefore[5];
		diceAfter[2]=diceBefore[1];
		diceAfter[3]=diceBefore[2];
		diceAfter[5]=diceBefore[3];
		//다음에도 값 변경해주기 위해서 Before도 갱신해둔다.
		for(int i=0;i<6;i++) diceBefore[i] = diceAfter[i];
	}//right
}//class
