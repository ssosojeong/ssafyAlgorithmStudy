package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		//k까지 일단은 모두 더해야 한다.(처음 값을 구하기 위해)
		int max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
		}
		//그 후부터 새로 들어오는 값을 더해주고 가장 나중의 값을 빼준다.
		int tmp = max;
		for (int i = k; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp = tmp - arr[i - k] + arr[i];
			if (tmp > max) // 최댓값일때 저장
				max = tmp;
		}
		
		System.out.println(max);
	}
}
