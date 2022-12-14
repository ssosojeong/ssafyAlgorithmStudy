package BJ_Study_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 늘어나는 것만 하고 줄어드는건 놓칠뻔했어요 문제를 꼼꼼히 읽는게 중요하다는걸 알았습죠!
public class BJ_2491_수열_PSJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int howMany = Integer.parseInt(br.readLine());
		int[] numbers = new int[howMany];
		
		// 숫자들 배열만들기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < howMany; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 몇번 연속될지 최댓값 저장할 변수 선언
		int max = 0;
		// 커질 때 최대값 구하기
		for (int i = 0; i < howMany; i++) {
			int now = i;
			//now에서 이미 1이 더해진다.
			int count = 1;
			while (true) {
				//  now에서 1 더 갔을때 범위 벗어나는거 방지
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

		} // 커질때 최댓값 end
		
		// 작아질 때 최대값 구하기
				for (int i = 0; i < howMany; i++) {
					int now = i;
					//now에서 이미 1이 더해진다.
					int count = 1;
					while (true) {
						//  now에서 1 더 갔을때 범위 벗어나는거 방지
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

				} // 작아질때 최댓값 end
		
		
		System.out.println(max);
	}
}

//김소정: 수열에서 모든 값을 순차적으로 탐색하는 방식이 아니라 증감이 끝나는 부분까지
//		한번에 뛰어넘는 풀이는 처음봤는데 좋은 것 같습니다!

//오현규: 생각해보지 않은 접근법이었어요. 신선한 발상 잘 봤습니다! 
