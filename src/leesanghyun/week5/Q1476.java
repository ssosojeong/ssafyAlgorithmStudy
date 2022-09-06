package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 이 문제의 시간복잡도는 E S M 의 최소공배수만큼이다. 그렇기때문에 브루트포스로 풀어도 무방.
		// E의 경우 16->1로 가야하는데 %로 하면 16->0으로 가기 때문에 각각 1씩 빼준 값으로 저장한다.
		int ansE = Integer.parseInt(st.nextToken()) - 1;
		int ansS = Integer.parseInt(st.nextToken()) - 1;
		int ansM = Integer.parseInt(st.nextToken()) - 1;
		// 처음에 숫자를 입력받을 때 1을 빼고 시작했기 때문에 E,S,M은 0으로 시작한다.
		int E = 0;
		int S = 0;
		int M = 0;
		// 문제에서의 E,S,M이 1,1,1일때 1이므로
		int cnt = 1;
		while (!(ansE == E++ & ansS == S++ & ansM == M++)) { 
			// 여기서 &&을 쓰면 앞의 식에서 false가 나버리면 뒤의 ++을 계산하지 않는다. 그래서 &을 쓴다.
			E %= 15;
			S %= 28;
			M %= 19;
			cnt++;
		}
		System.out.println(cnt);
	}
}
