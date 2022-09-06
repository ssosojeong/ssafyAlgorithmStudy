package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10819 {
	static int N, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		permu(arr, new int[N], 0, 0);
		System.out.println(max);
	}

	// 여기서 arr은 입력받은 배열, resArr은 새로 배열한 배열, pick은 현재까지 담은 원소가 무엇인지 알려주는 숫자, cnt는
	// 현재까지 담은 원소의 갯수
	static void permu(int[] arr, int[] resArr, int pick, int cnt) {
		if (cnt == N) {
			// 현재까지 담은 원소의 갯수가 N이면 max값과 비교하고 리턴한다.
			max = Math.max(max, sum(resArr, 0, N));
			return;
		}
		for (int i = 0; i < N; i++) {// 비트마스크로 int하나에 방문여부를 저장함.
			if ((pick & (1 << i)) == 0) { // pick의 1<<i부분이 0일경우
				int newPick = pick | (1 << i); // pick의 i번째를 채워준 후
				// 현재까지 cnt개의 원소를 resArr에 보관하고 있으므로 0~cnt-1까지는 값이 들어있다. 그러므로 resArr[cnt]에 값을
				// 넣어주면 된다.
				resArr[cnt] = arr[i];
				permu(arr, resArr, newPick, cnt + 1); // cnt가 N이 될 때까지 재귀를 돌린다.
			}

		}
	}

	static int sum(int[] arr, int start, int end) {
		if (start == N - 2) // start가 N-2면 재귀를 멈춘다.
			return Math.abs(arr[start] - arr[start + 1]);
		else {
			return Math.abs(arr[start] - arr[start + 1]) + sum(arr, start + 1, end);
			// 계속해서 재귀가 실행된다면, 다음과 같이 진행된다.
			// |arr[0]-arr[1]| + sum(arr, start + 1, end)
			// |arr[0]-arr[1]| + |arr[1]-arr[2]| + sum(arr, start + 2, end)
			// |arr[0]-arr[1]| + |arr[1]-arr[2]| + |arr[2]-arr[3]| + sum(arr, start + 3, end)
		}
	}
}
