package practice_1008;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_10월8월_수이어가기_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		ArrayList<Integer> list1 = new ArrayList<>();// 답으로 낼 리스트
		for (int i = N / 2; i <= N; i++) {// 처음값을 반으로 나눈 미만값은 최소값이 되니 검사를 안해도된다.
			ArrayList<Integer> list2 = new ArrayList<>(); // 비교를 위한 임시리스트
			// 미리 처음값과 두번째값을 넣고 카운트를 2를 센다
			list2.add(N);
			list2.add(i);
			int count = 2, pre = N, last = i;

			while (true) {// 무한루프 속에서 tmp를 통해 뺀 결과값을 last로 원래 last값을 pre로 다음을 준비한다.
				int tmp = 0;
				tmp = last;
				last = pre - last;
				pre = tmp;
				// 만약 음수이면 나가고 아니면 뺀값을 리스트에 추가한다.
				if (last < 0) {
					break;
				}
				list2.add(last);
				count++;
			}
			// 최대 카운트를 맥스에 저장하고 맥스에 저장되면 답으로 낼 리스트를 비우고 다시 덮어쓴다.
			max = Math.max(max, count);
			if (count == max) {
				list1.clear();
				for (int j = 0; j < list2.size(); j++) {
					list1.add(list2.get(j));
				}
			}

		}
		System.out.println(max); // 맥스값을 출력하고 리스트 값을 순차적으로 출력한다.
		for (int j = 0; j < list1.size(); j++) {
			System.out.print(list1.get(j) + " ");
		}

	}

}
