package BJ_Study_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2491_����_PSJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int howMany = Integer.parseInt(br.readLine());
		int[] numbers = new int[howMany];
		
		// ���ڵ� �迭�����
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < howMany; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// ��� ���ӵ��� �ִ� ������ ���� ����
		int max = 0;
		// Ŀ�� �� �ִ밪 ���ϱ�
		for (int i = 0; i < howMany; i++) {
			int now = i;
			int count = 1;
			while (true) {
				if (now + 1 == howMany) {
					break ;
				}
				if (numbers[now] <= numbers[++now]) {
					count++;
				} else {
					break ;
				}
			}

			if (max < count) {
				max = count;
			}

		} // Ŀ���� �ִ� end
		
		// �۾��� �� �ִ밪 ���ϱ�
				for (int i = 0; i < howMany; i++) {
					int now = i;
					int count = 1;
					while (true) {
						if (now + 1 == howMany) {
							break ;
						}
						if (numbers[now] >= numbers[++now]) {
							count++;
						} else {
							break ;
						}
					}

					if (max < count) {
						max = count;
					}

				} // �۾����� �ִ� end
		
		
		System.out.println(max);
	}
}
