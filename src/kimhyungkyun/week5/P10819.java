//풀이 방법 : N! 만큼의 경우를 빠짐없이 모두 체크하기 위해서는 dfs재귀를 통해서 할 수 있는데
//		     그냥 제귀로 하면 n^n의 경우를 모두 체크하게된다. 그래서 사용할 방법은 백트래킹


package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10819 {
	static int maxValue;//수열의 차의 최대값을 저장할 변수
	static int N;//배열의 길이
	static ArrayList<Integer> arr;// 처음 입력받은 배열을 저장할 배열(ArrayList로 안해도됌)
	static int[] moveArr;//위치가 바뀔 배열을 저장해줄 배열
	static boolean[] v;// 그냥 제귀가 아니라 백트래킹을 하기 위해서 필요한 boolean 값
	static void dfs(int n) {//n이 받을 녀석은 배열의 길이
		if(n==N) {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(moveArr[i]-moveArr[i+1]);
			}//for
			if(maxValue<sum) maxValue=sum;
			return;
		}// 끝내기 위한 조건을 알아주는 부분
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			moveArr[n] = arr.get(i);
			dfs(n+1);
			v[i] = false;
		}
	}//dfs
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//배열의 길이
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		for(int i=0;i<N;i++) arr.add(Integer.parseInt(st.nextToken()));//배열값 입력받기
		
		////////////////입력값 받기 끝
		maxValue=Integer.MIN_VALUE;
		v= new boolean[N];
		moveArr = new int[N];
		dfs(0);//root에서 한번 돌면 모든 경우를 backtracking으로 조사한다.
		
		System.out.println(maxValue);
		
	}//main
}//class
