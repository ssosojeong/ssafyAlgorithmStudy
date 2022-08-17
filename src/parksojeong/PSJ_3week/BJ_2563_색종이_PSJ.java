package BJ_Study_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 도화지 100*100을 2차원으로 선언하면 기본값이 0
		int[][] paper = new int[100][100];

		// 색종이 수만큼 반복문을 돌리면서 면적을 count에 센다.
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < num; ++i) { // 색종이 수만큼 반복문 돌려서 count세기 start
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 색종이가 왼쪽 아래좌표부터해서 10을더한걸 넘지않게 1를 찍어서 덮힌 면적을 표시한다.

			// 색종이 10면적에 1표시 반복문 start
			for (int r = y; r < y + 10; r++) { //
				for (int c = x; c < x + 10; c++) {
					// 만약 해당부분이 이미 1이라면 카운트를 세지 않는다.
					if (paper[r][c] != 1) {
						paper[r][c] = 1;
						count++;
					}
				}
			} // 색종이 10면적에 1표시 반복문 end

		} // 색종이 수만큼 반복문 돌려서 count세기 end
		System.out.println(count);
	}
}
//김형균 : 반복도 최대한 줄일 수 있는 코드라고 생각이 들고 주석이 상당히 꼼꼼하니 좋네요! 색종이 십면적에 1표시도 조금 더 풀어서 적어줘요~
