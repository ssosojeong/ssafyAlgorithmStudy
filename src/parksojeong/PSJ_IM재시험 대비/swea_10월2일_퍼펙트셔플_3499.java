package pracitce_1002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_10월2일_퍼펙트셔플_3499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] arr = new String[N];
			Queue<String> q1 = new LinkedList<>(); //앞에서부터 순서대로 빠지기때문에 queue를 쓰는것이 좋다.
			Queue<String> q2 = new LinkedList<>();
//			if (N % 2 == 0) { // N이 짝수 일때는 그냥 반반 나누면 된다.
				for (int i = 0; i < N / 2 + N % 2; i++) {//N을 2로 나눈 나머지를 더하면 한번에 설정할 수 있다.
					q1.add(sc.next());
				}
				for (int i = N / 2 + N % 2; i < N; i++) {
					q2.add(sc.next());
				}
//			} else {// N이 홀수 일때는 앞에것이 하나더 있다.
//				for (int i = 0; i <= N / 2; i++) {
//					q1.add(sc.next());
//				}
//				for (int i = N / 2 + 1; i < N; i++) {
//					q2.add(sc.next());
//				}
//			}
			int idx = 0;
			while (!(q1.isEmpty() && q2.isEmpty())) {//만약 다 비워진 상태가 아니라면 반복한다.
				arr[idx++] = q1.poll(); // 앞에걸 등록하고 삭제한다.
				if (idx == N)
					break; // 홀수인경우 outofindex가 일어날 수 있으니 빠져나간다.
				arr[idx++] = q2.poll();

			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		} // testcase
	}

}
