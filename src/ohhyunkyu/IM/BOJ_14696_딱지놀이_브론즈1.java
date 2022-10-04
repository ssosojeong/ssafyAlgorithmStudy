package IMstudy;

import java.util.Scanner;

public class BOJ_14696_딱지놀이_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		outer: for(int i = 0; i < N; i++) {
			int[] arr = new int[5];
			int[] arr2 = new int[5];
			int a = sc.nextInt();
			for(int j = 0; j < a; j++) {
				int p = sc.nextInt();
				arr[p]++;
			}
			int b = sc.nextInt();
			for(int j = 0; j < b; j++) {
				int p = sc.nextInt();
				arr2[p]++;
			}
			for(int j = 4; j > 0; j--) {
				if(arr[j] > arr2[j]) {
					System.out.println("A");
					continue outer;
				}
				else if(arr[j] < arr2[j]) {
					System.out.println("B");
					continue outer;
				}
			}
			System.out.println("D");
		}
	}
}
