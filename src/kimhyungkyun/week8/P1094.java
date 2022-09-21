//풀이 방법 : 막대의 갯수를 이진수로 나타 냈을 때 1의 갯수로 표현할 수 있으므로 1의 갯수를 카운트 해주는 방법으로 해결


package study;

import java.util.Scanner;

public class P1094 {
	static int X; // 붙혀야할 막대의 갯수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		
		divide(64);//처음 가지고 있던 막대 길이
		
		sc.close();
	}//main
	
	private static void divide(int start) {
		int cnt = 0;
		for(int i=0;i<=6;i++) {
			if((X & (1<<i)) > 0 ) {
				cnt++;
			}//if
		}//for
		System.out.println(cnt);
	}//divide
}//class
