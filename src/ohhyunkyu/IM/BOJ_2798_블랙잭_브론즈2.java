package IMstudy;

import java.util.Scanner;

public class BOJ_2798_블랙잭_브론즈2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int tmp = arr[i] + arr[j] + arr[k];
					if(tmp <= M) ans = Math.max(ans, tmp);
				}
			}
		}
		System.out.println(ans);
	}
}
