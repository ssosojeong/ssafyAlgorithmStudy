import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
	static int N;
	static int[][] arr;
	static int[] arrA, arrB;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arrA = new int[N / 2 + 1];
		arrB = new int[N / 2 + 1];
		min = Integer.MAX_VALUE;
		comb(1, 1, 0);

		System.out.println(min);
	}

	static void comb(int idx, int sidx, int visited) { // 조합구하기 다들 수업때 했죠?
		if (sidx == N / 2 + 1) {
			int ans = calc(visited); // sidx를 원하는만큼 골랐으면 calc 실행
			min = Math.min(min, ans);
			return;
		}
		for (int i = idx; i < N / 2 + sidx; i++) {
			arrA[sidx] = i; // i번째를 골라주고 (arrA배열에 넣고)
			comb(i + 1, sidx + 1, visited | (1 << i)); // 방문여부를 체크하고 보낸다.
		}
	}

	static int calc(int visited) { // 방문여부를 파라미터를 통해서 건네주고 이를통해 arrB의 배열을 정한다.
		for (int i = 1, cnt = 1; i <= N; i++) {
			if ((visited & (1 << i)) == 0) {
				arrB[cnt++] = i;
			}
		}
		int sumA = 0;
		int sumB = 0;
		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= N / 2; j++) {
				if (i != j) {
					sumA += arr[arrA[i]][arrA[j]];
				}
			}
		} // A배열의 합
		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= N / 2; j++) {
				if (i != j) {
					sumB += arr[arrB[i]][arrB[j]];
				}
			}
		} // B배열의 합
		return Math.abs(sumA - sumB);
	}

}