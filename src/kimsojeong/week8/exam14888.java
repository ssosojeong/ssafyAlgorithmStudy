package day0927.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14888 {
	static int min, max, N;
	static int[] intArr, oper, visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		min = 1000000001;
		max = -1000000001;
		intArr = new int[N];
		visit = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void dfs(int cnt) {
		if(cnt==N-1) {	//연산자의 순서를 다 골랐다면 -> 계산
			int tmp = intArr[0];
			for(int i=0; i<N-1; i++) {
				int curOper = visit[i];
				switch(curOper) {
				case(0):
					tmp+=intArr[i+1];
					break;
				case(1):
					tmp-=intArr[i+1];
					break;
				case(2):
					tmp*=intArr[i+1];
					break;
				case(3):
					tmp/=intArr[i+1];
					break;
				}
			}
			
			if(tmp>max) max = tmp;
			if(tmp<min) min = tmp;
			
		} else {
			for(int i=0; i<4; i++) {
				if(oper[i]>0) {			//만약 아직 해당 연산자를 고를 수 있다면
					visit[cnt] = i;		//고르고
					oper[i]--;			//골랐으니까 해당 연산자의 개수 줄여주고
					dfs(cnt+1);			//다음 자리 재귀 보내고
					oper[i]++;			//갔다 왔으니까 연산자 개수 복구
				}
			}
		}
	}

}
