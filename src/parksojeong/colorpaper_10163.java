import java.lang.reflect.Array;
import java.util.Scanner;

public class colorpaper_10163 {
	public static void main(String[] args) {

		int[][] bingo = new int[1001][1001]; // ������ 1001*1001 �迭 ����� �ʱⰪ 0�ΰ� Ȱ��
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // ������ ���� ���ϱ�
		int[] overlab = new int[N]; // N�� ���� ��ġ�� �κ� �迭�� ���
		int sum = 0; // ���� ���� ����
		int count = 0;//��ġ�� �κ� ���� ����
		for (int i = 0; i < N; i++) { // ������ ������ ������� ���� ���ϱ� ���ؼ� �ݺ��� ������
			int x = sc.nextInt(); //���� �Ʒ�ĭ�� x ��ǥ
			int y = sc.nextInt();//���� �Ʒ�ĭ�� y ��ǥ
			int xplus = sc.nextInt(); //���� �ʺ�
			int yplus = sc.nextInt(); //���� �ʺ�

			for (int j = x; j <= (x + xplus - 1); j++) { //���� ��ǥ
				for (int k = y; k <= (y + yplus - 1); k++) { //������ǥ
						sum += 1; // �������ϱ�
					if (bingo[j][k] == 1) {
						count++; //��ġ�� �κ� ���ϱ�
					}
				}
			}
			overlab[i] = count;
			count =0;
			// ��ġ�� �κ��� 1�� �ν��� �ؼ� �����ߴµ� �����̰� �þ���� ������ �ȵǾ ���� �Ҿ����ϴ�
			
		}

	}

}
