package dh;

import java.util.Scanner;

public class swea숫자회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[][] graph = new String[N][N];
			String[][] newGraph = new String[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					graph[r][c] = sc.next();
//					System.out.println(graph[r][c]); //확인
				}
			}
			
			//90도 
			for(int r=0;r<N ;r++) {
				for(int c=0;c<N;c++) {
					newGraph[r][0] += graph[N-1-c][r];
				}
			}
			
			//180도
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					newGraph[r][1] += graph[N-1-r][N-1-c];
				}
			}
			
			//270도
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					newGraph[r][2] += graph[c][N-1-r];
				}
			}
			//출력
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					System.out.print(newGraph[r][c]+" ");
				}
				System.out.println();
			}
		}// tc
	}
}
