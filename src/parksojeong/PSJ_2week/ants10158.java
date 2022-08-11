package sj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ants10158 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		// p와 q가 양으로 이동하는 지 음으로 이동하는지를 boolean으로 기록
		// 초기값은 무조건 양으로 이동하기 때문에 true로 한다.
		boolean pIsPosi = true;
		boolean qIsPosi = true;
		
		for (int i = 1; i <= t; ++i) {
			// p가 양의 방향으로 가는 동안에 다음번이 w와 같다면 다음번부터는 음의 방향으로 가야하기 때문에 pIsposi가 false가된다.
			// 그렇지 않다면 그대로 true를 하고 둘다 p에 p+1를 대입한다.
			if (pIsPosi) {
				if (p + 1 == w) {
					pIsPosi = false;
					p += 1;
				} else {
					p += 1;
				}
			} else {
				if (p - 1 == 0) {
					pIsPosi = true;
					p -= 1;
				} else {
					p -= 1;
				}
			}
			// q가 양의 방향으로 가는 동안에 다음번이 h와 같다면 다음번부터는 음의 방향으로 가야하기 때문에 qIsposi가 false가된다.
			// 그렇지 않다면 그대로 true를 하고 둘다 q에 q+1를 대입한다.
			if (qIsPosi) {
				if (q + 1 == h) {
					qIsPosi = false;
					q += 1;
				} else {
					q += 1;
				}
			} else {
				if (q - 1 == 0) {
					qIsPosi = true;
					q -= 1;
				} else {
					q -= 1;
				}
			}
		}
		System.out.println(p + " " + q);
		//시간초과 딥빡~
	}
}

//김소정: 주석덕분에 이해하기 좋았습니다!! (성능 차이는 없겠지만) for문 내에서 중복된 코드를 밖으로 빼서 줄일 수 있을 것 같아요
//		다른사람들 풀이 보니까 얘가 수학적으로 안풀고 조금이라도 반복되면 바로 시간초과 걸리는 것 같더라고요.. 웩ㅜ