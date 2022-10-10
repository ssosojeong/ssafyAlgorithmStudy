package practice_1010;

import java.util.Scanner;

public class swea_10월10일_문제제목붙이기_7087 {

	public static void main(String[] args) {
		// 65가 A 90이 Z (26개) 97이 a 122가 z
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] arr = new int[26];// 알파벳 카운팅배열

			for (int i = 0; i < N; i++) {
				String str = sc.next();
//				System.out.println(str.charAt(0)-65);
				arr[str.charAt(0) - 65]++;
			} // 첫번째 글자의 배열 인덱스에 1을 추가해준다.끝

			int ans = 0;
			for (int i = 0; i < 26; i++) {
				if (arr[i] == 0) {// 중간에 0이나오면 해당 알파벳순번 -1까지니까 인덱스로치면된다.
					ans = i;
					break;
				}
				if (i == 25) {// 인덱스가끝까지 돌면 답은 26이다.
					ans = 26;
				}
			}

			System.out.println("#" + tc + " " + ans);

		} // tc

	}// main
}
