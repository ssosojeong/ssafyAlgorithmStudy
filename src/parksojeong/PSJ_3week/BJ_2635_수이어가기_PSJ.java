package BJ_Study_7;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2635_���̾��_PSJ {
	// ������ �𸣰ھ ������ ����� ��¦ �������鼭 �߽��ϴ� ����
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		// �ִ� ������ ������ ���� ����
		int max = 0;
		// ���� �迭�� ������ ����Ʈ�� �����ؼ� ����� �� �� �ְ� �����Ѵ�.
		List<Integer> maxSize = new ArrayList<>();

		// �ڿ� �� ���ڰ� ó�� ���ں��� ũ�ٸ� �ִ��� ���� �� ����.ù°���� ���Ϸ� �ݺ����� ������.
		for (int i = 1; i <= num; i++) {

			List<Integer> allNums = new ArrayList<>();
			allNums.add(num);
			allNums.add(i);
			int prePre = num;
			int pre = i;

			// ó������ ������ ������ �ƴϱ⿡ dowhile���� ����ߴ�. ���࿡ �̹� ���� ������ �ƴ϶�� �̹����� �迭�� �߰��ϰ� prePre�� pre�� ���� �ٲ��ش�.
			do {
				allNums.add(prePre - pre);
				int temp;
				temp = pre;
				pre = prePre - pre;
				prePre = temp;
			} while (prePre - pre >= 0);

			// ���� �ִ뺸�� �̹��迭������ ũ�� �������ش�. �̶� �ݺ����ۿ��ִ� ����Ʈ���� �������ش�.
			if (max < allNums.size()) {
				max = allNums.size();
				maxSize.clear();
				for (int j = 0; j < allNums.size(); j++) {
					maxSize.add(allNums.get(j));
				}
			}
		} // �ݺ��� end

		System.out.println(max);
		for (

				int i = 0; i < maxSize.size(); i++) {
			System.out.print(maxSize.get(i) + " ");
		}
	}
}
