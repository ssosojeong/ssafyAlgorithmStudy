package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15922 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		
		st = new StringTokenizer(br.readLine());
		int front=Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int sum = 0;//선분 길이의 총합
		int n =1;//while문의 인덱스 역할
		
		//N이 1이면 do while문에서 StringTokenizer가 제대로 동작하지 못하기 때문에 예외처리
		if(N==1) {
			System.out.println(end-front);
			return;
		}
		//do while 문을 쓴 이유는 front랑 end의 처음값이 첫번째 선분의 좌표가 들어와 있어야 하기 떄문에
		do {
			n++;
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			if(temp1<=end && end<=temp2) end = temp2;
			else if(end < temp1) {
				sum += (end - front);
				front = temp1;
				end = temp2;
			}
			//temp2 < end 인 경우는 end를 전에껄로 유지해야하니까 그냥 넘어간다.
			if(n==N) {
				sum += ( end - front );
			}
		} while(n<N);
		
		System.out.println(sum);
		
		br.close();
	}//main
}//class
