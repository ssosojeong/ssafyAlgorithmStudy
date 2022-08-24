import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13300_방배정_PSJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 학생수를 입력받습니당
		int N = Integer.parseInt(st.nextToken());
		// 방 배정할때 최대 인원을 입력 받습니다람쥐
		double K = Integer.parseInt(st.nextToken()); // 나중에 

		// 여자랑 남자의 반이 index에서 1~6이라고 치고 각인원수를 배열에 저장하기 위해 배열을 생성합니다리미~
		int[] girl = new int[7];
		int[] boy = new int[7];

		// 학생수 반복문을 돌리면서 반마다 인원수를 체크
		for (int n = 0; n < N; n++) {// 학생 체크 반복문 start
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 성별을 받는 변수

			int Y = Integer.parseInt(st.nextToken());// 반을 받는 변수
			if (S == 0) {// 여자일때
				girl[Y] += 1;

			} else {// 남자일때
				boy[Y] += 1;
			}
		} // 학생 체크 반복문 end
		
		int sum = 0; // 필요한 방의 합을 구할 변수
		// 여자와 남자의 각 반의 인원수를 K로 나누고 결과값을 올림한게 각 반당 필요한 방 수 이다.
		for (int i = 1; i <= 6; i++) {// 각반 반복문 돌리며 방수 더해가며 구하기 start
			
			if (1 <= girl[i] && girl[i] <= K) { // 여자의 방 개수
				sum += 1;
			} else if (K < girl[i]) {
				sum += Math.ceil(girl[i] / K);
			} // 여자의 방 개수 if 문 end
			
			if (1 <= boy[i] && boy[i] <= K) {// 남자의 방 개수
				sum += 1;
			} else if (K < boy[i]) {
				sum += Math.ceil(boy[i] / K);
			}// 남자의 방 개수 if 문 end
			
		} // 방수구하기 end

		System.out.println(sum);
	}
}
// 이상현 38-48부분 구간 나눌필요 없이 sum += Math.ceil(girl[i]/K); sum += Math.ceil(boy[i]/K); 쓰면 되지 않을까요?
