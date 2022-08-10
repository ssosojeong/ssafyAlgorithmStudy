package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//학생의 수 N 받기
		int N = sc.nextInt();
		//처음 줄 선 순서대로 학생들의 위치를 나타내줄 배열
		List<Integer> studentList = new ArrayList<>();
		//뽑은 번호 입력 받기
		int[] number= new int[N];
		for(int i=0; i<N;i++) {
			number[i]=sc.nextInt();
			studentList.add(i+1);
		}
		
		//뽑은 수만큼 앞에 있는 사람이랑 자리 바꾸기(제일 앞자리는 무조건 0을 뽑으니까 인덱스가 1일 때부터 실행)
		for(int i=1;i<N;i++) {
			change(studentList, i-number[i],i);
		}
		
		for(int i=0; i<N;i++) {
			System.out.printf("%d ",studentList.get(i));
		}
		
		sc.close();
	}
	
	//배열의 값을 바꿔줄 함수(매개변수는 바꿀 배열, 나랑 자리를 바꿀 앞에 서있는 사람 인덱스 , 내 자리 인덱스)
	public static void change(List<Integer> studentList,int indexOther , int indexMe) {
		studentList.add(indexOther,studentList.get(indexMe));
		studentList.remove(indexMe+1);
	}
}

//김소정: 제가 이해하기론 이렇게 진행하면 번호가 앞자리 사람이랑 바뀌는 것 같은데 밀리도록 해야 하는거 아닐..까요..? 아니면 이렇게 진행해도 결과적으론 같은건가요??