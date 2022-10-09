package practice_1009;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10월9일_안경이없어_7272 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();

			if (str1.length() != str2.length()) {
				System.out.println("#" + tc + " " + "DIFF");
				continue;
			}

			int[] arr1 = new int[str1.length()];
			int[] arr2 = new int[str2.length()];

			for (int i = 0; i < str1.length(); i++) {
				// 만약 구멍이 하나면 1로 표시하고 2개면 2로 표시 나머지는 자동으로 0
				if (str1.charAt(i) == 'A' || str1.charAt(i) == 'D' || str1.charAt(i) == 'O' || str1.charAt(i) == 'P'|| str1.charAt(i) == 'Q' || str1.charAt(i) == 'R') {
					arr1[i] = 1;

				} else if (str1.charAt(i) == 'B') {
					arr1[i] = 2;
				}
			} // str1 구멍의 수 배열에 정리
			for (int i = 0; i < str2.length(); i++) {
				// 만약 구멍이 하나면 1로 표시하고 2개면 2로 표시 나머지는 자동으로 0
				if (str2.charAt(i) == 'A' || str2.charAt(i) == 'D' || str2.charAt(i) == 'O' || str2.charAt(i) == 'P' || str2.charAt(i) == 'Q' || str2.charAt(i) == 'R') {
					arr2[i] = 1;

				} else if (str2.charAt(i) == 'B') {
					arr2[i] = 2;
				}
			} // str2 구멍의 수 배열에 정리

			if (Arrays.toString(arr1).equals(Arrays.toString(arr2))) {// 출력
				System.out.println("#" + tc + " " + "SAME");
			} else {
				System.out.println("#" + tc + " " + "DIFF");
			}
		} // tc
	}// main

}// class
