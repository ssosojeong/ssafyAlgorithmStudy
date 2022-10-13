package IMstudy;

import java.util.Scanner;

public class BOJ_2564_경비원_실버1 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int W = sc.nextInt();//가로
		 int H = sc.nextInt();//세로
		 int N = sc.nextInt();//상점 수
		 int[] arr = new int[N+1];//경계선으로 위치를 직선화해 담을 것
		 for(int i = 0; i < N + 1; i++) {
			 int d = sc.nextInt();//방향 확인
			 switch (d) {
			 case 1://북
				 arr[i] = W-sc.nextInt();
				 break;
			 case 2://남
				 arr[i] = sc.nextInt()+W+H;
				 break;
			 case 3://서
				 arr[i] = sc.nextInt()+W;
				 break;
			 case 4://동
				 arr[i] = 2*(W + H)-sc.nextInt();
				 break;
			 }
		 }
		 
		 int ans = 0;
		 //동근이 위치와 비교. 동근은 arr[N]에 위치.
		 for(int i = 0; i < N; i++) {
			 int a = Math.abs(arr[N] - arr[i]);
			 int b = Math.abs(2*(W+H) - a);
			 ans += Math.min(a, b);
		 }
		 
		 System.out.println(ans);
	}
}
