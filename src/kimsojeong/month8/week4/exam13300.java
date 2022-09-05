package src.kimsojeong.month8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] rooms = new int[12];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			//arr[0]: 1학년 여자 / arr[1]: 1학년 남자... / arr[11]: 6학년 남자
			rooms[2 * (Y - 1) + S]++;
		}

		int ans = 0;
		for (int i = 0; i < 12; i++) {
			//배정된 인원이 K명으로 나눠 떨어질경우 몫을, 아닌 경우 몫에 1을 더해 저장
			if (rooms[i] % K == 0)
				ans += rooms[i] / K;
			else
				ans += rooms[i] / K + 1;
		}

		System.out.println(ans);
	}

}
