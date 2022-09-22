package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
	static int[][] arr;
	static int minValue;
	static int N;
	static int[] checkInt;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for
		
		//////////////////////입력값 받기 끝
		
		minValue=Integer.MAX_VALUE;
		checkInt = new int[N/2];//S팀으로 뽑을 선수의 인덱스
		
		combination(0,0);
		
		System.out.println(minValue);
		
		br.close();
	}//main
	
	private static void combination(int cidx, int idx) {
		if(cidx==N/2) {
			check = new boolean[N];
			int sumS = 0;
			int sumL = 0;
			for(int i=0;i<N/2;i++) {
				check[checkInt[i]] = true;
			}//for
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					if(check[i] && check[j]) sumS += (arr[i][j]+arr[j][i]);
					else if (!check[i] && !check[j]) sumL += (arr[i][j] + arr[j][i]);
				}//for
			}//for
			int res = Math.abs(sumS-sumL);
			if(minValue>res) minValue = res;
			return;
		} else if(idx==N) return;
			
		checkInt[cidx]=idx;
		combination(cidx+1,idx+1);
		combination(cidx,idx+1);
		
	}//combination
}//class
