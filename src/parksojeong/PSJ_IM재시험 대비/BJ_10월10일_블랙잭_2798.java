package practice_1010;

import java.util.Scanner;

public class BJ_10월10일_블랙잭_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 전체 카드의 개수
		int M = sc.nextInt();// 딜러가 부르는 수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {// 배열에 입력값을 받는다.
			arr[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {//세개 뽑아서
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];

					if (sum <= M) {//만약 M 이하라면 맥스값을 도출한다.
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);

	}

}
