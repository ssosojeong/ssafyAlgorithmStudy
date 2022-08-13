package week3;

import java.io.*;
import java.util.*;

public class Q2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		int max = 0;
		//증가수열인경우
		for (int i = 1; i < N; i++) {
			if (arr[i] >= arr[i - 1]) {
				cnt++;
			} else {
				if (cnt > max) {
					max = cnt;
				}
				cnt = 1;
			}

		}
		//마지막에 cnt를 max와 비교를 안해주고 for문이 끝날 수도 있다.
		if (cnt > max) {
			max = cnt;
		}
		cnt = 1; // cnt 초기화
		//감소수열인경우
		for (int i = 1; i < N; i++) {
			if (arr[i] <= arr[i - 1]) {
				cnt++;
			} else {
				if (cnt > max) {
					max = cnt;
				}
				cnt = 1;
			}

		}
		if (cnt > max) {
			max = cnt;
		}
		
		System.out.println(max);
	}

}