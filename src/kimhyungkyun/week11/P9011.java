package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		T : for(int tc=1;tc<=TC;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arrR = new int[n+1];//0인덱스 버림
			int[] arrS = new int[n+1];
			boolean[] v = new boolean[n+1];//이미 등록한 숫자면 다음 숫자를 채택
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<=n;i++) arrR[i] = Integer.parseInt(st.nextToken());
			
			/////////////////입력값 받기 끝
			
			//n이 100까지 밖에 안되서 O(n^2)이 괜찮을꺼라 생각하였습니다.
			for(int i=n;i>=1;i--) {
				int temp=0;//arrS[i]를 결정해줄 변수
				int rInt = arrR[i];
				
				int idx =1;
				while(temp<rInt) {//temp와 arrR이 같아질 때 까지
					if(!v[idx++]) temp++;
					if(idx>n) {//불가능한 경우
						sb.append("IMPOSSIBLE\n");
						continue T;
					}//if
				}
				//rInt만큼 작은 녀석들을 가지려면 몇 번째 녀석까지 앞에 있어야 하는걸 알았다.
				
				//그런데 거기서 +되서 나온 idx를 arrS[i]로 취하려 하니까  idx는 이미 i보다 큰 i+1~n사이에서 사용된 수일 수 있기 때문에 v[idx]가 true가 되지 않은 곳 까지 찾으러간다.
				while(v[idx]) {
					idx++;
					if(idx>n) {//불가능한 경우
						sb.append("IMPOSSIBLE\n");
						continue T;
					}//if
				}//while
				
				//드디어 가능한 녀석을 찾았다.
				v[idx]=true;
				arrS[i] = idx;
				
				
			}//for
			
			//이제 arrS를 다 찾아줬으니까 sb에 넣어준다.
			for(int i=1;i<=n;i++) sb.append(arrS[i]+" ");
			sb.append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}//main
}//class
