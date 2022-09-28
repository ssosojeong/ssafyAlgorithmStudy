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

//N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
//
//우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
//
//예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 예를 들어, 아래와 같은 식을 만들 수 있다.
//
//1+2+3-4×5÷6
//1÷2+3+4-5×6
//1+2÷3×4-5+6
//1÷2×3-4+5+6
//식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.
//
//1+2+3-4×5÷6 = 1
//1÷2+3+4-5×6 = 12
//1+2÷3×4-5+6 = 5
//1÷2×3-4+5+6 = 7
//N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.