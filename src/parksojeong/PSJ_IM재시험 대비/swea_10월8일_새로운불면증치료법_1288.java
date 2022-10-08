package practice_1008;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10월8일_새로운불면증치료법_1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[10];
			int x = 1;

			while (true) {
				// 곱한 결과값을 문자열로 변환해서 charAt을 통해 한자한자를 idx로 카운팅배열에 기록한다.
				String str = Integer.toString(N * x);
				for (int i = 0; i < str.length(); i++) {
					arr[str.charAt(i) - '0']++;
				}
				// isContinue가 false였다가 만약 0이 존재하면 true로 바뀌고 여전히 false라면 무한루프를 종료한다.
				boolean isContinue = false;
				for (int i = 0; i < 10; i++) {
					if (arr[i] == 0) {
						x++; // 다음 곱하는 수를 늘려준다.
						isContinue = true;
						break;
					}
				}
				if (!isContinue) {
					break;
				}

			} // 무한루프
			System.out.println("#" + tc + " " + x * N);// 양을 세는 수는 x가 아니라 x*N임을 유의한다.
		} // tc
	}

}
