package week8;

import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기_실버1 {
	static int N;
	static int[] num;
	static int[] oper;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for(int i = 0; i < N; i++) num[i] = sc.nextInt();
		oper = new int[4]; // + - * /
		for(int i = 0; i < 4; i++) oper[i] = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE; 
		
		//인덱스(0번째는 넣고 시작), 현재 연산 결과(연산자 우선 순위 없이 왼쪽부터 진행이므로 num[0]로 시작
		calc(1, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int idx, int res) {
		//피연산자를 다 사용하고 나면 결과 리턴
		if(idx == N) {
			//결과가 일치하는 경우까지 고려하여 등호 사용
			max = res >= max ? res : max; 
			min = res <= min ? res : min; 
			return;
		}
		
		// 연산자 종류만큼 반복
		for(int i = 0; i < 4; i++) {
			if(oper[i] != 0) {
				//지정된 연산자 한 개를 줄이고 넘어가기
				oper[i]--;
				
				switch (i) {
				case 0:
					calc(idx+1, res + num[idx]);
					break;
				case 1:
					calc(idx+1, res - num[idx]);
					break;
				case 2:
					calc(idx+1, res * num[idx]);
					break;
				case 3:
					calc(idx+1, res / num[idx]);
					break;
				default:
					break;
				}
				
				//돌아왔을 때 연산자 복구
				oper[i]++;
			}
		}
	}
}
