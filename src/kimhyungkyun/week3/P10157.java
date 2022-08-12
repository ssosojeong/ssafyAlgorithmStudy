package algorithmstudy;

import java.util.Scanner;

public class P10157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();//세로(행)
		int C = sc.nextInt();//가로(열)
		int K = sc.nextInt();
		
		int[][] arr = new int[R][C];
		
		
		//왼쪽 아래부터 달팽이 식으로 값 대입
		int[] dr = {-1,0,1,0}; //상우하좌 탐색
		int[] dc = {0,1,0,-1}; //상우하좌 탐색
		int direction = 0;
		int indexR = R-1;
		int indexC = C-1;
		int num=1; // 배열 안에 대입할 값
		while(num<=R*C) { //돌아가면서 값 대입
			
			arr[indexR][0]=num++;
			indexR += dr[direction];
			
		}
		sc.close();
	}
}
