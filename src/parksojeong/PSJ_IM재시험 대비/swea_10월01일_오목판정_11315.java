package practice_1001;

import java.util.Arrays;
import java.util.Scanner;

public class swea_10��01��_��������_11315 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {// �Է¹ޱ�
			boolean bingo = false;
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);

				}
			} // �Է¹ޱ�

			outer: for (int i = 0; i < N; i++) {// ���κ��� Ȯ��
				for (int j = 0; j < N; j++) {
					int sum = 0;
					if (j + 4 < N) {//���� Ȯ��
						for (int k = 0; k < 5; k++) { //���� o �������� Ȯ��
							if (arr[i][j + k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // ���ؼ� 5�̸� true �ϰ� �����ش�.
						bingo = true;
						break outer;
					}
				}
			} // ���� ����Ȯ��
			outer: for (int i = 0; i < N; i++) { // ���� ���� Ȯ��
				for (int j = 0; j < N; j++) {
					int sum = 0;
					if (j + 4 < N) {//���� Ȯ��
						for (int k = 0; k < 5; k++) {//���� o �������� Ȯ��
							if (arr[j + k][i] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // ���ؼ� 5�̸� true �ϰ� �����ش�.
						bingo = true;
						break outer;
					}
				}
			} // ���� ����Ȯ��

			outer: for (int i = 0; i < N; i++) {// ����� �밢�� ����Ȯ��
				for (int j = 4; j < N; j++) {
					int sum = 0;
					if (i + 4 < N && j - 4 < N) {//���� Ȯ��
						for (int k = 0; k < 5; k++) {//���� o �������� Ȯ��
							if (arr[i + k][j - k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // ���ؼ� 5�̸� true �ϰ� �����ش�.
						bingo = true;
						break outer;
					}
				}
			} // �밢�� �����

			outer: for (int i = 0; i < N; i++) {// �»��� �밢�� ����Ȯ��
				for (int j = 4; j < N; j++) {
					int sum = 0;
					if (j - 4 >=0 && i - 4 >=0) {//���� Ȯ��
						for (int k = 0; k < 5; k++) {//���� o �������� Ȯ��
							if (arr[j - k][i - k] == 'o') {
								sum++;
							}
						}
					}
					if (sum == 5) { // ���ؼ� 5�̸� true �ϰ� �����ش�.
						bingo = true;
						break outer;
					}
				}
			} // �»���
			if (bingo) {// ���
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}

		} // �밢�� �»���
	}

}
