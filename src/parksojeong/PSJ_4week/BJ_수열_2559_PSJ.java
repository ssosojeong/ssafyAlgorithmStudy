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
//김형균 : 여기를 int max = Integer.MIN_VALUE;로 바꾸면 됩니다!
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
//김형균 : runtime을 만약 줄이고 싶으시다면 BufferedReader 쓰니까 반토막나고 2중 for문을 단일 for문으로 바꾸어서 구현하니 나머지의 1/5 정도가 되네용.
