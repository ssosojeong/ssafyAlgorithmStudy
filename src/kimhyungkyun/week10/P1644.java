package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1644 {
	static int N,cnt;//자연수 N과 소수의 합이 N이 될 갯수
	static List<Integer> list;//N보다 작거나 같은 소수를 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		list = new ArrayList<>();
		setList();//소수 만들기
		
//		System.out.println(list.toString());
		
		/////////소수 배열 만들기 끝
		cnt = 0;
		dofind();
		
		System.out.println(cnt);
		sc.close();
	}//main

	private static void dofind() {
		int tem1 = 0;//list의 인덱스를 나타냄
		int tem2 = -1;
		int sum = 2; //같은 연산의 반복을 줄이기 위해 누적합을 이용
		int len = list.size();
		
		if (N==2) {
			cnt++;
			return;
		}
		while(tem1<len) {//  list.get(tem1)<=N 와 같은 조건
			if(sum<=N) {
				tem1++; //자리를 바꾸고 더해준다.
				if(tem1==len) break;//tem1 이  len이랑 같아질 때  Index에러 때문에 빼줌
				sum += list.get(tem1);
			}
			else if(sum>N) {
				tem2++; //자리를 바꾸고 빼준다.
				sum -= list.get(tem2);
			}
				
//			System.out.println(sum);
			if (sum==N) cnt++;
		}//while
		
	}//dofind

	private static void setList() {
		boolean[] temp = new boolean[N+1];//소수가 가능한 값(인덱스)은 true로
		int tem=2;//소수 검사는 2부터 시작
		
		while(tem<=N) {
			if(!temp[tem]) {//처음 등장하는 소수는 넣어 주고 그 소수의 배수는 true로 해서 제외 시켜준다
				list.add(tem);
				for(int i=tem;i<=N;i += tem) {
					temp[i]=true; //i=tem일 때는 사실 안해줘도 된다.
				}//for
			}//if
			
			tem++;
		}//while
		
	}//setArr
	
}//class
