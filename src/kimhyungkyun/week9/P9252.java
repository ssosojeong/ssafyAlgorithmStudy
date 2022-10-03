package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9252 {
	static int[][] arr;//LCS를 기록해줄 2차원 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine(),str2 = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		char[] charArr1 = new char[str1.length()+1];//0인덱스 비워주기 위해서 
		char[] charArr2 = new char[str2.length()+1];
		for(int i=1;i<=str1.length();i++) 
			charArr1[i] = str1.charAt(i-1);
		for(int i=1;i<=str2.length();i++) 
			charArr2[i] = str2.charAt(i-1);
		
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		arr = new int[len2+1][len1+1];//열을 charArr1으로 두고 비교 0인덱스는 사용 x
		
		for(int r=1;r<=len2;r++) {
			for(int c=1;c<=len1;c++) {//같은 지점이 존재하는지 확인
				if (charArr1[c]==charArr2[r]) arr[r][c] = arr[r-1][c-1] +1;
				//만약 비교 대상과 같은 알파벳이 나왔다면 그 전의 기록 보다 +1을 해준다.
				else arr[r][c] = Math.max(arr[r-1][c], arr[r][c-1]);
				//else문을 사용하는 2가지 이유
				//1. arr[r-1][c]를 가져올 때 : 문자가 같지 않아서 이전 LCS를 이용하는경우
				//2. arr[r][c-1]를 가져올 때 : 전의 r로 비교했을 때 보다 숫자가 커져서 증가된 값을 가져와야할 경우
			}//for
		}//for
		
		int reverRow = len2;
		int reverCol = len1;
		
		int len = arr[len2][len1];

		System.out.println(len);
		
//		for(int j=reverCol;j>0;j--) {
//			if(arr[reverRow][j]!=arr[reverRow][j-1]) sb.append(charArr1[j]);
//		}
//		처음 생각했던 부분 수열 골라내는 방법인데 뒤에 틀린 방법(헷갈려서 넣어뒀어요)
		while(reverRow>=1 && reverCol>=1) {

			if(arr[reverRow-1][reverCol]==arr[reverRow][reverCol])
				reverRow--;
			else if(arr[reverRow][reverCol-1]==arr[reverRow][reverCol])
				reverCol--;
			else {
				sb.append(charArr1[reverCol]);
//				sb.append(charArr2[reverRow]);도 상관 없음 어차피 같음
				reverCol--;
				reverRow--;
			}
			
			
		}//while
		
		
		if(len!=0) {
			System.out.println(sb.reverse());
		}
		
		br.close();
	}//main
}//class
