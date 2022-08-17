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
//이상현 : 변수명이 너무 긴데 짧게 줄이는건 어떨까요?
//김형균 : 가독성이 좋을까 싶어서 그랬는데 길이가 너무 길어도 별로일까요?

//김소정 : 어차피 count와 max를 비교하는 작업은 수열이 끝날 때 가장 중요하니까 else(29/36)에 넣어주면 연산 횟수가 더 줄지 않을까요?
//			(물론 이러면 마지막까지 수열이 이어질 때에 대해 처리가 안되니까 추가적으로 한번 더 비교해줘야 합니다!)
//김형균 : 무슨 말씀인지 이해가 갈 것 같습니다. 그래도 한번만 더 확실하게 여쭤보고 싶어요!
