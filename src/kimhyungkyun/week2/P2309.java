package week2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P2309 {

	public static void main(String[] args) {
		//9명 중 7명의 합이 100인지 확인하는 모든 경우의 수 9C7 = 9C2 = 36 (시간 복잡도 안높음)
		
		Scanner sc = new Scanner(System.in);
		//9명의 난쟁이의 키를 받을 배열 만들고 값 받기
		List<Integer> nineArray = new ArrayList<Integer>();
		for(int i =0;i<9;i++) {
			nineArray.add(sc.nextInt());
		}
		
		int sum = 0;
		int len =nineArray.size();
		//j가 len-1 인덱스를 검사해주니까 i는 검사할 필요가 없다.
		for(int i=0;i<len-1;i++) {
			for(int j=i+1; j<len;j++) {
				for(int m : nineArray) {
					sum += m;
				}
				//난쟁이 키를 전부다 더해서 가짜 난쟁이 후보를 다시 뺴준다.
				sum = sum - nineArray.get(i) - nineArray.get(j);
				if (sum==100) {
					nineArray.remove(i);
					//j가 항상 i보다 뒤에 있으니까 인덱스를 하나 밀어줘야한다.
					nineArray.remove(j-1);
					//Comparator 라이브러리는 정렬을 도와주는 라이브러리
					nineArray.sort(Comparator.naturalOrder());
					for (int m : nineArray) {
						System.out.println(m);
					}
					sc.close();
					return;
				}
				sum=0;
			}
		}
		
		sc.close();
	}
	
}
