package BJ_Study_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2491_수열_PSJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int howMany = Integer.parseInt(br.readLine());
		int[] numbers = new int[howMany];
		
		// 숫자들 배열만들기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < howMany; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 몇번 연속될지 최댓값 저장할 변수 선언
		int max = 0;
		// 커질 때 최대값 구하기
		for (int i = 0; i < howMany; i++) {
			int now = i;
			int count = 1;
			while (true) {
				if (now + 1 == howMany) {
					break ;
				}
				if (numbers[now] <= numbers[++now]) {
					count++;
				} else {
					break ;
				}
			}

			if (max < count) {
				max = count;
			}

		} // 커질때 최댓값 end
		
		// 작아질 때 최대값 구하기
				for (int i = 0; i < howMany; i++) {
					int now = i;
					int count = 1;
					while (true) {
						if (now + 1 == howMany) {
							break ;
						}
						if (numbers[now] >= numbers[++now]) {
							count++;
						} else {
							break ;
						}
					}

					if (max < count) {
						max = count;
					}

				} // 작아질때 최댓값 end
		
		
		System.out.println(max);
	}
}
