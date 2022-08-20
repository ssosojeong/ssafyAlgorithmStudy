package week4;

import java.util.Scanner;

public class BOJ_2559_수열_실버3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 온도 측정한 날짜 수
		
		int K = sc.nextInt(); // 합을 구할 연속 날짜 수
		// 1 < K(정수) < N
		
		int[] arr = new int[N]; // 온도 배열 생성
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt(); // 입력
		
		
		int ans = -100 * K; // 가장 큰 온도의 합 초기화
		// 주의!! 온도는 음수가 있기 때문에 0으로 초기화하면 안된다.
		// 예를 들어 온도가 모두 마이너스이면... 바로 오답.
		// 여기서는 온도가 -100 이상 100 이하이므로 이를 고려.
		
		
		for(int i = 0; i <= N - K; i++) {
			
			int sum = 0;
			
			for(int j = 0; j < K; j++) {
				sum += arr[i+j];
			} // K개의 날짜의 온도 합 구하기
			
			if(ans < sum) {
				ans = sum;
			} // ans와 비교
		}
		
		// 출력부
		System.out.println(ans);
		
	}
}
