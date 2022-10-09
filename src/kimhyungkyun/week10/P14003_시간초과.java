package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14003_시간초과 {
	static int[] arr,dp;
	static List<Integer> LIS;
	static int idx,incIdx;//기준이 되어줄 인덱스
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];//0인덱스 버림
		for(int i=1;i<=N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		////////////////입력값 받기 끝
		
		dp = new int[N+1];
		LIS = new ArrayList<>();//LIS는 최대 N까지 들어가고 최장증가수열이 들어갈꺼기 때문에 List를 사용 배열로 해도 가능
		
		LIS.add(Integer.MIN_VALUE);//0인덱스 버림(밑에서 값비교를 편하게 해주기 위해서 0정수중 가장 작은 값을 넣어둠)
		LIS.add(arr[1]);//첫번째 인덱스에다가 넣어줌
		dp[1] = 1;//몇번째 수인지를 인덱스 dp에다 기록해줌
		idx=2;// 제일 처음 들어오는 수는 처리를 해줬으니까 그 다음 인덱스 부터 while문을 돌면서 비교를 해준다.
		incIdx =2;
		while(idx<=N) {
			for(int i=LIS.size()-1;i>=1;i--) {//LIS에 들어 있는 값과 idx에 의헤 새롭게 들어오는 값 비교해서 갱신
				if(arr[idx]>LIS.get(LIS.size()-1)) {
					dp[idx]=incIdx++;
					LIS.add(arr[idx]);
					break;
				}//if
				if(arr[idx]<=LIS.get(i) && arr[idx]>LIS.get(i-1)) {
					dp[idx] = i;
					LIS.remove(i);
					LIS.add(i,arr[idx]);
					break;
				}//if
				
			}//for
			idx++;
		}//while
		
		System.out.println(incIdx-1);
		List<Integer> list = new ArrayList<>();//뒤에서부터 뽑아줘야 해서 배열이 하나 필요하다.
		int maxIdx = incIdx-1;
		for(int i=arr.length-1;i>=1;i--) {
			if(maxIdx==dp[i]) {
				list.add(arr[i]);
				if(--maxIdx==0) break;//이미 뽑아낼 정보는 다 뽑아 냈으니까 더 하지말고 break;
			}
		}//for
		for(int i=list.size()-1;i>=0;i--) 
			System.out.printf("%d ",list.get(i));
//		System.out.println();
//		System.out.println();
//		System.out.print("LIS");
//		System.out.println(LIS.toString());
//		System.out.print("dp");
//		System.out.println(Arrays.toString(dp));
//		System.out.print("arr");
//		System.out.println(Arrays.toString(arr));
		br.close();
	}//main
}//class

//a+=b가 a=a+b보다 빠른 이유가 뭔가요?
//+=은 기존의 리스트 객체 자체에 원소를 덧붙이는 역할을 합니다.
//= +는 기존의 리스트를 복사하여 새로운 리스트 객체를 만들고, 거기에 원소를 덧붙인 뒤 그 레퍼런스를 대입하는 역할입니다.
