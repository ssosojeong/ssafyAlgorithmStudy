package october_Practice;

import java.util.Scanner;

public class BJ_10월6일_직사각형을만드는방법_8320 {
//다시 풀어보기 답지봤다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		for (int i = 1; i <= n; i++) { // 가로길이
			for (int j = i; i * j <= n; j++) {// 세로길이가 중복되지 않게 늘어난다. 곱이 n이하인 상에서
				count++;
			}
		}
		System.out.println(count);

	}

}
