//Ǯ�� ��� : 


package study;

import java.util.Scanner;

public class P1094 {
	static int X; // �������� ������ ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		
		divide(64);//ó�� ������ �ִ� ���� ����
		
		sc.close();
	}//main
	
	private static void divide(int start) {
		int cnt = 0;
		for(int i=0;i<=6;i++) {
			if((X & (1<<i)) > 0 ) {
				cnt++;
			}//if
		}//for
		System.out.println(cnt);
	}//divide
}//class
