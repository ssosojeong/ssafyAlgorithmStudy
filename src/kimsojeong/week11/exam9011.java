package text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam9011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			//compare = 어떤 수의 상대적인 위치
			int[] compare = new int[N];
			for(int i=0; i<N; i++) {
				//지금 보는 원소가 2라는 건
				//지금 원소보다 작은 수가 2개 있다는 것
				//지금 원소 앞에 있는 원소들 중 1번과 2 번은 그냥 두고 해당 원소는 3번이 된다.
				//그리고 원래 3번원소는 4번이, 4번 원소는 5번이 된다.
				for(int j=0; j<i; j++) {
					if(compare[j]>=arr[i]) {
						compare[j]++;
					}
				}
				compare[i] = arr[i];
			}

			//만약 compare 배열에 유효하지 않은 값이 들어있거나,
			//1부터 N까지의 수가 모두 한번씩 들어있지 않다면, 그건 불가능한 것
			boolean flag = true;
			StringBuilder tmpSb = new StringBuilder();
			for(int n=0; n<N; n++) {
				if(compare[n]>=N || compare[n]<0) {
					flag = false;
					break;
				}else {
					tmpSb.append((compare[n]+1)+" ");
				}
			}
			
			if(flag) {
				sb.append(tmpSb.toString()+"\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.print(sb);
	}	
	
}
