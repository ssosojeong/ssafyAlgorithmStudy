package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {

	static int blueCnt , whiteCnt;
	static int[][] arr;
	
	private static void divide(int size, int x, int y) {
		int getColor = arr[x][y];// 시작 기준 색 정하기 1(blue) , 0(white)
		boolean check=true;
		label : for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(getColor != arr[x+i][y+j]) {
					check = false;
					break label;
				}//if
			}//for
		}//for
		
		if(check && getColor==1) blueCnt += 1;
		else if(check && getColor==0) whiteCnt += 1;
		else {
			divide(size/2, x, y);
			divide(size/2, x+size/2, y);
			divide(size/2, x, y+size/2);
			divide(size/2, x+size/2, y+size/2);
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {//2차원 배열 값 대입
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for
		
		////////////////////입력값 받기 끝
		divide(N,0,0);
		
		System.out.printf("%d\n%d",whiteCnt,blueCnt);
		
		br.close();
	}//main
}//class
//오현규: 풀이 방법이 소정님 것과 유사하네요! 제 풀이와는 조금 달라서 보고 공부해 보겠습니다.
