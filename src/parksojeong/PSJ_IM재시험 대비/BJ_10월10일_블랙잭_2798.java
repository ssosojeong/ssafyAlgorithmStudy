package practice_1010;

import java.util.Scanner;

public class BJ_10��10��_����_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// ��ü ī���� ����
		int M = sc.nextInt();// ������ �θ��� ��
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {// �迭�� �Է°��� �޴´�.
			arr[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {//���� �̾Ƽ�
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];

					if (sum <= M) {//���� M ���϶�� �ƽ����� �����Ѵ�.
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);

	}

}
