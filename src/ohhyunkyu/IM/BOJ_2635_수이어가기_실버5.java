package IMstudy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2635_수이어가기_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = null;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(N);
		int ans = 0;
		//두번째 수의 선택은 예제를 보았을 때 원 숫자의 60% 내외일 것//N이 1인 경우 예외
		for(int i = N/2; i < N; i++) {
			int next;
			if(N == 1) {
				list.add(1);
				next = 0;
			}
			else {
				list.add(i);
				next = N - i;
			}
			int cnt = 2;
			while(next >= 0) {
				cnt++;
				list.add(next);
				next = list.get(cnt-2) - list.get(cnt-1);
			}
			if(ans < cnt) {
				ans = cnt;
				arr = new int[list.size()];
				for(int j = 0; j < list.size(); j++) arr[j] = list.get(j);
			}
			list.clear();
			list.add(N);
		}
		System.out.println(ans);
		for(int i: arr) System.out.print(i + " ");
	}
}
