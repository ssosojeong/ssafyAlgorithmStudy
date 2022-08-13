package week3;

import java.io.*;
import java.util.*;

public class Q10157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		int x = 1;
		int y = 1;
		// 좌표 초기값이 1,1이기 때문에.
		if (k > c * r) {
			System.out.println("0");
			return;
		}
		// 최대치보다 넘어서면 0 출력 후 종료
		while (true) {
			k -= (2 * c + 2 * r - 4); // 둘레의 길이를 계속 빼준다.
			if (k <= 0) { // 음수가 되면
				k += (2 * c + 2 * r - 4); //해당 c,r테두리 안에 있다는 뜻이므로 다시 더해주고
				break; // 끝낸다.
			}
			c -= 2;
			r -= 2;
			x++;
			y++;
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		k--; // 시작하자마자 숫자를 기입하므로 한번 빼준다.

		int initX = 0;
		int initY = 0; // 더해줄 숫자. 상대숫자

		for (int i = 0; i < 4; i++) { // 달팽이 문제처럼 돌려줌. 하지만 한바퀴만 돌리면 된다.
			while (k > 0) {
				int nx = initX + dx[i];
				int ny = initY + dy[i];
				if (nx < 0 || nx >= c || ny < 0 || ny >= r)
					break;
				k--;
				initX = nx;
				initY = ny;
			}
		}

		System.out.println((x + initX) + " " + (y + initY));

	}

}