import java.util.Scanner;

public class BJ_����_2559_PSJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �µ� ��
		int K = sc.nextInt(); // ���ӵǴ� ��
		int[] temper = new int[N]; // �µ� �����ϴ� �迭

		for (int i = 0; i < N; i++) {// �µ��� �迭�� �����Ѵ�.
			temper[i] = sc.nextInt();
		}

		int max = 0;

		for (int i = 0; i <= N - K; i++) {
			int sum = 0; // ���ӵǴ� �µ��� ��
			for (int j = 0; j < K; j++) {
				sum += temper[i + j]; // �����ϴ� �µ��� �հ踦 ����
			}
			if (sum > max) {
				max = sum; // max�� ���ؼ� �ִ밪�� ���Ѵ�.
			}
		}
		System.out.println(max);

	}
}
