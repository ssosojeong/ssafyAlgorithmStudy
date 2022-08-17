package week3;

import java.io.*;
import java.util.*;

public class Q2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[][] map = new boolean[100][100];
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x + j][y + k] = true; // 색종이 크기만큼 boolean 배열 true로 바꿔줌
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					cnt++; // true면 cnt++
				}
			}
		}
		System.out.println(cnt);
	}

}

// true로 카운트를 해보겠다는 생각을 해본적이 없었는데 새로운 접근법을 생각하게 해주시네요!
