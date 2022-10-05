package practice_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10월5일_방배정_13300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] W = new int[7];//여학생 학년을 나타내고 idx1를 추가해서 7이다.
		int[] M = new int[7]; // 남학생

		for (int i = 0; i < N; i++) { // 학생수만큼 성별에 학년을 idx로 인원수 추가해준다.
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken()); //성별
			int grade = Integer.parseInt(st.nextToken()); // 학년
			if (sex == 0) {
				W[grade]++;
			} else {
				M[grade]++;
			}
		} // 학생수만큼 성별에 학년을 idx로 인원수 추가해준다.
//		System.out.println(Arrays.toString(W));
//		System.out.println(Arrays.toString(M));
		int count = 0;
		for (int i = 1; i <= 6; i++) { // 학년별로 방 추가해준다.
			if (W[i]!= W[i]%K == 0) {
				count+=W[i]/K;
			} else if (W[i]%K != 0) {
			
				count += W[i]/K+1;
			} 

			if (M[i]!=0 && M[i]%K == 0) {
				count+=M[i]/K;
			} else if ( M[i]%K != 0) {
				count +=M[i]/K+1;
			} 

		} // 학년별로 방 추가해준다.
		System.out.println(count);
	}// main

}
