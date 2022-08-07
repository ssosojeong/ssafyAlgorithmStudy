package week2;

import java.util.*;
import java.io.*;

public class Q2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] h = new int[9]; // 난쟁이는 9명
		int sum = 0;
		for (int i = 0; i < 9; i++) { // 각각 난쟁이의 키를 입력받고, sum에 다 더해줌.
			h[i] = Integer.parseInt(br.readLine());
			sum += h[i];
		}
		sum = sum - 100; // 7명의 합이 100이므로 9명을 더하고 100을 빼면 2명의 키 합이 나옴.
		int[] ans = new int[7];
		end: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				int hSum = h[i] + h[j];
				if (hSum == sum) {
					for (int k = 0, cnt = 0; k < 9; k++) {
						if (k != i && k != j) {
							ans[cnt++] = h[k];
						}
					}
					break end;
				}
			}
		}
		Arrays.sort(ans);
		for (int i : ans) {
			System.out.println(i);
		}
	}
}