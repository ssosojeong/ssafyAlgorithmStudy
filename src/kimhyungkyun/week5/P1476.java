//풀이 방법
//E,S,M은 15,28,19의 나머지 단 나머지가 0일때는 그 수를 의미
//E+15x=S+28y=M+19z 에서 E,S,M은 주어지는 값이고, 
//위 삼항을 만족시키는 x,y,z를 브루트포스를 통해서 찾아준다.

package week5;

import java.util.Scanner;

public class P1476 {
	static int earth;
	static int sun;
	static int moon;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int x=0,y=0,z=0;
		do {//do while문으로 쓴건 한번은 일단 돌아서 입력된 값이 다 같을 때를 고려해줘야하니까
			earth = E+15*x;//여기서 또 정의한 것은 x,y,z의 값이 변함에 따라
			sun = S+28*y;
			moon= M+19*z;
			int minNum = Math.min(Math.min(E+15*x, S+28*y),M+19*z);
			if(minNum==E+15*x) x++;
			else if(minNum==S+28*y) y++;
			else if(minNum==M+19*z) z++;
		} while(earth!=sun || sun!=moon);
		
		System.out.println(earth);
		sc.close();
	}
}
