package practice_1005;

import java.util.Scanner;

public class swea_10월5일_종이붙이기_4869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc =1;tc<=T;tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N/10 +1];
			arr[1] = 1; //1일때 3일때
			arr[2] = 3;
			for(int i = 3 ; i <= N/10;i++) { // 배열 채워넣기
				arr[i] = arr[i-1] + 2 *arr[i-2];
			}
			System.out.println("#"+tc+" "+arr[N/10]);
		}
	}

}
 