package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class exam1644{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //에라 어쩌구로 소수 배열을 구해놓는다.
        boolean[] isNotPrime = new boolean[N+1];
        ArrayList<Integer> prime = new ArrayList<>();
        isNotPrime[0]=isNotPrime[1]=true;
        for(int i=2; i<= N; i++){
            if(isNotPrime[i]) continue;
            prime.add(i);
            for(int j=2*i; j<=N; j+=i){
                isNotPrime[j] = true;
            }
        }
        int size = prime.size();

        //시작점, 끝점, 누적합, 정답
        int left = 0;
        int right = 0;
        int sum = 2;    //prime.get(0)으로 할 경우 N==1인 코너 케이스에서 에러 발생
        int ans = 0;

        while(left<=right && right<prime.size()){
            //만약 sum이 N보다 크거나 같다면 왼쪽 값을 제외해준다
            if(sum>=N){
                if(sum==N) ans++;
                sum -= prime.get(left++);
            }
            //sum이 N보다 작다면 오른쪽 값을 증가시켜 더해준다
            //근데 이 때 right 값이 prime.size()-1과 같으면 1이 더해져 인덱스 에러가 발생하므로 따로 처리
            else{
                if(++right==prime.size()) break;
                sum += prime.get(right);
            }
        }


        System.out.println(ans);
    }
}
