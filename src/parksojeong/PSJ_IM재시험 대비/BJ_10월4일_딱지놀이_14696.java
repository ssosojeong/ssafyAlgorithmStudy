package practice_1004;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10��4��_��������_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {// tc
			int[] arrA = new int[5];// A �ε��� 1���� 4����
			int[] arrB = new int[5];// B �ε��� 1���� 4����

			int A = sc.nextInt();
			for (int i = 0; i < A; i++) { // A ���� �ε����� ��������
				arrA[sc.nextInt()]++;
			}
//			System.out.println(Arrays.toString(arrA));
			int B = sc.nextInt();
			for (int i = 0; i < B; i++) { // B ���� �ε����� ��������
				arrB[sc.nextInt()]++;
			}
//			System.out.println(Arrays.toString(arrB));

			for (int i = 4; i >= 1; i--) { // ���� ���ذ��鼭 �ºΰ�����
//				System.out.println(arrA[i]);
//				System.out.println(arrB[i]);
				if (arrA[i] > arrB[i]) {
					System.out.println("A");
					break;// �̹� ������ ������ ������.
				} else if (arrA[i] < arrB[i]) {
					System.out.println("B");
					break;// �̹� ������ ������ ������.
				} else {
					if(i == 1) {System.out.println("D");} //���� 1�̶� ������ �ȳ��� ���º�
					continue;
				}
			}//�º� ������

		} // tc
	}// main
}
