package IMstudy;

import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int total = sc.nextInt();
		int[][] chg = new int[total][2];
		for (int i = 0; i < total; i++)
			for (int j = 0; j < 2; j++)
				chg[i][j] = sc.nextInt();
		
		// 학생 수만큼 반복
		for (int i = 0; i < total; i++) {
			// 남학생
			if (chg[i][0] == 1) {
				int m = 1;
				while (true) {
					int a = chg[i][1];
					int b = a * m - 1;
					
					if (N <= b)
						break;
					if (arr[b] == 1)
						arr[b] = 0;
					else
						arr[b] = 1;
					m++;
				}
			}
			
			// 여학생
			else {
				int cnt = 0;
				while (true) {
					int a = chg[i][1]-1;
					int am = a - cnt;
					int ap = a + cnt;
					if(am < 0 || ap >= N)
						break;
					if(arr[am] != arr[ap])
						break;
					if (arr[am] == 1) {
						arr[am] = 0;
						arr[ap] = 0;
					} else {
						arr[am] = 1;
						arr[ap] = 1;
					}
					cnt++;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if ((i + 1) % 20 == 0) {
				System.out.println(arr[i]);
			}else {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
