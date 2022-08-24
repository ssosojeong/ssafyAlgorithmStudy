import java.util.Scanner;

public class BJ_수열_2559_PSJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 온도 수
		int K = sc.nextInt(); // 연속되는 수
		int[] temper = new int[N]; // 온도 저장하는 배열

		for (int i = 0; i < N; i++) {// 온도를 배열에 저장한다.
			temper[i] = sc.nextInt();
		}

		int max = 0;

		for (int i = 0; i <= N - K; i++) {
			int sum = 0; // 연속되는 온도의 합
			for (int j = 0; j < K; j++) {
				sum += temper[i + j]; // 연속하는 온도의 합계를 저장
			}
			if (sum > max) {
				max = sum; // max와 비교해서 최대값을 구한다.
			}
		}
		System.out.println(max);

	}
}
