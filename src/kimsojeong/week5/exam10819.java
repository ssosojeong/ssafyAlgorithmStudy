package src.kimsojeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam10819 {
    static int ans, N;
    static boolean[] chk;
    static int[] intArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        intArr = new int[N];
        chk = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            intArr[n] = Integer.parseInt(st.nextToken());
        }

        //새로운 배열의 시작점을 정해준다.
        for(int i=0; i<N; i++){
            chk[i] = true;
            calcDiff(intArr[i],0,1);
            chk[i] = false;
        }

        System.out.println(ans);


    }

    //last: 이전값 -> 메서드 내에서 현재 값을 고르고, 얘와의 절대값차이를 구해서 재귀
    //sum: 지금까지의 절대값 차이의 총 합
    //num: 지금까지 몇 개의 값을 골랐는지
    public static void calcDiff(int last, int sum, int num){
        //순서를 모두 재배열해서 총 합을 구했다면
        if(num==N){
            if(sum>ans) ans = sum;
            return;
        } else{
            //아직까지 재배열하지 않은 배열값 중 하나를 선택하여 걔를 다음으로 보낸다.
            for(int i=0; i<N; i++){
                if(!chk[i]){
                    chk[i] = true;
                    calcDiff(intArr[i], sum+Math.abs(last-intArr[i]),num+1);
                    chk[i] = false;
                }
            }
        }
    }
}
//이상현 : calcDiff를 백트래킹 하는 것 좋네요. 저도 다음엔 이런식으로 풀어야겠다는 생각이 드네요. 3개코드를 봤는데 피드백할게 떠오르지 않네요 ㅋㅋ 세개 다 깔끔해요