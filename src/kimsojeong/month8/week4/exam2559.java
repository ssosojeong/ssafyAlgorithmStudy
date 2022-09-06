package src.kimsojeong.month8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] tempers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tempers[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		//우선 처음 K일의 합을 구해 ans에 대입한다.
		for(int i=0; i<K; i++) {
			sum += tempers[i];
		}
		int ans = sum;
		
		//전날의 온도를 빼고, 다음날의 온도를 더해가며 온도의 합을 구한다
		//N=10, K=3일 때 처음에 1,2,3일의 온도를 구해  sum에 더해놨으므로
		//거기에 1일의 온도를 빼고(tempers[0]), 4일의 온도를 더하여(tempers[4]) 다음 3일간의 온도를 구한다.
		//이후 ans와 비교, 최대값 저장
		
		for(int i=0; i<N-K; i++) {
			sum -= tempers[i];
			sum += tempers[i+K];
			ans = Math.max(sum, ans);
		}
		
		System.out.println(ans);
	}

}
