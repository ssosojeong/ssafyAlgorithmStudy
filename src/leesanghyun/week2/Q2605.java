package week2;

import java.util.*;
import java.io.*;

public class Q2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] students = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken()); // 학생이 뽑은 숫자 받기
		}

		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(students[i - 1], i); // 학생이 뽑은 숫자에 할당하기
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i) + " "); // 반대로 출력
		}
		System.out.println(sb);
	}
}