package practice_1010;

import java.util.Scanner;

public class swea_10��10��_����������̱�_7087 {

	public static void main(String[] args) {
		// 65�� A 90�� Z (26��) 97�� a 122�� z
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] arr = new int[26];// ���ĺ� ī���ù迭

			for (int i = 0; i < N; i++) {
				String str = sc.next();
//				System.out.println(str.charAt(0)-65);
				arr[str.charAt(0) - 65]++;
			} // ù��° ������ �迭 �ε����� 1�� �߰����ش�.��

			int ans = 0;
			for (int i = 0; i < 26; i++) {
				if (arr[i] == 0) {// �߰��� 0�̳����� �ش� ���ĺ����� -1�����ϱ� �ε�����ġ��ȴ�.
					ans = i;
					break;
				}
				if (i == 25) {// �ε����������� ���� ���� 26�̴�.
					ans = 26;
				}
			}

			System.out.println("#" + tc + " " + ans);

		} // tc

	}// main
}
