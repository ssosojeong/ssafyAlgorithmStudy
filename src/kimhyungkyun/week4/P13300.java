package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer NK = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(NK.nextToken()); // 학생수
		int K = Integer.parseInt(NK.nextToken()); // 방당 학생 인원 제한
		
		ArrayList<Integer> arrS = new ArrayList<>();
		ArrayList<Integer> arrY = new ArrayList<>();
		
		for(int i=0;i<N;i++) { // 각 학생에 대한 성별과 학년에 대한 정보 기입 
			StringTokenizer SY = new StringTokenizer(br.readLine());
			arrS.add(Integer.parseInt(SY.nextToken()));
			arrY.add(Integer.parseInt(SY.nextToken()));
		} //for 문 끝!
		
		//////////////////////////////여기까지 값 입력 받기 끝
		
		//////////////////////////////이제 방이 몇개 필요한지 계산 시작
		int[] count = new int[12];//남녀 학년 기준으로 해서 12개의 카운트 준비 
		for(int i=0;i<N;i++) {
			if(arrY.get(i)==1) {
				if(arrS.get(i)==1) count[0]++; //남학생인 경우
				else count[1]++; // 여학생인 경우
			} else if(arrY.get(i)==2) {
				if(arrS.get(i)==1) count[2]++; //남학생인 경우
				else count[3]++; // 여학생인 경우
			} else if(arrY.get(i)==3) {
				if(arrS.get(i)==1) count[4]++; //남학생인 경우
				else count[5]++; // 여학생인 경우
			} else if(arrY.get(i)==4) {
				if(arrS.get(i)==1) count[6]++; //남학생인 경우
				else count[7]++; // 여학생인 경우
			} else if(arrY.get(i)==5) {
				if(arrS.get(i)==1) count[8]++; //남학생인 경우
				else count[9]++; // 여학생인 경우
			} else { //6학년
				if(arrS.get(i)==1) count[10]++; //남학생인 경우
				else count[11]++; // 여학생인 경우
			} 
		} //각 학생들 정렬 완료 이제 방 분배 
		
		int sumofRoom = 0;
		for(int i=0;i<12;i++) {
			sumofRoom += count[i]/K;
			if(count[i]%K!=0) sumofRoom++;
		}
		
		System.out.println(sumofRoom);
		
		br.close();
	}
}
//이상현 : list로 받고 또 count배열로 나누고 하는 것보다 처음부터 count[성별][학년]으로 받으면 코드를 많이 단축할 수 있습니다.
