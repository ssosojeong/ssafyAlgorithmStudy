
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam15710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //xor 경우의 수
        //(2^31)^(n-1)
        //범위가 너무 크기 때문에
        //(2^31)%1000000007를 n-1번 곱해주면 답이 나온다.
        //하지만 그냥 구하면 시간초과이므로 재귀로 풀어줘야 함

        //Math.pow(2,31)을
        //int로 캐스팅할 경우: 2147483647
        //long으로 캐스팅할 경우: 2147483648
        //java의 int 범위는 -2^31~(2^31-1)이므로 2^31을 int로 캐스팅하면 당연히 오답.....
        
        System.out.println(calc((long)Math.pow(2, 31)%1000000007,n-1));

    }

    public static int calc(long x, int n) {

        if(n==0) return 1;

        if(n%2==0) {
            long tmp = calc(x,n/2)%1000000007;
            return (int)((tmp*tmp)%1000000007);
        }
        
        else return (int)((x * (long)calc(x,n-1))%1000000007);
    }

}
