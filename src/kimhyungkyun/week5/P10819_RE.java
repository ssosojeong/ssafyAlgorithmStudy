// 풀이 방법 : N이 8이하이기 때문에 반복문을 돌리기에 충분한 숫자이다.
//         최대 8! 만큼의 경우를 비교해봐야한다.

// 아쉬운 점  : 1. 같은 덧셈이 반복이 너무 많다.
// 	        2. 팩토리얼 갯수만큼 확인할 수 있는데 지금은 n^n만큼 확인한다. 
//			=> 런타임에러

package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10819_RE {
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static int maxValue;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//배열의 길이
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr.add(Integer.parseInt(st.nextToken()));//배열값 입력받기
		
		////////////////입력값 받기 끝
		ArrayList<Integer> arrClone = (ArrayList<Integer>) arr.clone(); // 전역 변수가 체인지를 하고 나서 원래  배열을 기억해줄 복사본
		int sum =0;
		for(int i=0;i<arrClone.size()-1;i++) {
			sum += Math.abs(arrClone.get(i)-arrClone.get(i+1));
		}
		maxValue=sum;
		findMax(arrClone);//변경한 위치를 원래대로 돌려주기 위한	 변수
		System.out.println(maxValue);
		br.close();
	}//main
	@SuppressWarnings("unchecked")
	private static void findMax(ArrayList<Integer> arrClone) {
		for(int i=0;i<arr.size()-1;i++) {
			for(int j=0;j<arr.size();j++) {
				int move = arr.get(i);
				arr.remove(i);
				arr.add(j, move);
				int sum = 0;
				for(int m=0;m<arr.size()-1;m++) {
					sum += Math.abs(arr.get(m)-arr.get(m+1));
				}//for
				if(sum>maxValue)  maxValue = sum;
				arr = (ArrayList<Integer>) arrClone.clone();
			}//for
		}//for
	}//findMax
}//class
