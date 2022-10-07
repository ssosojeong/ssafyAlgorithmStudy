package october_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10월7일_일곱난쟁이_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];//9명 키를 저장할 배열
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];//전체 키의 합을 sum으로 만듦
		}
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);// 오름차순 정렬
		int idx1 = 0 ; int idx2 = 0; // 임의로 뺄 두명의 난쟁이 키를 담을 변수 선언
		outer: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {//만약 전체에서 두개의 인덱스의 합을 뺄때 100이면
					idx1 = i ; idx2 = j; // 각 인덱스를 저장후 나간다.
					break outer;
				}
			}
		}
		
		for (int k = 0; k < 9; k++) { // 두개 인덱스를 제외하고 출력한다.
			if (k != idx1 && k != idx2) {
				System.out.println(arr[k]);
			}
		}
	}

}
