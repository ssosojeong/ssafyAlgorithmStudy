package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2467 {
	static int N;//입력값 배열 크기
	static int[] arr;//입력값을 받을 배열
	static int[] container;//출력할 두 수 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		container = new int[2];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
		find();
		
		System.out.printf("%d %d\n",container[0],container[1]);
		
		br.close();
	}//main

	private static void find() {//N개 중에 2개를 조합으로 뽑아서 비교(2개만 뽑기 때문에 2중 for문으로도 충분)
		int min=Integer.MAX_VALUE;
		int p1 = 0;//포인터들
		int p2 = N-1;
		
		int sum;

		while(p1!=p2) {//같을 때는 하나의 인덱스에서 값을 가져오는 거니까 무조건 0이 되서 둘의 인덱스가 같으면 그만 돌아야한다.
			sum = Math.abs(arr[p1] + arr[p2]);
			if(min>sum) {
				min = sum;
				container[0] = arr[p1];
				container[1] = arr[p2];
			}//if
			
			int absAP1 = Math.abs(arr[p1]);
			int absAP2 = Math.abs(arr[p2]);
			
			if(absAP1 > absAP2) p1++;
			else if(absAP1<absAP2) p2--;
			else { //absAP1 == absAP2 여서 sum이 0이 되는걸 의미 더 볼 필요 없이 return
				container[0] = arr[p1];
				container[1] = arr[p2];
				return;
			}//else
			
			
		}
		
	}//find
	
}//class
