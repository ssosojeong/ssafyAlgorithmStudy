package IMstudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		int a = -1;
		int b = -1;
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				if(sum - (arr[i] + arr[j]) == 100) {
					a = i;
					b = j;
				}
			}
		}
		for(int i = 0; i < 9; i++) {
			if(i == a || i == b) continue;
			System.out.println(arr[i]);
		}
	}
}
