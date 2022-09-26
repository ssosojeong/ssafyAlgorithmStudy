//풀이 방법 : 덧셈,뺄셈,곱셈,나눗셈의 경우를 누적합으로 구한 뒤 연산자를 숫자로 permutation으로 n-1! 경우를 나타내고 그 각 부분합의 경계값보다 작으면 덧셈,뺄셈,곱셈,나눗셈을 하게 하였습니다.

package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
	static int N;//수열의 갯수
	static int[] arr;//수열이 들어갈 변수
	static boolean[] v;//중복을 제한 하주기 위한 방문기록 배열
	static int[] operCnt; //연산자의 갯수가 들어갈 변수
	static int[] oper;//연산자의 경우를 가지고 있을 배열 0 덧셈,1뺼셈,2곱셈3,나눗셈
	static int maxVal , minVal;//최대,최소값
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) arr[n] = Integer.parseInt(st.nextToken()); 
		
		operCnt = new int[4]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			if(i==0) operCnt[i] = Integer.parseInt(st.nextToken());
			else operCnt[i] = operCnt[i-1] + Integer.parseInt(st.nextToken());
		}
		
		/////////////////////////////입력값 받기 끝
		
		oper = new int[N-1];
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		v = new boolean[N-1];
		
		findVal(0);
		
		System.out.println(maxVal);
		System.out.println(minVal);
		br.close();
	}//main
	
	
	static void findVal(int start) {
		if(start==N-1) { //N이 숫자의 갯수이기 때문에 연산자는 그보다 하나 작기 때문에 빼줘야한다.
			int val = doOper();
			if(val > maxVal) maxVal = val;
			if (val < minVal) minVal = val;
			return;
		}//기저조건
		
		for(int i=0;i<N-1;i++) {
			
			if(!v[i]) {
				v[i] = true;
				oper[start]=i;	
				findVal(start+1);
				v[i] = false;
			}//if
			
		}//for
		
	}//findVal()


	private static int doOper() {
		int temp = arr[0];
		for(int i=0;i<N-1;i++) temp = operation(temp,arr[i+1],oper[i]);
		
		return temp;
	}


	private static int operation(int temp, int arrI, int operI) {
		if(operI<operCnt[0]) return temp + arrI;
		else if(operI<operCnt[1]) return temp - arrI;
		else if(operI<operCnt[2]) return temp * arrI;
		else return temp/arrI;
	}//operation
	
	
}//class
