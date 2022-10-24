package text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam16719 {
	static char[] input, ans;
	static StringBuilder sb;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//처음부터 쭉 가면서 제일 작은 놈 찾고
		//그 뒤에서 쭉 가면서 또 작은 놈 찾고 -> 합쳐서 만들기
		//그 뒤에서 쭉 가면서 또 작은놈 찾고 -> 합쳐서 만들기
		// .. 반복
		
		input = br.readLine().toCharArray();
		N = input.length;
		ans = new char[N];
		sb = new StringBuilder();
		
		findMin(0,N);
		System.out.println(sb);
		
	}

	public static void findMin(int start, int end) {
		if(start==end) return;
		
		//주어진 범위 내에서 가장 작은 글자를 찾는다.
		int minAlpha = 91;
		int minIdx = start;
		for(int i=start; i<end; i++) {
			if(input[i]<minAlpha) {
				minAlpha = input[i];
				minIdx = i;
			}
		}
		
		//출력에 덧붙인다.
		ans[minIdx] = input[minIdx];
		printAns();
		
		//지금 찾은 자리의 오른쪽에서 가장 작은 글자를 찾아 계속 덧붙여야지만
		//사전순으로 출력된다.
		findMin(minIdx+1, end);
		//그 다음에 왼쪽에서 찾는다
		findMin(start, minIdx);
	}
	
	public static void printAns() {
		for(int i=0; i<N; i++) {
			if(ans[i]>='A') {
				sb.append(input[i]);
			}
		}
		sb.append("\n");
	}
	
}
