package src.kimsojeong.month8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class exam2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 자른 위치를 저장할 리스트
		ArrayList<Integer> horCut = new ArrayList<>();
		ArrayList<Integer> verCut = new ArrayList<>();

		// 종이가 시작되는 부분과 끝부분 넣기
		horCut.add(0); 
		horCut.add(Integer.parseInt(st.nextToken()));
		verCut.add(0); 
		verCut.add(Integer.parseInt(st.nextToken()));

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("0")) {
				verCut.add(Integer.parseInt(st.nextToken()));
			} else {
				horCut.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 가로 세로 모두 오름차순으로 정렬해서 이전값과의 차이를 구하면
		// 해당 조각의 너비를 알 수 있음
		// 정렬 후 끝 지점 넣어주기
		Collections.sort(horCut);
		Collections.sort(verCut);
	
		int ans = 0;
		
		for(int i=0; i<horCut.size()-1; i++) {
			int area = horCut.get(i+1)-horCut.get(i);
			for(int j=0; j<verCut.size()-1; j++) {
				ans = Math.max(ans, area*(verCut.get(j+1)-verCut.get(j)));
			}
		}

		System.out.println(ans);

	}

}
// 김형균 : 길이를 구할때 정렬을 해주니까 코드가 가독성이 훨씬 좋네요! 저도 다음엔 sort를 쓰는 식으로 해봐야겠어요! ㅎㅎ
