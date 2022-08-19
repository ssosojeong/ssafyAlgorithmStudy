package src.kimsojeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//공통부분의 특성 생각해보기
//	-> x1, y1, p1, q1 & x2, y2, p2, q2가 있을 때
//1. 직사각형의 경우
//	-> 남는거
//2. 선분의 경우
//	-> p1==x2 / q1==y2 / p2==x1 / q2==y1
//	-> 근데 점은 겹치면 안됨 
//3. 점의 경우
//	-> 각 직사각형의 4가지 꼭지점 좌표중 맞은편이 겹쳐야됨
//4. 공통부분이 없는 경우 
//	-> p1<x2 / q1<y2 / p2<x1 / q2<y1 넷 중 하나만 돼도

public class exam2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=4; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			char ans;
			
			//안겹칠 때 -> 서로 닿지 않게 범위를 벗어나야함
			if((p1<x2) || (q1<y2) || (p2<x1) || (q2<y1) ) {
				ans = 'd';
			}
			//점이 겹칠 때 
			else if((x1==p2 && y1==q2) || (p1==x2 && y1==q2) || (p1==x2 && q1==y2) || (x1==p2 && q1==y2) ) {
				ans = 'c';
			}
			//선이 겹칠 때 
//			else if( ((p1==x2) && (q1!=y2)) || (y1==q2) &&  ) {
//				ans = 'b';
//			} 
			//직사각형으로 겹칠 때
			else {
				ans = 'a';
			}
			
			System.out.println(ans);
			
		}
	}
}
