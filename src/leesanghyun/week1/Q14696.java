package src.leesanghyun.week1;

import java.util.*;
import java.io.*;

public class Q14696 {
//4의 갯수 비교->3의 갯수 비교 -> 2의 갯수 비교 -> 1의 갯수 비교
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			//A가 갖고있는 도형 세기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] A = new int[5];//1,2,3,4 값이 들어가야 하므로 5
			for (int j = 0; j < a; j++) {
				A[Integer.parseInt(st.nextToken())]++; // j=도형의 모양. 하나씩 더해질 때마다 해당 배열값을 증가시킴
			}
			//B가 갖고 있는 도형 세기
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[5];//1,2,3,4 값이 들어가야 하므로 5
			for (int j = 0; j < b; j++) {
				B[Integer.parseInt(st.nextToken())]++;// j=도형의 모양. 하나씩 더해질 때마다 해당 배열값을 증가시킴
			}
			//순차적으로 A[4] B[4]부터 비교~
			for (int j = 4; j >= 1; j--) {
				if(A[j]>B[j]) {
					sb.append("A\n");
					break;
				}
				else if(A[j]<B[j]) {
					sb.append("B\n");
					break;
				}
				else if(j==1) {
					sb.append("D\n");
					break; // 안써도 되지만 j--,j>=1 과정을 다시 겪기 싫어서
				}
			}
		}
		System.out.println(sb);//모았던 스트링빌더 출력
	}
}
