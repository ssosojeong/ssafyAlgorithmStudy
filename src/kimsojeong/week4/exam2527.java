package src.kimsojeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//공통부분의 특성 생각해보기
//	-> x1, y1, p1, q1 & x2, y2, p2, q2가 있을 때
//1. 직사각형의 경우
//2. 선분의 경우
//	-> p1=x2 / q1=y2 / p2=x1  q2=y1
//3. 점의 경우
//	-> 각 직사각형의 꼭지점 좌표가 같을때.. -> 16경우?!?!?!
//	-> 선분이 된 상황에서
//	-> p1=x2에서 q1=y2거나 
//4. 공통부분이 없는 경우 
//	-> p1<x2 / q1<y2 / p2<x1 / q2<y1 넷 중 하나만 돼도








public class exam2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		
		for(int t=1; t<=4; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
		
			
			
			
		}
		
		
	}

}
