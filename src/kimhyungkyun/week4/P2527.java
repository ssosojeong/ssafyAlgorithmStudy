package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2527 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=4;tc++) {

			StringTokenizer xypq = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(xypq.nextToken());
			int y1 = Integer.parseInt(xypq.nextToken());
			int p1 = Integer.parseInt(xypq.nextToken());
			int q1 = Integer.parseInt(xypq.nextToken());
			int x2 = Integer.parseInt(xypq.nextToken());
			int y2 = Integer.parseInt(xypq.nextToken());
			int p2 = Integer.parseInt(xypq.nextToken());
			int q2 = Integer.parseInt(xypq.nextToken());
			///////////////////////////////////////////////////////////필요한 입력값 받기 끄읕!
			
			if((p1<x2 || p2<x1) || (q1<y2 || q2<y1)) { //서로 만나지 않는 경우
				System.out.println('d');
			} else if((x1==p2&&y1==q2)||(p1==x2&&y1==q2)||(p1==x2&&q1==y2)||(x1==p2&&y2==q1)) { //한 점에서 만날 경우 4가지 경우
				System.out.println('c');
			} else if((y1==q2&&(x1<p2&&x2<p1)) || (y2==q1&&(x2<p1&&x1<p2)) || (x1==p2&&(q2>y1&&y2<q1)) || (x2==p1&&(q2>y1&&y2<q1))) { //선분을 가질 경우 4가지 경우(앞에 2개는 x축과 평행한 선분이 생길 때 뒤에 2개는 y축에 평행)
				System.out.println('b');
			} else {//나머지
				System.out.println('a');
			}
			
		} //테스트 케이스가 4개라고 생각
		br.close();
	}
	
}
