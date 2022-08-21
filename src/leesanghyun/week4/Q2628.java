package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		List<Integer> rowList = new ArrayList<>();
		//가로줄 index를 담아줄 리스트
		List<Integer> colList = new ArrayList<>();
		//세로줄 index를 담아줄 리스트
		rowList.add(0);
		rowList.add(r);
		colList.add(0);
		colList.add(c);
		//끝점과 처음을 우선 추가해준다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if (tmp == 0)
				colList.add(val);
			else
				rowList.add(val);
		}
		//각각 잘리는 부분을 행과 열에 맞게 넣어준다.
		Collections.sort(rowList);
		Collections.sort(colList);
		//정렬한다.
		int max = 0;

		for (int i = rowList.size() - 1; i > 0; i--) {
			int row = rowList.get(i) - rowList.get(i - 1);
			for (int j = colList.size() - 1; j > 0; j--) {
				int col = colList.get(j) - colList.get(j - 1);
				if (col * row > max)
					max = col * row;
			}
		}
		//차례대로 get해서 빼주고 곱하면서 max값을 찾는다.

		System.out.println(max);
	}
}
