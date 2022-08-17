package BJ_Study_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_자리배정_PSJ {

	public static void main(String[] args) throws IOException {
		//아직 미완성이에요!
		// 잘 모르겠어서 구글링좀 했습니다 ㅎㅅㅎ;;//쉽지 않네 .. 8월 17일 여기서 마무리하고 내일 이어서 좀더 풀게요!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		// 상우하좌 순으로 이동
		int[] Dx = { 1, 0, 1, -1 };
		int[] Dy = { 0, 1, -1, 0 };

		// 사방을 -1로 테두리를 만들거라 행과 열 각 양쪽 두개씩 더해줍니다.사각형 식빵테두리 같은 느낌!
		int[][] CRarr = new int[C + 2][R + 2];

		// 영역을 벗어나지 않도록 하기위해 -1로 테두리를 만들어줍니다.
		for (int i = 0; i < C + 2; i++) {
			CRarr[0][i] = -1;
			CRarr[R + 1][i] = -1;

		}
		for (int i = 0; i < R + 2; i++) {
			CRarr[i][0] = -1;
			CRarr[i][C + 1] = -1;
		}

		int value = 1;
		int x = R;
		int y = 0;
		int way = 0;

		while (true) {
			CRarr[x][y] = value;

			if (value == K) {
				System.out.println(x + " " + y);
				break;
			}

			if (CRarr[x + Dx[way]][y + Dx[way]] != 0) {
				way = (way + 1) % 4;
			}

			x += Dx[way];
			y += Dy[way];

			value++;

			if (C * R < K) {
				System.out.println("0");
				break;
			}

		}
	}
}
