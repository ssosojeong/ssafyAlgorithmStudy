package algorithmstudy;

import java.util.ArrayList;
import java.util.Scanner;

public class P2635 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//수열의 길이가 길어지기 위한 1가지 추측
		//1. 100 - ㅁ 를 해서 나온 값이 ㅁ 보다는 작아야 다음 수가 만들어 지는데 유리하므로 ㅁ은 100/2 보다 큰 값만 보면된다.
		int index=0; // i가 인덱스의 의미로 사용안되기 때문에 인덱스를 따로 선언해주기
		int maxLength = Integer.MIN_VALUE;//길이가 최대인지 저장해줄 배열
		ArrayList<Integer> longestArray=null; // 가장 긴 배열을 저장할 배열
		
		for(int i=(N/2);i<=N;i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(N);
			arr.add(i);
			index = 0; //배열이 i가 바뀔 때 마다 초기화 되기 때문에 index도 함께 초기화 해주어야한다.
			while(arr.get(index)>=0) { //arr의 마지막 원소가 음수이면 반복문을 그만하게 한다.
				arr.add(arr.get(index)-arr.get(index+1)); //배열의 뒤에서 두번째 있는 값에서 끝에 있는 값을 뺴서 리스트에 추가해주기
				index++;
			}
			if(maxLength<index) {
				maxLength = index; //가장 긴 배열인지 확인해주기 위해서 최신화 하기
				longestArray = (ArrayList<Integer>) arr.clone(); //가장 긴 배열을 저장하기
			}
		}
		
		
		////////////////////////////////////////출력 라인
		System.out.println(maxLength); // index를 받은거니까 길이는 +1을 해주어야한다. 그렇지만 현재 음수 한 개 까지는 받은 상태이기 때문에 따로 -1을 해주지 않아도 된다.
		for(int i=0;i<longestArray.size()-2;i++) { // 가장 긴 배열 저장한거 출력하기 , -2인 이유는 음수까지 하나 받았기 때문에
			System.out.printf("%d ",longestArray.get(i));
		}
		
		
		sc.close();
	}
}
//P소정 : 코드가 참 간결하네요! 일단 N/2 생각해내신것도 신기하고, index 활용하는것도 최대한 간단히 코드구성하신게 보입니다!
