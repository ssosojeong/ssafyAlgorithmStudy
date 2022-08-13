package week3;

import java.io.*;
import java.util.*;

public class Q2564 {
	static int h;
	static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N + 1]; // 한 점을 기준으로 거리를 계산할 것이기 때문에.
		
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dis[i] = distance(a, b); // 거리 넣기 distance 함수 참조
		}
		int round = 2 * w + 2 * h; // 둘레의 길이
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Math.abs(dis[N] - dis[i]); //거리의 차를 구하고 절대값을 씌운다.
			sum += Math.min(round - tmp, tmp);
			// 반대 꼭지점을 통해서 가는게 더 가까울 수 있으므로 둘레에서 해당 길이를 빼고 둘 중 작은값을 쓴다.
		}
		System.out.println(sum);
	}

	static int distance(int x, int y) { 
		// 왼쪽 위 꼭지점과 오른쪽 아래 꼭지점을 선분으로 그어서 우측 위는 +, 좌측 아래는 -로 설정하고
		// 왼쪽 위 꼭지점으로의 거리를 쟨다.
		if (x == 1) {
			return y;
		} else if (x == 2) {
			return -(y + h);
		} else if (x == 3) {
			return -y;
		} else {
			return w + y;
		}
	}

}