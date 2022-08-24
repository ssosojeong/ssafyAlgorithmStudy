import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2628_����¥����_PSJ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt(); // ���α��̿�
		int c = sc.nextInt(); // ���α��� �Է¹ޱ�
		int cut = sc.nextInt(); // �ڸ��� ����

		ArrayList<Integer> rList = new ArrayList<>(); // ���α����� �߸��� ���� ����ϴ� ����Ʈ
		ArrayList<Integer> cList = new ArrayList<>();// ���α����� �߸��� ���� ����ϴ� ����Ʈ
		rList.add(0);// 0���� ���̰� �������� ó���� 0�� �߰����ش�. (���������� ��ü ���� ���κе� �߰��Ұ���)
		cList.add(0);// 0���� ���̰� �������� ó���� 0�� �߰����ش�. (���������� ��ü ���� ���κе� �߰��Ұ���)

		for (int i = 0; i < cut; i++) {// ����Ʈ�� �߸��� ���� ���� �ݺ��� start

			int rOrc = sc.nextInt(); // �������� �������� ���� �ޱ�
			if (rOrc == 0) { // �����϶� �����϶� if else�� start
				cList.add(sc.nextInt()); // ���η� �ڸ��� ���θ� �����°��̹Ƿ� c�� ��ƾ��Ѵ�.
			} else {
				rList.add(sc.nextInt());// ���η� �ڸ��� ���θ� �����°��̹Ƿ� r�� ��ƾ��Ѵ�.
			} // if else�� end

		} // �ݺ��� end

		rList.add(r);// ���α����� ���ڶ� �����ְ�
		cList.add(c);// ���α����� ���ڶ� �����ش�.

		Collections.sort(rList); // ���� ���� ����Ʈ�� �����Ѵ�. ������� �ڸ� �ܸ��� ���� ���Ϸ����Ѵ�.
		Collections.sort(cList);

		int max = 0;
		for (int i = 0; i < rList.size() - 1; i++) {// ������ ����� �� for�� start

			int tmpr = rList.get(i + 1) - rList.get(i); // ���� ���̸��� ���α��̿� ���ؼ� �������Ѵ�.

			for (int j = 0; j < cList.size() - 1; j++) {// ������ ����� �� for�� start

				int tmpc = cList.get(j + 1) - cList.get(j); // ������ ����

				if (max < tmpr * tmpc) { // ������ max�� ���ؼ� max�� ����.
					max = tmpr * tmpc;
				}

			} // ������ ����� �� for�� end
		} // ������ ����� �� for�� end
		System.out.println(max);

	}

}
