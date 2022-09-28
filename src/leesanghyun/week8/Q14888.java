import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    static int[] arr, oper, res;
    static int N, start, ans, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N - 1];
        res = new int[N - 1];
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        oper = new int[4]; // + - * / 순서
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        permu(0); // 순열시작
        System.out.println(max);
        System.out.println(min);
    }

    private static void permu(int idx) { // idx는 현재까지 res 배열에 들어간 연산자의 수
        if (idx == N - 1) { //연산자의 수가 N-1이면 계산한 뒤 리턴한다.
            calc(res); // 계산한 뒤
            max = Math.max(max, ans); // 최댓값
            min = Math.min(min, ans); // 최솟값
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] != 0) {
                res[idx] = i;
                oper[i]--; // 연산자 백트래킹
                permu(idx + 1); // 해당 연산자를 넣어줬으므로 idx+1
                oper[i]++;
            }
        }
    }

    private static void calc(int[] res) {
        ans = start; // start의 값을 계속 사용하기 위해 ans를 static으로 선언해서 calc를 호출할때마다 계속해서 start로 초기화
        for (int i = 0; i < N - 1; i++) {
            switch (res[i]) { // res[i]의 값에 따라 연산이 결정됨.
                case 0:
                    ans += arr[i];
                    break;
                case 1:
                    ans -= arr[i];
                    break;
                case 2:
                    ans *= arr[i];
                    break;
                case 3:
                    ans /= arr[i];
                    break;
                default:
                    break;
            }
        }
    }


}
//김형균 : 제가 구현하고 싶었던게 이거였는데 속이 후련하네요~
//        피드백으로는 전역 변수로 선언한 res가 매개변수로 넘어가서 조금 헷갈리는데 따로 이유가 있으신지 궁금합니다.
