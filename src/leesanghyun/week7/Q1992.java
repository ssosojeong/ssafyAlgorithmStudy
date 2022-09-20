import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
	static int[][] arr;// 행렬
	static StringBuilder sb = new StringBuilder();// div함수 안에서 sb를 쓰기위해 static

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		div(0, 0, N);// 시작점이 0,0이고 NxN범위를 분할한다.
		System.out.println(sb);
	}

	static void div(int sr, int sc, int size) {
		int ans = sum(sr, sc, size); // 시작점이 sr,sc이고 sizeXsize만큼의 행렬의 합을 구한다.
		if (ans == size * size) { // 그 합이 size^2이면
			sb.append(1); // 1로 가득찬 것이기 때문에 1을 더해준다.
			return;
		} else if (ans == 0) { // 그 합이 0이면
			sb.append(0); // 0으로 가득찬 것이기 때문에 0을 더해준다.
			return;
		}
		sb.append("(");//만약 위에서return이 나지 않았다면 (로 감싸주고
		div(sr, sc, size / 2);
		div(sr, sc + size / 2, size / 2);
		div(sr + size / 2, sc, size / 2);
		div(sr + size / 2, sc + size / 2, size / 2);
		sb.append(")");//위의 함수가 끝나면 닫아준다.
	}

	static int sum(int r, int c, int size) {
		int tmp = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				tmp += arr[i][j];
			}
		}
		return tmp;
	}

}
