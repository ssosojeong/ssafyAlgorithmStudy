package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P16637_re{
	static int N;
	static ArrayList<char[]> arrL;
	static ArrayList<Integer> arrNum;//숫자를 담을 배열
	static ArrayList<Character> arrChar;//연산자를 담을 배열
	static int maxValue;
	static String str;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		arrL = new ArrayList<>();
		for(int i=0;i<Math.pow(2, N/2);i++) {//괄호 하나당 최대 하나의 연산자만을 가질 수 있으니까 우선 모든 괄호의 경우를 나타내주기 위해 
			String binString = Integer.toBinaryString(i);
			StringBuffer sb = new StringBuffer();
			
			if(binString.length()<N/2) {
				for(int j=0;j<(N/2-binString.length());j++) {
					sb.append(0);
				}//for
			}//if
			sb.append(binString);
			char[] charArr = sb.toString().toCharArray();
			if(check(charArr)) {//1이 인접해있지 않으면 배열에 담아주기
					arrL.add(charArr);
			}//if
		}//for
		
		arrNum = new ArrayList<>();
		arrChar = new ArrayList<>();
		arrNum.add(str.charAt(0)-'0');
		for(int i=1;i<N;i+=2) {//int와 char 배열로 각각 저장
			arrChar.add(str.charAt(i));
			arrNum.add(str.charAt(i+1)-'0');
		}//for
		ArrayList<Integer> arrNumClone = (ArrayList<Integer>) arrNum.clone();//arrNum의 값이 바뀔텐데 그 때 다시 돌아올 때 clone을 이용함
		
		for(int i=0;i<arrL.size();i++) {//괄호가 있는 만큼 우선적으로 더 해주기
			System.out.println(Arrays.toString(arrL.get(i)));
			for(int j=0;j<N/2;j++) {
				if(arrL.get(i)[j] == '1') {
					int temp1 = arrNum.remove(j);
					int temp2 = arrNum.remove(j);
					char tempOper = arrChar.remove(j);
					int temp = calc(temp1,tempOper,temp2);
					arrNum.add(j,0);
					arrNum.add(j,temp);
					arrChar.add(j,'+');
				}//if
			}//for
			System.out.println(Arrays.toString(arrNum.toArray()));
			System.out.println(Arrays.toString(arrChar.toArray()));
		}//for
		
//		for(int i=0;i<arrL.size();i++) {
//			for(int j=0;j<N/2;j++) {
//				System.out.printf("%c ",arrL.get(i)[j]);
//			}
//			System.out.println();
//		} //oper에 대한 정보 잘 넣음
		
		///////위에서 생길수 있는 모든 괄호의 경우의 수를 구했으므로 각 경우에 대한 계산 실행

		maxValue = Integer.MIN_VALUE;
		for(int i=0;i<arrL.size();i++) {//가능한 모든 경우가 arrL.size만큼 이므로 이 중에서 가장 큰 값을 찾으면 된다.
//			char[] cases = arrL.get(i);
//			StringBuffer sbSol = new StringBuffer();
//			sbSol.append(str);
//			for(int j=0;j<N/2;j++) {
//				if(cases[j]=='1') {
//					String subStrBuf = sbSol.substring(0, 2*j);
//					sbSol = new StringBuffer();
//					String temp = calc(str.charAt(2*j),str.charAt(2*j+1),str.charAt(2*j+2));
//					sbSol.append(subStrBuf);
//					sbSol.append(temp);
//					sbSol.append("+0");
//					sbSol.append(str.substring(2*j+3, str.length()));
//					System.out.println(sbSol);
//					System.out.println(Arrays.toString(arrL.get(i)));
//				}
//			}//for
		}//for
		
		
		
		br.close();
	}//main
	static int calc(int n1, char oper , int n2) {
		if(oper=='+') return (n1+n2);
		else if(oper=='-') return (n1-n2);
		else if(oper=='*') return (n1*n2);
		return 0;
	}//calc
	static boolean check(char[] charArr) {
		for(int i=0;i<charArr.length-1;i++) {
			if(charArr[i]=='1' && charArr[i+1]=='1') {
				return false;
			}
		}
		return true;
	}
	
}//class