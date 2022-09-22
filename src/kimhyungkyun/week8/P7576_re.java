package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576_re {
	static int N,M;//NxM배열 받기
	static int dayCnt;//후숙 되려면 몇 일 걸리는지
	static int[][] arr;//NxM배열
	static boolean[][] v;//방문한 곳을 기록할 2차원 배열
	static int tomatoCnt;//익은 토마토를 저장할 변수
	static int totalTomatoCnt; //모든 토마토의 갯수
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};//익은 토마토 근처를 조사하기 위한 델타
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int blank=0;//빈 곳의 갯수
		tomatoCnt = 0;
		v = new boolean[N][M];//방문한 곳을 또 방문하지 않게 기록해두기 위한 boolean배열
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) blank++;
				else if(arr[i][j]==1){
					tomatoCnt++;//익은 토마토 갯수 카운트
					queue.offer(new int[] {i,j});
				}
				//안익은 토마토는 bfs를 못 돌게 true로 해서 막아둬야 익은 토마토에 의해 다른 토마토를 익히는 경우를 방지할 수 있다.
			}//for
		}//for
		
		////////////////////////////입력값 받기 끝
		
		dayCnt=0;
		totalTomatoCnt = N*M - blank;// 총 토마토의 갯수 만큼 안바뀌면 -1을 반환 
		
		if(tomatoCnt==totalTomatoCnt) {//처음부터 익혀진 토마토랑 모든 토마토가 같다면 계산 하지말고 그냥 0리턴
			System.out.println(0);
			return;
		}
		
		bfs();
		
		System.out.println(dayCnt);
		
		br.close();
	}//main
	
	
	//토마토 후숙하기
	private static void bfs() {
		int[] temp= new int[]{0,0};//마지막 으로 후숙되는 녀석의 인덱스를 통해 몇 일이 걸렸는지 알기위해 밖에서 선언
		
		while(!queue.isEmpty()) {//queue가 빌 때 까지 진행 익은 토마토에 대해서 주변 익히기 하기
			temp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = temp[0]+delta[i][0];
				int ny = temp[1]+delta[i][1];
				if(((nx>=0&&nx<N) && (ny>=0&&ny<M)) && arr[nx][ny]==0) {
					arr[nx][ny]=arr[temp[0]][temp[1]]+1;//마지막날을 알기 위해 새로 익은 토마토에 숫자를 하나씩 증가하면서 대입
					tomatoCnt++;
					queue.offer(new int[] {nx,ny});
				}
			}
		}//while
		if(totalTomatoCnt==tomatoCnt) dayCnt = arr[temp[0]][temp[1]]-1;//원소(익은 토마토)1를 기준으로 날짜를 세기를 시작하기 때문에 마지막에 -1을 해주어야한다.
		else dayCnt = -1;
		
	}//bfs
	
}//class
