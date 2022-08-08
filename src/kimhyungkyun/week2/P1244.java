package week2;

import java.util.Scanner;

public class P1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 전구의 갯수
		int[] arr = new int[T]; // 전구의 상태를 나타내줄 배열
		for(int i=0;i<T;i++) {
			arr[i] = sc.nextInt();
		}
		
		int N = sc.nextInt(); // 학생수 입력 받기
		
		int[][] student = new int[N][2];
		for(int i=0;i<N;i++) {
			student[i][0] = sc.nextInt(); //성별
			student[i][1] = sc.nextInt(); //학생이 받는 수
		}
		
		for(int i=0;i<N;i++) {
			
			if(student[i][0]==1) {//남학생이 일처리하는 경우
				int key = student[i][1];
				for(int j=key-1;j<T;j+=key) {
					arr[j] = 1-arr[j];
				}
			} else { //여학생이 일처리하는 경우
				int key = student[i][1]-1;
				int comp=1;
				arr[key] = 1-arr[key];
				while(true) {
					if(key-comp<0 || key+comp>=T) {
						 break;
					} else if (arr[key-comp]==arr[key+comp]) {
						arr[key-comp] = 1- arr[key-comp];
						arr[key+comp] = 1- arr[key+comp];
						comp++;
					} else {
						break;
					} // elseEnd(여학생)
				} //whileEnd
			} //elseEnd(일처리)
		} //학생수만큼 forEnd
		
		for(int i=0; i<T;i++) {
			if(i%20==0 && i!=0) System.out.println();
			System.out.printf("%d ",arr[i]);
		}
		
		sc.close();
	}
}
