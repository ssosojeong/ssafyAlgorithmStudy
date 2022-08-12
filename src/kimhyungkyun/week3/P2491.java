package algorithmstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 입력 받을 수열 갯수
		StringTokenizer st = new StringTokenizer(br.readLine()); // 수열 입력 받기
		
		int ascendingOrderMax =1; //오름차순 중 가장 길이가 길 때 값 저장 (얘가 1이 아니면 N이 1일 때 값이 0이 나옴)
		int descendingOrderMax = 1; //내림차순 중 가장 길이가 길 때 값 저장 (얘가 1이 아니면 N이 1일 때 값이 0이 나옴)
		
		
		int[] arr = new int[N]; 
		for(int i=0;i<N;i++) { // 수열값 입력 받기
			arr[i]=Integer.parseInt(st.nextToken());
		}// 수열값 입력 받기 끝
		int ascendCount =1;
		int descendCount =1;
		for(int j=0;j<N-1;j++) { // 시작 부분 이후로 얼마나 조건에 만족하는 원소가 있는지 확인할 for문
			if(arr[j]<=arr[j+1]) {//오름차순용 카운트
				ascendCount++;
				ascendingOrderMax = Math.max(ascendingOrderMax, ascendCount);
			} else {
				ascendCount=1;
			} //오름 차순용 카운트 끝
			
			if(arr[j]>=arr[j+1]) { //내림 차순용 카운트 
				descendCount++;
				descendingOrderMax= Math.max(descendingOrderMax, descendCount);
			} else {
				descendCount=1;
			}//내림 차순용 카운트 끝
		}
		
		System.out.print(Math.max(ascendingOrderMax, descendingOrderMax));
		
		br.close();
	}
}
