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
//김형균 : 위처럼 음수일 경우까지 대비해서 보통 최댓값을 구할 때는 초기화를 Integer.MIN_VALUE;
//        최솟값를 구할 때는 초기화 시에 Integer.MAX_VALUE; 로 초기화를 많이 합니다.
//        두 값은 각각 int 타입이 가질 수 있는 최솟값과 최댓값을 나타냅니다. 졸업 축하해용~		
		
		for(int i = 0; i <= N - K; i++) {
			
			int sum = 0;
			
			for(int j = 0; j < K; j++) {
				sum += arr[i+j];
			} // K개의 날짜의 온도 합 구하기
			
			if(ans < sum) {
				ans = sum;
			} // ans와 비교
		}
// 김형균 : 저도 이 부분에 대해서 새롭게 알게 된건데 이렇게 단순 합을 구하는 과정은 이중 for문을 단일 for문으로 시간 복잡도를 낮출 수 있습니다.
//         혹시 관심있으시다면 제 코드 한번 봐주세용		
		// 출력부
		System.out.println(ans);
		
	}
}

