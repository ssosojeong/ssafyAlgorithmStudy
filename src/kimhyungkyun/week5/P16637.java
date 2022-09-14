//풀이방법 : 최대값을 가지는 방법을 수학적으로 고려하기가 힘드니까 괄호가 들어가서 나올 수 있는 모든 경우의 값 중 가장 큰 값을 답으로 반환하는 코드를 짜야한다.
//        괄호를 어떻게 씌워 줄 것인지가 중요한 점이다. 괄호는 안에 연산자가 하나만 있어야하고 그렇기 때문에 중복으로 괄호를 사용할 수 없으므로 주의가 필요하다.
//        백트래킹을 이용해 괄호가 들어간 부분은 계산을 안하게 해주어야 한다. 
//        만약 백트래킹을 안하고 그냥 재귀로 모든 경우를 탐색하게 된다면 괄호가 중복되는 상황이 생기면서 오답이 나온다.

package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16637 {
	static int N;//수식의 길이를 받음
	static String[] calChar;//문자열은 수정이 안되니까 각각의 char들을 문자열로 하여 수정이 가능하게함(char을 사용안하는 이유는 숫자가 2자리수가 넘어가면 char이 안된다.)
	static int maxValue;
	
	static int sumCalChar(char[] calChars) {//배열에 있는 수식을 순서대로 더해줄 메소드
		for(int i=0;i<N-2;i+=2) {
			int temp = tinySum(calChars[i],calChars[i+1],calChars[i+2]);
			calChars[i+2] = (char) (temp+'0');
			System.out.println('3');
//			System.out.printf("%c\n",calChars[i+2]);
		}
		return calChars[calChars.length-1];//연산을 하고난 마지막 인덱스에 있는 수가 최종 연산 결과
	}//sumCalChar
	
	static int tinySum(char numF, char oper, char numB) {// 2개의 항과 하나의 연산자를 계산해줄 메소드
		int numf = numF - '0';
		int numb = numB - '0';
		if(oper=='+') return numf + numb;
		else if(oper=='*') return numf * numb;
		else if(oper=='-') return numf - numb;
		return 0;//if문과 else if 문안에서 return 무조건 되니까 의미없는 return
	}//tinySum
	
	//백트래킹의 끝나는 지점을 길이로 맞추기 위해서 앞에서 부터 계산한다는 점을 이용.
	//+ 와 0 을 넣어줘서 만드는 배열이 N만큼 차면 최종적으로 앞에서 부터 계산을 하게 한다.
//	static void backTrackingDFS(int n) {//매개변수 n은 홀수번째 자리에 숫자
//		if(n==N) {
//			int res = sumCalChar(calChar);
//			if(res>maxValue) maxValue=res;
//			return;
//		}//재귀를 끝내줄 조건
//		
//		for(int i=0;i<N;i++) {
//			return;
//		}
//	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String calString = br.readLine(); // String 입력값
		calChar = new String[N];
//		for(int i=0; i<N;i++) calChar[i] = calString.charAt(i);
		
		maxValue=Integer.MIN_VALUE;
		
//		System.out.println(sumCalChar(calChar));
//		backTrackingDFS(0);
		
		br.close();
	}



}
