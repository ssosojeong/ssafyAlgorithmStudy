package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2667 {
	static int N;
	static char[][] arr;
	static boolean[][] v;//방문을 했는지 확인하기 위한 변수
	static ArrayList<Integer> count;//각 단지에 몇 개의 집이 있는지 나타내줄 변수
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	static int session;
	static int counting;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			arr[i] = temp.toCharArray();
		}//2차원 배열 받기
		session = 1;//몇 개의 단지가 있는지 나타내줄 변수
		v = new boolean[N][N];

		count = new ArrayList<>();
		
		for(int i=0;i<N;i++) {//모든 지점에 대해서 1과 true인 곳을 dfs를 통해서 체크
			for(int j=0;j<N;j++) {
				if(!v[i][j]&&arr[i][j]=='1') {
					counting = 0;
					dfs(i,j);
					count.add(counting);
					session++;
				}
			}//for
		}//for
		
		count.sort(null);//집의 수를 오름차순으로 정렬하라고 했으니까
		count.add(0, session-1); //0은덱스는 사용안하니까 몇 개의 동이 있는지 나타낼 때 사용
		
		
		
		for(int i=0;i<count.size();i++) {//출력
				System.out.println(count.get(i));
		}//for
		
		br.close();
	}//main
	private static void dfs(int i, int j) {
		if(!v[i][j]&&arr[i][j]=='1') {//방문한 곳은 true로 하여 재방문하지 않한다.
			v[i][j]=true;
			arr[i][j]=(char)(session + '0');
			counting++;
			for(int n=0;n<4;n++) {
				if(i+dc[n]>=0 && i+dc[n]<N && j+dr[n]>=0 && j+dr[n]<N) {
					dfs(i+dc[n],j+dr[n]);
				}//if
			}//for
		}//if
		//여기서 v기록 수정하고
		//그냥 들어온 session 값증가는 신경 쓰지 말고 사용만 해주면 된다.
		//만약에 char(1)이고 v가 false인 곳은 true로 바꿔주고 값을 session으로 교환해주면 된다.
	}//dfs
}//class
