package day0927.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1094 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i=0; i<8; i++) {	//64를 오른쪽으로 7번 쉬프트할 수 있다.
			if(X-(64>>i) >=0) {		//64를 i번 쉬프트 한 값이 X보다 작거나 같다면
				X -= (64>>i);		//그만큼 빼준다.
				ans++;				//한번 했기 때문에 ans를 증가시켜준다.
			}
			
			if(X==0) break;			//길이의 합이 X가 되면(지금 계속 빼줬으니까 0이 되면) 나간다.
		}
		
		System.out.println(ans);
	}
}