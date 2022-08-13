package BJ_Study_3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원_PSJ {
	// 우왕 이거 하는 삼매경에 빠져서 새벽 두시반인지 모르고 밤 11시쯤 됐나 했네용 ㅋ..근데 대차게 틀렸습니다!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 블록의 가로길이와 세로길이 (100이하의 자연수)
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		// 상점의 개수(100이하의 자연수)
		int markets = Integer.parseInt(br.readLine());
		// 상점의 위치를 저장할 2차원 배열 선언
		int[][] positions = new int[markets][2];
		// 반복문을 마켓수만큼 돌리며 배열을 완성한다.
		for (int r = 0; r < markets; r++) {
			st = new StringTokenizer(br.readLine());
			positions[r][0] = Integer.parseInt(st.nextToken());
			positions[r][1] = Integer.parseInt(st.nextToken());
		}
		// 동근이의 위치를 변수에 초기화한다.(혹시 양동근?)
		st = new StringTokenizer(br.readLine());
		int Dx = Integer.parseInt(st.nextToken());
		int Dy = Integer.parseInt(st.nextToken());
		
		//최단거리의 합을 저장할 count 선언후 반복문을 돌려서 최단거리를 더한다.
		int count = 0;
		for (int r = 0; r < markets; r++) { // 최단거리 더하는 반복문 start
			
			// 상점의 방향과 위치를 x,y 변수로 지정한다.
			int x = positions[r][0];
			int y = positions[r][1];
			
			// 만약 동근의 방향과 상점 방향이 같다면 최단거리는 두거리의 차이의 절대값이다.
			if (Dx == x) {
				count += Math.abs(Dy - y);
			}
			// 동근의 방향과 상점방향이 1과 2중에 하나일 때
				else if (Dx + x == 3) {
				count += Math.min(height + Dy + y, width * 2 + height - (Dy + y));
				// 동근의 방향과 상점방향이 1과 3중에 하나일 때
			} else if (Dx + x == 4 && Dx != x) {
				count += Dy + y;
				// 동근의 방향과 상점방향이 2과 4중에 하나일 때
			} else if (Dx + x == 6 && Dx != x) {
				count += width + height - (Dy + y);
			}
			// 동근의 방향과 상점방향이 4과 1중에 하나일 때
			else if (Dx == 1 && x == 4) {
				count += width - Dy + y;

				// 동근의 방향과 상점방향이 4과 1중에 하나일 때
			} else if (Dx == 4 && x == 1) {
				count += width + Dy + y;

				// 동근의 방향과 상점방향이 2과 3중에 하나일 때
			} else if (Dx == 2 && x == 3) {
				count += height + Dy - y;

				// 동근의 방향과 상점방향이 2과 3중에 하나일 때
			} else if (Dx == 3 && x == 2) {
				count += height - Dy + y;
			}

		} // 최단거리 더하는 반복문 end
		System.out.println(count);

	}
}
