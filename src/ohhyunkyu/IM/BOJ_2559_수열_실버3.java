package IMstudy;

import java.util.Scanner;

public class BOJ_2559_수열_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		int ans = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(i >= K-1) {
				int tmp = 0;
				for(int j = 0; j < K; j++) tmp += arr[i-j];
				ans = Math.max(ans, tmp);
			}
		}
		System.out.println(ans);
	}
}
