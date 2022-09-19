package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {
	static int[][] arr;
	static int neg,zero,pos;
	private static void divide(int N, int x, int y) { // x,y는 시작하는 인덱스
		int first = arr[x][y];//처음꺼 기준으로 같은지 비교
		int[][] d = {
				{0,0},{(N/3),0},{2*(N/3),0},
				{0,N/3},{(N/3),N/3},{2*(N/3),N/3},
				{0,2*(N/3)},{N/3,2*(N/3)},{2*(N/3),2*(N/3)}
				};
		
		boolean check = true;
		label : for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(first != arr[x+i][y+j]) {
					check = false;
					break label;
				}//if
			}//for
		}//for
		
		if(check && first==-1) neg += 1;
		else if (check && first==0) zero += 1;
		else if (check && first==1) pos += 1;
		else {
			for(int i=0;i<9;i++) {
				divide(N/3,x+d[i][0],y+d[i][1]);
			}//for
		}//if, else if
		
	}//divide
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for
		
		divide(N,0,0);
		
		System.out.printf("%d\n%d\n%d",neg,zero,pos);
		
		br.close();
	}//main

}//class
