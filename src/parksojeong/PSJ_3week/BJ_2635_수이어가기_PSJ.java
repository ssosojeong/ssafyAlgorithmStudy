package BJ_Study_7;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2635_수이어가기_PSJ {
	// 도저히 모르겠어서 진행이 어려워 살짝 답지보면서 했습니당 ㅎㅎ
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		// 최대 갯수를 저장할 변수 선언
		int max = 0;
		// 최종 배열을 저장할 리스트를 선언해서 출력을 할 수 있게 마련한다.
		List<Integer> maxSize = new ArrayList<>();

		// 뒤에 올 숫자가 처음 숫자보다 크다면 최댓값이 나올 수 없다.첫째숫자 이하로 반복문을 돌린다.
		for (int i = 1; i <= num; i++) {

			List<Integer> allNums = new ArrayList<>();
			allNums.add(num);
			allNums.add(i);
			int prePre = num;
			int pre = i;

			// 처음에는 무조건 음수가 아니기에 dowhile문을 사용했다. 만약에 이번 수가 음수가 아니라면 이번수를 배열에 추가하고 prePre와 pre의 값을 바꿔준다.
			do {
				allNums.add(prePre - pre);
				int temp;
				temp = pre;
				pre = prePre - pre;
				prePre = temp;
			} while (prePre - pre >= 0);

			// 만약 최대보다 이번배열개수가 크면 갱신해준다. 이때 반복문밖에있는 리스트에도 갱신해준다.
			if (max < allNums.size()) {
				max = allNums.size();
				maxSize.clear();
				for (int j = 0; j < allNums.size(); j++) {
					maxSize.add(allNums.get(j));
				}
			}
		} // 반복문 end

		System.out.println(max);
		for (

				int i = 0; i < maxSize.size(); i++) {
			System.out.print(maxSize.get(i) + " ");
		}
	}
}
