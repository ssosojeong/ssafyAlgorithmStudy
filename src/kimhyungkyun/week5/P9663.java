//풀이 방법 : 1.퀸이 공격을 하지 못하려면 일단 하나의 행과 하나의 열에는 하나의 퀸만 올 수 있다.
//         2. 퀸이 존재하는 대각선 라인에는 다른 퀸이 들어올 수 없다.
//         =>순서대로 가능한 모든 경우를 확인한다.
//           만약 백트래킹을 사용하지 않는다면  n^n으로 최대 14^14의 경우를 따져야하기 때문에 무조건 runtime 에러가 발생
//           결론은 기존 백트래킹 방법에서 대각선까지를 고려해서 풀어야한다.

//         arr 배열의 인덱스는 행을 나타내고  그 안에 값은 몇 번째 열에 있는지를 나타낸다.
//         즉, arr[2] = 1 이라고 한다면 3번째 행에는 2번째 열의 위치에 퀸이 존재한다는 의미이다.
//         백트래킹에 문제에 해당하는 조건을 만족 시키는 경우만 숫자를 넣을 것이고 그렇게 배열이 N-1인덱스 까지 채우게 된다면
//         카운트를 해줘서 그 경우는 되는 것임을 판단하고 다음 경우를 고려한다.

package week5;

import java.util.Scanner;

public class P9663 {
	static int N;//퀸의 갯수
	static int cnt;//가능한 경우가 몇개인지 체크해줄 변수
	static int[] arr;//문제의 조건을 만족시키는 인덱스를 저장할 배열
	static void backTracking(int n) {//n번째 행 퀸 위치 선정해서 arr배열에 넣기 위한 메서드
		if(n==N) {
			cnt++;
			return;
		}//if배열이 다 채워 졌을 때
		
		for(int i=0;i<N;i++) {
			arr[n]=i;
			if(check(n)) // n번째
				backTracking(n+1);
		}//for
//		System.out.println();
	}//backTracking
	private static boolean check(int n) {
		for(int i=0;i<n;i++) {
			if(arr[i]==arr[n]) return false;//arr의 n번째 행에 새롭게 들어온 퀸의 인덱스가 이전에 들어온 퀸의 인덱스와 겹치면 false
			else if(Math.abs(arr[n]-arr[i])==n-i) return false;
			//n-i만큼의 행의 길이와 배열 안에 있는 퀸의 인덱스의 차(열의 길이)가 같으면 같은 대각선 라인에 있는 것을 의미한다.
			//왼쪽으로 대각선에 있는 경우는 n-i==arr[n]-arr[i]>0일때 확인 , 오른쪽 대각선에 있는 경우는  n-i==arr[n]-arr[i]<0 로 잡아낼 수 있다.
			//n이 새롭게 들어올 때 마다 i가 0부터 새로 넣을 n전까지 모든 행을 체크해주니까 빠짐없이 모든 대각선을 피할 수가 있다.(모든 대각선을 피할 수 있는 이유가 중요!!)
		}//그렇게 if 문을 잘 통과 했다면 문제가 생기지 않는 경우이다.(여기서 깊이(행)가 n=0인 경우는 이 for문을 돌지 않고 바로 true로 반환이 된다.
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		cnt=0;
		backTracking(0);
		
		System.out.println(cnt);
		
		sc.close();
	}//main
}//class
