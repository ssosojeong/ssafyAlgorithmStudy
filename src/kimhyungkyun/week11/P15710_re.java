/*
 풀이방법
 -경우의 수 구하기
 (((a (xor) n1) (xor) n2) ...)의 연산을 할 때 a,n1,n2,..등등이 무엇이든 되든 
 xor연산으로 어떤 숫자도 표현할 수 있기 때문에 n번 중 마지막 한번만 b를 만들어 줄 수 있는 n이면 된다.
  그러면 마지막 n이 고정이 되서 마지막 n째 줄에 대한 경우만 체크를 안해주면 된다.
  따라서, (2^31)^(n-1)가 생길 수 있는 경우의 수 이다.
 (여기서 들 수 있는 의문이 n번째 고정되어서 나와야 하는 숫자가 임의의 i번째에 나와도 되지 않을까라는 생각을 할 수 있는데 
   결국 n번째 고정되어서 나와야 하는 숫자가 0~2^31-1 가지의 경우가 다 나오기 때문에 
   앞에서 i번째 위치에서 했던 숫자와 위치를 바꿔서 하게 되면 했던 수를 또 하게되는 중복이 발생하게 된다.)
  (위 괄호 부분이 잘 이해가 안가면 n=2 일 때, n1과 n2를 비교해보면 좀 더 쉽게 이해가능)
  결국 a와 b가 무엇인지는 경우의 수 구할 때는 필요가 없다.
  
  -나머지 구하기(숫자가 너무 크기 때문에 그냥 구하면 long 타입을 써도 안된다.)
  나머지는 모듈로 개념 이용
  예시 ) 5를 3으로 나눈 나머지는 2 
  	    여기서 5*5를 3으로 나눈 나머지는 5*5 = (3*1 +2)*5 = 3*5*1 + 2*5 => 여기서 자세히 보면 나머지는 몫에서 발생하지 않음 나머지는 나머지에 의해서 발생
  	    좀 더 심화하면 다음과 같다. 5*5 =  (3*1 +2)*(3*1 +2) = (3*1*3*1) + 2*2*(3*1) + 2*2 나머지는 나머지들 끼리의 곱에 의해서 발생됨 몫은 나머지에 영향을 미치지 못한다.
  	    따라서 5*5를 3으로 나눈 나머지를 보기 위해서 5%3=2로  (2*2)%3=1 이 나머지가 된다.
  	    이러한 모듈로 개념을 문제에 적용한다.
  	    
  	    그러면 나누는 수가 10억7이기 때문에 2^31을 10억7로 나누면 10억7보다 작은 숫자가 나온다 그 후에 마찬가지로 10억7보다 작은 숫자가 곱해지는데
  	    이것은 int형으로는 담는데 무리가 있고 long type이 8byte 2^64까지 표현할 수 있으므로 10억~=2^31 이 2개 있어도 long type은 표현할 수 있다.
  	    따라서 long type을 이용해서 나머지들을 구한다.
  
  근데 또 그냥 모듈로 개념만 넣고 for문 돌려서는 시간초과가 떠서 메모라이징 분할 정복 방법으로 해야 시간 초과가 안뜬다.
 */
package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P15710_re {
	static long p = (long)Math.pow(2, 31);
	static int q = (int)Math.pow(10, 9)+7;
	static int r = (int) (p % q);// 많이 사용할 숫자이니까 그냥 미리 한번 구해놓기
	//그냥 배열을 생성하면 메모리 초과가 떠서 map을 이용해서 필요한 상황에 필요한 값만 저장
	static Map<Integer,Integer> map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Integer.parseInt(st.nextToken());
		Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int N=n-1;//-1 때문에 헷갈려서 N으로 봄
		
		map = new HashMap<>();
		map.put(0, 1);
		map.put(1, r);
		/*
		분할 정복으로 (2^31)^N의 나머지를 찾으면 된다.
		N이 짝수 이면
		(2^31)^(N/2)*(2^31)^(N/2)로 나머지를 구할 수 있다 ((2^31)^(N/2)의 나머지들 끼리의 곱의 나머지를 구하면 된다.)
		N이 홀수 이면
		(2^31)^((N-1)/2)*(2^31)^((N-1)/2)로 나머지를 구하고 그 나머지랑 2^31의 곱을 (10^9+7)의 나머지를 구하면 된다.
		근데 분할 정복을 할 때 반복이 생기면 그냥 안되니까 memo를 이용해준다.
		*/
		int result = findMod(N);
		
		System.out.println(result);
//		System.out.println(r);
		br.close();
	}//main

	private static int findMod(int n) {
		if (n==0) return map.get(0);
		else if(n==1) return map.get(1);
		
		if(n%2==0) {//짝수
			if(map.containsKey(n/2)) {
				int temp = map.get(n/2);
				int result = (int)((((long)temp*temp))%q);
				map.put(n/2, result);
				return result;
			}//if
			else {
				int temp = findMod(n/2);
				map.put(n/2, temp);
				int result = (int)((((long)temp*temp))%q);
				map.put(n, result);
				return result;
			}//else
		} else {//홀수
			if(map.containsKey((n-1)/2)) {
				int temp = map.get((n-1)/2);
				int result = (int)((( (((long)temp*temp))%q ) * r) % q);
				map.put(n, result);
				return result;
			}
			else {
				int temp = findMod((n-1)/2);
				map.put((n-1)/2 , temp);
				int result = (int)((( (((long)temp*temp))%q ) * r) % q);
				map.put(n, result);
				return result;
			}
		}
		
	}//findMod
}//class
