import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //체를 이용한 소수구하기
        List<Integer> primeList = new ArrayList<>();
        boolean[] prime = new boolean[4000001];
        for (int i = 2; i * i <= 4000000; i++) {
            if (!prime[i]) {
                for (int j = 2; i * j <= 4000000; j++) {
                    prime[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= 4000000; i++) {
            if (!prime[i])
                primeList.add(i);
        }

        int start = 0, end = 0; // 둘다 0에서 시작
        int sum = primeList.get(0); //시작점 정해주기
        int cnt = 0;//경우의수 카운트
        while (!(start == end && sum > N)) {
            if (sum > N) { // 합이 N보다 크면 start를 하나 증가시키고 그 값을 빼준다.
                sum -= primeList.get(start++);
            } else if (sum < N) { // N보다 작으면 end를 하나 증가시키고 증가시킨 값을 더해준다.
                if (++end >= primeList.size()) break; // 범위가 벗어났다면 break
                sum += primeList.get(end);
            } else { // sum과 N이 같으면 경우의수 1개를 카운트하고 start end둘다 1씩 증가시킨다.
                cnt++;
                if (++end >= primeList.size()) break; // 범위가 벗어났다면 break
                sum -= primeList.get(start++);
                sum += primeList.get(end);
            }
        }
        System.out.println(cnt);
    }
}