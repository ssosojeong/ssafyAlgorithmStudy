package BJ_Study_7;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class BJ_2606_바이러스_psj {
	static int[][] arr;
	static boolean[] visit;
	static int n, line,count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int line = sc.nextInt();

		arr = new int[n + 1][n + 1]; // +1를 하는 이유는 컴퓨터 숫자 그대로 입력하기 위해
		visit = new boolean[n + 1];

		for (int i = 0; i < line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b] = arr[b][a] = 1;
		} // computer 2차원 배열에 연결된 컴퓨터끼리 1을 기입한다

		dfs(1);
		System.out.println(count - 1);
	}

	public static void dfs(int start) {
		visit[start] = true; // 한번 지나간건 true로 바꿔준다
		count++;
		//여기서 n을 출력하면 0이 나오는데 이유를 모르겠다..
		for (int i = 0; i <= n; i++) {//전체 컴퓨터 중에 연결되어있고 아직 탐색을 안한것이있다면 dfs를 해준다.
			if (arr[start][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
}
