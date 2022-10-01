package practice0929;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_원재의메모리복구하기_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {//테케
			String str = sc.next();
			int count = 0;
			if (str.charAt(0) == '1') {//일단 맨처음거 1이면 카운트 세주고 시작
				count++;
			}
			for (int i = 1; i < str.length(); i++) {//두번째 숫자부터 앞에 숫자와 다르면 카운트 센다
				if (str.charAt(i) != str.charAt(i - 1)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}//테케

	}
}
