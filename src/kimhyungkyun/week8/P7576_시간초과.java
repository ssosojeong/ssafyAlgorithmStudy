package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P7576_시간초과 {
	static int N,M;//NxM배열 받기
	static int dayCnt;//후숙 되려면 몇 일 걸리는지
	static int[][] arr;//NxM배열
	static boolean[][] v;//방문한 곳을 기록할 2차원 배열
	static int tomatoCnt;//익은 토마토를 저장할 변수
	static int totalTomatoCnt; //모든 토마토의 갯수
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};//익은 토마토 근처를 조사하기 위한 델타
	static List<int[]> list;
	
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
				else if(arr[i][j]==0) v[i][j] = true;
				else tomatoCnt++;//익은 토마토 갯수 카운트
				//안익은 토마토는 bfs를 못 돌게 true로 해서 막아둬야 익은 토마토에 의해 다른 토마토를 익히는 경우를 방지할 수 있다.
			}//for
		}//for
		
		////////////////////////////입력값 받기 끝
		
		dayCnt=0;
		totalTomatoCnt = N*M - blank;// 총 토마토의 갯수 만큼 안바뀌면 -1을 반환 
		
		bfs();
		
		System.out.println(dayCnt);
		
		br.close();
	}//main
	
	
	
	
	//토마토 후숙하기
	private static void bfs() {
		
		int preTomatoCnt = -1;//반복문을 돌 때 반복문을 돌았을 때랑 돌기전이랑 바뀐 익은 토마토 양이 똑같으면 얘는 더 이상 익을 수 없다는 의미니까 retrun -1;
		while(tomatoCnt!=totalTomatoCnt) {//전체 토마토 갯수가 익은 토마토 갯수 일 때 까지 반복하기
			if(preTomatoCnt == tomatoCnt) {
				dayCnt = -1;
				return;
			}//if
			
			list = new ArrayList<>();//새롭게 숙성된 토마토는 false로 다시 바꿔줘야 bfs를 돌 수 있기 때문에 인덱스를 저장해줄 2차원배열
			preTomatoCnt = tomatoCnt;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					/////////////////////////////////////////////////////////////////////////////////
					if(arr[i][j]==1 && !v[i][j]) {
//						v[i][j]=true;//주변을 물 들인 토마토는 또 체크 해줄 필요 없으니까 true로 값 변경해주기
						for(int d=0;d<4;d++) {
							int nx = i+delta[d][0];
							int ny = j+delta[d][1];
							boolean bound = (nx>=0 && nx<N) && (ny>=0 && ny<M);
							if(bound && arr[nx][ny]==0 ) {
								arr[nx][ny]=1;//익은 토마토로 바꿔주기
								int[] temp = {nx, ny};
								list.add(temp);
								tomatoCnt++;//익은 토마토의 갯수가 늘어 났으니까 카운트
							}//if
						}//for
					}//if
					/////////////////////////////////////////////////////////////////////////////////
				}//for
			}//for
			for(int i=0;i<list.size();i++) {
				int x = list.get(i)[0];
				int y = list.get(i)[1];
				v[x][y] = false;
			}//for
			
			dayCnt++;
			
		}//while
	}//bfs
}//class
