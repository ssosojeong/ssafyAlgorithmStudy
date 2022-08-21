package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] arr = new int[2][7];

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[gender][grade]++;
		}
		
		//위 과정은 input을 받는 과정

		int cnt = 12; // 일단 12개를 준다.
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				if (arr[i][j] == 0) // 해당 학년, 성별 부분에 아무도 없다면 방을 빼준다.
					cnt--;
				else if (arr[i][j] > k) // k명 이상 있다면 그만큼 방 개수를 더해준다.
					cnt += (arr[i][j] - 1) / k;
			}
		}
		System.out.println(cnt);
	}
}
