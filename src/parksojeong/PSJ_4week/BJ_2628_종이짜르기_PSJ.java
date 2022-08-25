import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2628_종이짜르기_PSJ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt(); // 가로길이와
		int c = sc.nextInt(); // 세로길이 입력받기
		int cut = sc.nextInt(); // 자르는 개수

		ArrayList<Integer> rList = new ArrayList<>(); // 가로길이의 잘리는 숫자 기록하는 리스트
		ArrayList<Integer> cList = new ArrayList<>();// 세로길이의 잘리는 숫자 기록하는 리스트
		rList.add(0);// 0부터 길이가 정해져서 처음에 0을 추가해준다. (마지막에는 전체 길이 끝부분도 추가할것임)
		cList.add(0);// 0부터 길이가 정해져서 처음에 0을 추가해준다. (마지막에는 전체 길이 끝부분도 추가할것임)

		for (int i = 0; i < cut; i++) {// 리스트에 잘리는 숫자 저장 반복문 start

			int rOrc = sc.nextInt(); // 가로인지 세로인지 숫자 받기
			if (rOrc == 0) { // 가로일때 세로일때 if else문 start
				cList.add(sc.nextInt()); // 가로로 자르면 세로를 나누는거이므로 c에 담아야한다.
			} else {
				rList.add(sc.nextInt());// 세로로 자르면 가로를 나누는거이므로 r에 담아야한다.
			} // if else문 end

		} // 반복문 end

		rList.add(r);// 가로길이의 끝자락 더해주고
		cList.add(c);// 세로길이의 끝자락 더해준다.

		Collections.sort(rList); // 가로 세로 리스트를 정렬한다. 순서대로 자른 단면의 넓이 구하려고한다.
		Collections.sort(cList);

		int max = 0;
		for (int i = 0; i < rList.size() - 1; i++) {// 가로의 경우의 수 for문 start

			int tmpr = rList.get(i + 1) - rList.get(i); // 가로 길이마다 세로길이와 곱해서 면적구한다.

			for (int j = 0; j < cList.size() - 1; j++) {// 세로의 경우의 수 for문 start

				int tmpc = cList.get(j + 1) - cList.get(j); // 세로의 길이

				if (max < tmpr * tmpc) { // 면적과 max값 비교해서 max값 낸다.
					max = tmpr * tmpc;
				}

			} // 세로의 경우의 수 for문 end
		} // 가로의 경우의 수 for문 end
		System.out.println(max);

	}

}
