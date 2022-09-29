package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1289_원재의메모리복구하기_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			char[] arr = new char[str.length()];
			arr = str.toCharArray();
			char[] zero = new char[arr.length];
			Arrays.fill(zero, '0');
			int cnt = 0;

			for(int i = 0; i < arr.length; i++) {
				if (arr[i] != zero[i] && arr[i] == '0') {
					for(int j = i; j < arr.length; j++) zero[j] = '0';
					cnt++;
				}
				else if (arr[i] != zero[i] && arr[i] == '1') {
					for(int j = i; j < arr.length; j++) zero[j] = '1';
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
