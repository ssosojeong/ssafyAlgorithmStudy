import java.util.Scanner;

public class areaOfRectangle_2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100]; // 100*100 ��ǥ�� 2���� �迭�� ǥ��
		int sum = 0; // ������ ���� ����
		for (int i = 0; i < 4; i++) { //4���� �簢���̱⿡ �ݺ����� ������
			int x = sc.nextInt();
			int y = sc.nextInt();
			int xplus = sc.nextInt();
			int yplus = sc.nextInt();
			for (int j = x; j <= xplus - 1; j++) { //��ĭ�� ��ǥ�� ���� ĭĭ���� 1�� ǥ���ϸ� sum�� ���ذ���.
				for (int k = y; k <= yplus - 1; k++) {
					if (arr[j][k] == 0) { // ���� �̹� 1�̶�� �ƹ��ൿ�� ���Ѵ�.
						arr[j][k] = 1;
						sum += 1;
					}
				}
			}
		}
		System.out.println(sum);//sum ���
	}
}
