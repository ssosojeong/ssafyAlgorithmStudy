package week3;

import java.io.*;
import java.util.*;

public class Q2635 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<Integer> ansList = null; // ansList 초기화.

		int max = 0;

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>(); // 임시로 사용할 리스트 만들어주기.
			list.add(N); // N추가
			list.add(i); // i추가
			int j = 2;
			while (list.get(j - 2) - list.get(j - 1) >= 0) { // 양수면 리스트에 넣고 아니면 안넣고 끝
				list.add(list.get(j - 2) - list.get(j - 1));
				j++;
			}
			if (j > max) { // 최대인지 판별
				max = j;
				ansList = list;
			}
		}

		sb.append(max + "\n");

		for (int i : ansList) {
			sb.append(i + " ");
		}

		System.out.println(sb);

	}

}
//상현님 코드는 볼때마다 참신하고 깔끔해서 좋네용 ㅎㅎ j 에 대한 부연설명을 좀더 들을 수 있으면 좋을거 같습니다!
