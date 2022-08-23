package week4;

import java.util.Scanner;

public class BOJ_2477_참외밭_실버3_재시도 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // 1<=K<=20 단위 참외 수

		// ㄱ형의 밭이라고 했으므로 기본적으로 직사각형을 이용
		// 가로방향 선 3개, 세로방향 선 3개 존재 -> 총 6개의 선
		// 큰 사각형에서 작은 사각형의 넓이를 빼서 결과를 찾을 것
		// 가장 긴 선 기준으로 찾기

		int[] D = new int[6]; // 방향
		int[] L = new int[6]; // 선 길이

		D[0] = sc.nextInt();
		L[0] = sc.nextInt(); // 비교를 위해 첫 줄 입력해두기

		int maxIdx = 0; // 가장 긴 선의 인덱스

		for (int i = 1; i < 6; i++) {

			D[i] = sc.nextInt();
			L[i] = sc.nextInt(); // 선 입력

			if (L[i] > L[maxIdx]) {
				maxIdx = i;
			} // 가장 긴 선의 인덱스 구함
		}

		int a = 0, b = 0; // 작은 사각형의 한 변 구하기 위한 변수. a, b가 같은 경우는 없음.
		int c = 0; // 작은 사각형의 다른 한 변. a, b 중 작은 것과 직접 연결된 변.

		if (maxIdx != 0 && maxIdx != 5) {
			a = L[maxIdx - 1];
			b = L[maxIdx + 1];

		} else if (maxIdx == 0) {
			a = L[5];
			b = L[1];
		} else { // maxIdx == 5
			a = L[4];
			b = L[0];
		}

		// c 구하기
		if (a < b) {
			if (maxIdx == 1) {
				c = L[5];
			} else if (maxIdx == 0) {
				c = L[4];
			} else if (maxIdx == 5) {
				c = L[3];
			} else {
				c = L[maxIdx - 2];
			}

		} else if (a > b) {
			if (maxIdx == 4) {
				c = L[0];
			} else if (maxIdx == 0) {
				c = L[2];
			} else if (maxIdx == 5) {
				c = L[1];
			} else {
				c = L[maxIdx + 2];
			}
		}

		if (a < b) {
			System.out.println((L[maxIdx] * b - (b - a) * c)*K);
		} else {
			System.out.println((L[maxIdx] * a - (a - b) * c)*K);
		}

	} // main
} // class
