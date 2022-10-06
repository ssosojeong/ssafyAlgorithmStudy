package IMstudy;

import java.util.Scanner;

public class BOJ_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//학생수
		int K = sc.nextInt();//한 방 최대 인원
		int[][] std = new int[6][2];
		for(int i = 0; i < N; i++) {
			int s = sc.nextInt();//성별
			int g = sc.nextInt()-1;//학년
			std[g][s]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				int a = std[i][j];
				if(a > 0) {
					if(a <= K) cnt++;
					else if(a > K) {
						if(a%K == 0) cnt += a/K;
						else cnt+= a/K + 1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
