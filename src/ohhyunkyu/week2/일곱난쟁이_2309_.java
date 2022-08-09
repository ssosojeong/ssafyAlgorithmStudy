package week2;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] small = new int[9]; // 아홉 난쟁이들의 키 배열.
		int sum = 0; // 난쟁이들의 키의 합.

		for (int i = 0; i < 9; i++) {
			small[i] = sc.nextInt();
			sum += small[i];
		} // 우선 9인의 키를 모두 더한 값 생성.

		for (int i = 0; i < 8; i++) { // 9가 아니고 8이어야 함. 아래 j의 범위 고려.
			for (int j = i + 1; j < 9; j++) {
				if (sum - (small[i] + small[j]) == 100) { // 합에서 두 명의 키를 뺀다.
					small[i] = 0;
					small[j] = 0;
					Arrays.sort(small);
					for (int k = 0; k < 9; k++) {
						if(small[k] != 0) {
							System.out.println(small[k]);
						} // 0이 아닌 값(일곱 난쟁이의 키) 출력.
					}
					return; // 결과 도출 후 반복문 종료.
				}
			}
		}
	} // main
} // class
