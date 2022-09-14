package src.kimsojeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class exam2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> heights = new ArrayList<>();
		int sum = 0;

		for(int i=0; i<9; i++){
			int tmp = Integer.parseInt(br.readLine());
			heights.add(tmp);
			sum += tmp;
		}
		Collections.sort(heights);

		//진짜 난쟁이들의 키 합 = 100cm -> 나머지 애들은 sum-100
		sum -= 100;
		int tmp;
		boolean flag = false;
		for(int i=0; i<8; i++){
			if(flag) break;
			tmp = heights.get(i);
			for(int j=i+1; j<9; j++){
				//고른 두 명 키의 합이 sum-100과 같으면?
				//리스트에서 지우고 모든 for문을 종료시킨다.
				//답인거 아무거나 출력하라고 했으니까 따로 고려할 요소는 없음
				if(tmp+heights.get(j)==sum){
					heights.remove(i);
					heights.remove(j-1);
					flag=true;
					break;
				}
			}
		}

		for(int height:heights){
			System.out.println(height);
		}

	}
}