package week2;

import java.util.Scanner;

public class P10158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//width와 height 받기
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		//개미의 p,q값 받기
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		//개미가 이동할 시간
		int t = sc.nextInt();
		
		//개미가 가로벽에 부딪힐 횟수 countR
		//개미가 세로벽에 부딪힐 횟수 countC
		
		int countR = (p+t)/w; //홀수번 부딪히면 왼쪽으로 이동, 짝수번 부딪히면 오른쪽으로 이동
		int countC = (q+t)/h; //홀수번 부딪히면 아래로 이동, 짝수번 부딪히면 위쪽으로 이동
		
		int moveR = (p+t)%w;
		int x; //t초후 개미 위치의 x값
		if(countR==0){
			x = p+t;
		} else if (countR%2==1) {
			x = w-moveR;
		} else {
			x = moveR;
		}
		
		
		int moveC = (q+t)%h;
		int y; //t초후 개미 위치의 y값
		if(countC==0){
			y = q+t;
		} else if (countC%2==1) {
			y = h-moveC;
		} else {
			y = moveC;
		}
		
		System.out.printf("%d %d",x,y);
		
		sc.close();
	}
}
