package IMstudy;

import java.util.Scanner;

public class SWEA_1940_가랏RC카_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			//N초 동안 받으면서 동시 처리 //현재 속도 연산 후 더하기
			int dist = 0;//이동 거리
			int cv = 0;//현재 속도
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				if(a == 0) dist += cv;
				else if(a == 1) {
					cv += sc.nextInt();
					dist += cv;
				}
				else {
					cv -= sc.nextInt();
					if(cv < 0) cv = 0;
					dist += cv;
				}
			}
			
			System.out.println("#" + t + " " + dist);
		}//T
	}
}
