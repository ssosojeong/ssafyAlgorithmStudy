//풀이 방법 : 분할 탐색 제일 작은 것을 기준으로 나눌 지점 찾았으니까 오른쪽 부터 실행 하고 오른쪽이 다 사용되었으면 왼쪽 사용하기 

package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16719 {
	static char[] arr; 
	static boolean[] v;
	static char nowMin;
	static int minIdx;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String str = br.readLine();
		arr = new char[str.length()];

		nowMin='a';//아스키코드 값이 대문자가 더 작기 때문에 이걸 이용해서 str 중에 가장 작은 알파벳을 찾아준다.
		for(int i=0;i<str.length();i++) arr[i] = str.charAt(i);
		}//for
		
		/////////////입력값 받기 끝
		
		v = new boolean[str.length()];

		findNext(0,str.length()-1);// str 길이 만큼 분할 탐색을 돌린다ㅏ.
		
		System.out.println(sb);
		
		br.close();
	}//main

	private static void findNext(int start, int end) {
		int nextIdx = findMin(start, end);
		if (nextIdx==-1) return;
		v[nextIdx] = true;
		
		for(int i=0;i<v.length;i++) 
			if(v[i]) sb.append(arr[i]);
		sb.append("\n");
		
		findNext(nextIdx+1,end);
		findNext(start,nextIdx-1);
		
	}//findNext

	private static int findMin(int start, int end) {
		int tempMin = 'a';//아스키코드가 'a'보다는 대문자는 다 작으니까
		int tempIdx = -1;//다음 후보로되는 인덱스 저장
		for(int i=start;i<=end;i++) {
			if(arr[i]-0<tempMin-0) {
				tempMin=arr[i];
				tempIdx=i;
			}//if
		}//for
		
		return tempIdx;
	}

}//class
