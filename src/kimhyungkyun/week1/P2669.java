package studybaek;

import java.util.Scanner;

public class P2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//xy평면 만들기
		int[][] plane = new int[100][100];
		
		//4개의 사각형을 받아주기 위한 for문
		int N = 4;
		for (int i=0;i<N;i++) {
			
			//입력 받은 값 행렬의 인덱스로 변환
			int xLeftBottom = sc.nextInt();
			int yLeftBottom = sc.nextInt();
			int xRightTop = sc.nextInt();
			int yRightTop = sc.nextInt();
			
			int colStart = xLeftBottom;
			int colEnd = xRightTop;
			int rowStart = 99-yLeftBottom;
			int rowEnd = 99-yRightTop;
			
			
			//직사각형들이 덮은 영역을 1로 표현 
			for(int m=rowEnd+1;m<=rowStart;m++) {
				for(int n=colStart;n<colEnd;n++) {
					plane[m][n]=1;
				}
			}
			
			
		}
		
		// 평면 중 1로 덮힌 부분의 넓이를 구하기
		int count=0;
		for (int m=0;m<100;m++) {
			for (int n=0;n<100;n++) {
				if (plane[m][n]==1) count++;
			}
		}
		
		System.out.println(count);
		
		
		sc.close();
	}
	
}
