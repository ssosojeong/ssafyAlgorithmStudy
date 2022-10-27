package week11;

import java.util.Scanner;

public class BOJ_15710_xor게임_골드5 {
	static int a, b, n;
	static int mod = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		//나머지 연산 특성 이용
		long ans = pow((long) Math.pow(2, 31), n-1);
		
		System.out.println(ans);
	}

	static long pow(long r, int nn) {
		if(nn == 0) return 1;
		//미리 내부에서 나눗셈을 해줘야 값이 터지지 않음
		if(nn%2==0) {
			long tmp = pow(r, nn/2)%mod;
			return tmp*tmp%mod;
		}
		else return r*pow(r, nn-1)%mod;
	}
}
//분할정복 거듭제곱 방식을 활용.
//xor 개념 숙지.
//처음의 a에서 xor연산을 이용해 0부터 2^31-1 까지 다 될 수 있음.
//마지막에만 b로 변하면 되는 것.(n번째 턴)