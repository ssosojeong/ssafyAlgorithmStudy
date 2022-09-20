import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
	static int minusSum, zeroSum, plusSum; // -1,0,1로 가득차면 ++해줄 변수
	static int[][] arr; // 행렬
	static StringBuilder sb = new StringBuilder(); // div함수 안에서 sb를 쓰기위해 static

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(0, 0, N); // 시작점이 0,0이고 NxN범위를 분할한다.
		sb.append(minusSum).append("\n").append(zeroSum).append("\n").append(plusSum).append("\n");
		System.out.println(sb);
	}

	static void div(int sr, int sc, int size) {
		int minus = 0, plus = 0, zero = 0; // 각각 -1,0,1의 갯수
		for (int i = sr; i < sr + size; i++) {
			for (int j = sc; j < sc + size; j++) {
				if (arr[i][j] == -1)
					minus++;
				else if (arr[i][j] == 0)
					zero++;
				else
					plus++;
			}
		}
		if (minus == size * size) { // -1로 가득차있으면
			minusSum++; // 더해주고
			return; // 리턴
			//아래도 똑같다.
		} else if (zero == size * size) {
			zeroSum++;
			return;
		} else if (plus == size * size) {
			plusSum++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				div(sr + size / 3 * i, sc + size / 3 * j, size / 3); // 9분할로 나눠서 재귀를 돌린다.
			}
		}
	}

}