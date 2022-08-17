package src.kimsojeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2491 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		   int N = Integer.parseInt(br.readLine());
		   
		   int[] arr = new int[N];
		   
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   for(int i=0; i<N; i++) {
			   arr[i] = Integer.parseInt(st.nextToken());
		   }
		   
		   //검사
		   int cntR=0, cntL=0;
		   int max=-1;
		   for(int i=0; i<N-1; i++) {
			   //->방향
			   if(arr[i]<=arr[i+1]) cntR++;
			   else {
				   max=(cntR>max?cntR:max);
				   cntR=0;
			   }
			   
			   //<-방향
			   if(arr[N-i-1]<=arr[N-i-2]) cntL++;
			   else {
				   max=(cntL>max?cntL:max);
				   cntL=0;
			   }
		   }
		   //마지막까지 수열이 이어질경우엔 max에 저장되지 않으므로
		   //또한 max값에는 시작점이 포함되지 않았으므로 마지막에 1을 더함
		   max = Math.max(Math.max(cntR, cntL), max) + 1;
		   
		   System.out.println(max);
	}
}


// 오현규: 코드가 간결하고 이해하기도 편합니다. ?를 사용한 코드를 처음 봐서 공부가 되었습니다!

