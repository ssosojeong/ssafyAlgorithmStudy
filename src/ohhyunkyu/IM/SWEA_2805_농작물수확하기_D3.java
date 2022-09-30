package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int cnt = 0;
			int sign = N / 2;
			boolean chk = false;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				if (!chk) {
					for (int j = 0; j <= cnt; j++) {
						if (j == 0) {
							ans += str.charAt(N / 2) - '0';
						} else {
							ans += str.charAt(N / 2 - j) - '0';
							ans += str.charAt(N / 2 + j) - '0';
						}
					}
					if (cnt == sign) {
						chk = true;
						continue;
					}
					cnt++;
				} else {
					cnt--;
					for (int j = 0; j <= cnt; j++) {
						if (j == 0) {
							ans += str.charAt(N / 2) - '0';
						} else {
							ans += str.charAt(N / 2 - j) - '0';
							ans += str.charAt(N / 2 + j) - '0';
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
