package practice_1004;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10월4일_딱지놀이_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {// tc
			int[] arrA = new int[5];// A 인덱스 1부터 4까지
			int[] arrB = new int[5];// B 인덱스 1부터 4까지

			int A = sc.nextInt();
			for (int i = 0; i < A; i++) { // A 딱지 인덱스에 개수저장
				arrA[sc.nextInt()]++;
			}
//			System.out.println(Arrays.toString(arrA));
			int B = sc.nextInt();
			for (int i = 0; i < B; i++) { // B 딱지 인덱스에 개수저장
				arrB[sc.nextInt()]++;
			}
//			System.out.println(Arrays.toString(arrB));

			for (int i = 4; i >= 1; i--) { // 딱지 비교해가면서 승부가르기
//				System.out.println(arrA[i]);
//				System.out.println(arrB[i]);
				if (arrA[i] > arrB[i]) {
					System.out.println("A");
					break;// 이미 결판이 났으면 나간다.
				} else if (arrA[i] < arrB[i]) {
					System.out.println("B");
					break;// 이미 결판이 났으면 나간다.
				} else {
					if(i == 1) {System.out.println("D");} //만약 1이라도 결판이 안나면 무승부
					continue;
				}
			}//승부 가르기

		} // tc
	}// main
}
