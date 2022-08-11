package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] papers = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
		} // 정보 입력 받기 끝
		int sum=0;
		int[][] plane = new int[100][100];
		for(int n=0;n<N;n++) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++){
					if(plane[papers[n][0]+i][papers[n][1]+j]==0) {
						plane[papers[n][0]+i][papers[n][1]+j]=1;
						sum++;
					}
				}
			}
		}//N개 다 색칠
		
		System.out.println(sum);
	
		br.close();
	}
}
