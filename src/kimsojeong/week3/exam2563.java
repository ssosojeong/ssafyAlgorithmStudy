package src.kimsojeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2563 {
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coloring(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		//색종이가 덮어진(값이 1인) 부분을 센다.
		int ans=0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]==1) ans++;
			}
		}
		
		System.out.println(ans);
		
		
		
	}
	
	//해당 색종이가 덮어질 위치의 값을 1로 변경한다.
	public static void coloring(int a, int b) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[a+i][b+j] = 1;
			}
		}
	}
}
