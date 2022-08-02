import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class playofpaper_14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ����� �� �� �޽��ϴ�.
		for (int i = 0; i < N; i++) { // ���� Ƚ����� �ݺ�

			String A = br.readLine(); // Aī�� �����б�
			String B = br.readLine(); // Bī�� �����б�

			int A_count = (A.length()) / 2 + 1; // A ī�� ���ڰ���
			int B_count = (B.length()) / 2 + 1; // B ī�� ���ڰ���

			int[] A_arr = new int[A_count]; // A ī�� ���� ���� �迭
			int[] B_arr = new int[B_count]; // B ī�� ���� ���� �迭

			StringTokenizer st_A = new StringTokenizer(A);
			StringTokenizer st_B = new StringTokenizer(B);
			for (int j = 0; j < A_count; j++) { // Aī�� ���ڸ� �迭�� ��Ҵ�.
				A_arr[j] = Integer.parseInt(st_A.nextToken());

			}
			for (int j = 0; j < B_count; j++) { // Bī�� ���ڸ� �迭�� ��Ҵ�.
				B_arr[j] = Integer.parseInt(st_B.nextToken());

			}
			Arrays.sort(A_arr);
			Arrays.sort(B_arr); // A�� B�� ī�� ���ڸ� ������������ ����

			if (A_count > B_count) { // B ���ڰ����� �������� ����� �� , index�� �ٿ������鼭 �� ���� ���� ���������� ���� ����.
				for (int j = B_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("A"); // ���� ���������� ���ٸ� ��Ұ� �� ���� A �¸�
					}

				}
			} else if (B_count > A_count) {// A ���ڰ����� �������� ����� �� , index�� �ٿ������鼭 �� ���� ���� ���������� ���� ����.
				for (int j = A_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("B");// ���� ���������� ���ٸ� ��Ұ� �� ���� B�¸�
					}

				}
			} else {// �Ѵ� ���ڰ����� �������� ����� �� , index�� �ٿ������鼭 �� ���� ���� ���������� ���� ����.
				for (int j = A_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("D");
					}// ���� ���������� ���ٸ� ����ó��

				}

			}
		}

	}

}
