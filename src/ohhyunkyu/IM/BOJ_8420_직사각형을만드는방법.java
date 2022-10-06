package IMstudy;

import java.util.Scanner;

public class BOJ_8420_직사각형을만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = N; //한줄
		for(int i = 2; i < N/2; i++) {
			for(int j = i; j <= N/2; j++) {
				if(i*j <= N) cnt++;
			}
		}
		System.out.println(cnt);
	}
}