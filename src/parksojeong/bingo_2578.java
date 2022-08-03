package bingo;

import java.util.*;

public class bingo_2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] bingo = new int[26]; // 1���� 25���� ������ڸ� index�� ����Ͽ� ���°������ ���������� ������ ����ϱ� ���� �迭
		int order = 1;// ���� 1���� �����ϱ� ���� ����
		for (int i = 1; i <= 25; i++) {
			bingo[sc.nextInt()] = order;
			order++; // �������� ������ ������ �迭�� ���
		}

		int count = 0;// ���� ī��Ʈ

		for (int i = 1; i <= 25; i++) {
		
			int sum_ver = 0;// ���� ���� Ȯ��
			int sum_hor = 0;// ���� ���� Ȯ��
			int sum_cross1 = 0; // �밢�� 1 ���� Ȯ��
			int sum_cross2 = 0; // �밢�� 2 ���� Ȯ��
			bingo[sc.nextInt()] = -1; 	// ǥ�ð� �Ǹ� -1�̶�� �Ѵ�. ���ٿ� -5���Ǹ� �����Ǵ°�

			// ���� ���� ī��Ʈ
			for (int j = 1; j <= 5; j++) {
				for (int k = 0; k < 5; k++) {
					sum_ver += bingo[j + 5 * k];
				}
				if (sum_ver == -5) {
					count++;
				}
				 sum_ver = 0;
			}

			// ���κ��� ī��Ʈ
			for (int j = 1; j <= 21; j = j + 5) {
				for (int k = 0; k < 5; k++) {
					sum_hor += bingo[j + k];
				}
				if (sum_hor == -5) {
					count++;
				}
				sum_hor = 0;
			}

			// �밢�� ���� ī��Ʈ1
			for (int j = 1; j <= 25; j = j + 6) {
				sum_cross1 += bingo[j];
			}
			if (sum_cross1 == -5) {
				count++;
			}
			// �밢�� ���� ī��Ʈ2
			for (int j = 5; j <= 21; j = j + 4) {
				sum_cross2 += bingo[j];
			}

			if (sum_cross2 == -5) {
				count++;
			}
			//���� ������ �Ǹ� ���°���� ����ϰ� �ݺ��� ����
			if (count == 3) {
				System.out.println(i);
				break;
			}
		}

	}

}
