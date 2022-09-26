package week8;

import java.util.Scanner;

public class BOJ_1094_막대기_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // 목표 길이
//		int stick = 64; // 주어진 막대 길이
		int cnt = 0; // 필요한 막대 개수
		// 비트 마스킹으로 몇 개의 막대가 필요한지 구할 것
		// stick은 2의 6승이고 X는 stick보다 작거나 같은 자연수
		for (int i = 0; i <= 6; i++) {
			if ((X & (1 << i)) > 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
