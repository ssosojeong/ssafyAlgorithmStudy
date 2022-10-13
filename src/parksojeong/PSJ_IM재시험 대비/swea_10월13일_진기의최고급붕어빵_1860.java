package practice_1013;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10월13일_진기의최고급붕어빵_1860 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();// N명의 사람들이 온다
			int M = sc.nextInt();// M초의 시간을 들이면
			int K = sc.nextInt();// k개의 붕어빵을 만든다.
			int[] arr = new int[11112];// 초를 인덱스로 사람오는거 카운팅배열

			for (int i = 0; i < N; i++) {// 사람들이오는 초 저장
				arr[sc.nextInt()]++;
			}

			int fish = 0;
			boolean isPossible = true;

			for (int i = 0; i <= 11111; i++) {
				if (i != 0 && i % M == 0) {
					fish += K;
				}
				if (arr[i] == 0) {
					continue;
				}
//				System.out.println(fish);
				fish -= arr[i];
//				System.out.println(fish);
				if (fish < 0) {
					isPossible = false;
					break;
				}

			}
			if (isPossible) {
				System.out.println("#" + tc + " " + "Possible");
			} else {
				System.out.println("#" + tc + " " + "Impossible");
			}

		}
	}
}
