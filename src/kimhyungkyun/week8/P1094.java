//풀이 방법 : 


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
