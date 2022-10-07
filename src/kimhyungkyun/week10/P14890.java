package study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {
	static int[][] map,mapClone;
	static boolean[][] vRow, vCol;//이미 쌓은 곳은 중복해서 쌓을 수가 없으니까 true가 된 곳은 더 건드리지 않게하기
	static int N, L, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}//for
		
		///////////////////입력값 받기 끝
		
		mapClone = map.clone();
		vRow = new boolean[N][N];
		vCol = new boolean[N][N];
		
		
		cnt = 0;
		for(int i=0;i<N;i++) {
			checkRow(i);//전체 행 돌면서 길로 사용할 수 있는지 체크
			checkCol(i);//전체 열 돌면서 길로 사용 가능한지 체크
		}//for

		//행에 길이 있는비교하고 나서 원래 가지고 있던 2차원 행렬이 값을 제대로 가지지 않기 때문에 복사본은 mapClone으로 행처럼 열을 검사해주면된다
		
		System.out.println(cnt);
		
		
		br.close();
	}//main

	

	private static void checkRow(int i) {
		//모든 행을 i로 돌면서 순회
		for(int j=0;j<N-1;j++) {
			int jVal = map[i][j];
			int jPlusVal = map[i][j+1];
			
			if(jVal==jPlusVal) continue;
			else if(jVal+1==jPlusVal) {//다음 열에 있는 블럭이 한 단계 높을 때
				for(int l=0;l<L;l++) {
					int newJ = j-l;
					if (newJ<0 || vRow[i][newJ]) return;//만약에 L개 만큼의 블럭을 세우지 못하면 이 길은 지나갈 수 없는 것이므로 더 보지 않고 return 그리고 이미 블럭을 쌓은 곳에 또 쌓아야 하는 경우면 pass
					if(map[i][newJ]+1==jPlusVal) vRow[i][newJ] = true; //뒤에 체크할 때는 boolean을 안 건드려 줘도 됌 하고 난건 신경 안쓰지 때문
					else return;//그 외 나머지 경우는 무조건 길이 될 수 없는 경우 이므로 return
				}
			}//else if
			else if(jVal-1==jPlusVal) {//다음 열에 있는 블럭이 한 단계 낮은 경우
				for(int l=1;l<=L;l++) {
					int newJ = j+l;
					if (newJ>=N) return;//앞 부분에 대해서는 vRow체크를 할 필요가 없기 때문에
					if(map[i][newJ]+1==jVal) vRow[i][newJ] = true;
					else return;
				}//for
			}//else if
			else return; //같거나 1만큼 차이나거나가 아니면 경사로 짓기 불가
		}//for
		//여기까지 return 안되고 잘 왔다는 것은 한 줄에 대해 길이 된다는 의미
		cnt++;
	}//checkRow
	
	
	private static void checkCol(int i) {
		//모든 열을 i로 돌면서 순회
		for(int j=0;j<N-1;j++) {
			int jVal = mapClone[j][i];
			int jPlusVal = mapClone[j+1][i];
			if(jVal==jPlusVal) continue;
			else if(jVal+1==jPlusVal) {//다음 행에 있는 블럭이 한 단계 높을 때
				for(int l=0;l<L;l++) {
					int newJ = j-l;
					if (newJ<0 || vCol[newJ][i]) return;//만약에 L개 만큼의 블럭을 세우지 못하면 이 길은 지나갈 수 없는 것이므로 더 보지 않고 return 그리고 이미 블럭을 쌓은 곳에 또 쌓아야 하는 경우면 pass
					if(mapClone[newJ][i]+1==jPlusVal) vCol[newJ][i] = true;
					else return;//그 외 나머지 경우는 무조건 길이 될 수 없는 경우 이므로 return
				}
			}//else if
			else if(jVal-1==jPlusVal) {//다음 행에 있는 블럭이 한 단계 낮은 경우
				for(int l=1;l<=L;l++) {
					int newJ = j+l;
					if (newJ>=N) return;//앞 부분에 대해서는 vRow체크를 할 필요가 없기 때문에
					if(mapClone[newJ][i]+1==jVal) vCol[newJ][i] = true;
					else return;
				}//for
			}//else if
			else return; //같거나 1만큼 차이나거나가 아니면 경사로 짓기 불가
		}//for
		//여기까지 return 안되고 잘 왔다는 것은 한 줄에 대해 길이 된다는 의미
		cnt++;
	}//checkCol
}//class
