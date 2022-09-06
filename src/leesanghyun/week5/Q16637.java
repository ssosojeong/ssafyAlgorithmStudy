package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16637 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		// 여기서 연산자의 갯수는 N/2이다. 그리고 연산자에 괄호가 씌워졌을 때를 1로, 없을때는 0으로 표현한다면
		// 0000부터 1111까지 가능한데, 이 때 1 두개가 이웃하게 되면, ((3+8)*7)-9*2와 같이 되므로
		// 중첩된 괄호를 사용하게 된다. 따라서 이웃하지 않게 1을 배치했을 때, 가능한 경우의 수를 구하면 된다.
		// N이 9일경우 0000 1000 1010 1001 0100 0101
		int max = Integer.MIN_VALUE;
		// 밑의 주석은 N이 9일때를 가정해서 설명
		outer: for (int i = 0; i < (1 << N / 2); i++) { // i는 0000~1111
			for (int j = 0; j < N / 2; j++) {// j는 0~3까지
				if ((i & (1 << j)) != 0) {// i의 오른쪽에서 j번째의 수가 0이 아니라면. 예를 들어, 1001 & 0100 = 0이기 때문이다.
					if ((j - 1 < 0 || (i & (1 << (j - 1))) == 0) && (j + 1 >= N / 2 || (i & (1 << (j + 1))) == 0)) {
						//j번째의 왼쪽과 오른쪽도 1이 아니어야하기 때문에 오른쪽의 경우 1 << (j - 1), 왼쪽의 경우 1 << (j + 1)를
						//i와 비교해서 0인지 확인한다. 만약 j번째의 왼쪽 혹은 오른쪽이 범위가 벗어났을 경우도 가능하기 때문에 (ex) 1001)
						//위의 경우도 통과시켜야한다.
						continue;
					} else {
						//만약 위의 if식을 통과하지 못했다면, i는 쓸 수 없는 수이기 때문에 outer로 continue 한다. break을 써도 무방.
						continue outer;
					}
				}
			}
			//위의 j for문식을 다 돌고 나서 여기까지 도착했다면, 해당 i는 이웃한 1이 없는 수로, 조건에 맞는 수가 된다.
			//preCalc라는 함수를 만들어 계산해주고 max값을 갱신한다.
			max = Math.max(max, preCalc(str, i));
		}
		System.out.println(max);
	}

	static int preCalc(String str, int bitMask) {
		Queue<Integer> nQue = new LinkedList<>(); // 숫자가 들어갈 Queue
		Queue<Character> cQue = new LinkedList<>(); // 연산자가 들어갈 Queue
		for (int i = 0; i < str.length() / 2; i++) {
			if ((bitMask & (1 << i)) == 0) { //bitMask의 i번째 숫자가 0이면,
				nQue.offer(str.charAt(2 * i) - '0'); // 숫자는 숫자큐에,
				cQue.offer(str.charAt(2 * i + 1));// 연산자는 연산자큐에 넣어준다.
			} else { // bitMask의 i번째 숫자가 1이면 미리 연산을 하고, 숫자큐에 넣어줘야 하므로 숫자2개와 연산자 한개를 꺼낸다.
				int a = str.charAt(2 * i) - '0'; 
				int b = str.charAt(2 * i + 2) - '0';
				char c = str.charAt(2 * i + 1);
				nQue.offer(calc(a, b, c)); // calc식을 통해 연산한다.
				if (i != str.length() / 2 - 1) // 만약 i가 N/2-1이라면 2*i+3번째 문자는 없으므로 더해주지 않는다. 
					cQue.offer(str.charAt(2 * i + 3));
				i++;//해주지 않으면 똑같은 숫자와 연산자를 큐에 또 넣는다.
			}
		}
		//위의 for문식을 다 돌면 마지막 숫자를 넣지 않으므로 넣어준다. 
		//0001같이 마지막에 괄호가 들어가는 경우는 한번 더 넣어주게 되는데, 밑의 cQue.isEmpty로 조건을 주면 앞의 경우는
		//nQue에 숫자가 하나 남은상태로 함수가 종료되기 때문에 상관없다.
		nQue.offer(str.charAt(str.length() - 1) - '0');
		int ans = nQue.poll();
		while (!cQue.isEmpty()) { // cQue가 빌때까지 연산한다.
			int b = nQue.poll();
			char c = cQue.poll();
			ans = calc(ans, b, c);
		}
		return ans;
	}

	static int calc(int a, int b, char c) {
		switch (c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;

		default:
			return 0;
		}
	}
}
