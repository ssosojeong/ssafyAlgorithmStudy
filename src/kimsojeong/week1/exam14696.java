package src.kimsojeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //반복 횟수(=게임의 수)가 0이 될 때까지 while문 반복
        while(N-->0) {
            //각 배열엔 A와 B의 카드 패가 저장된다.
            //별=4, 동그라미=3, 네모=2, 세모=1
            int[] arrA = new int[5];
            int[] arrB = new int[5];

            //A의 카드 패를 배열에 저장
            st = new StringTokenizer(br.readLine()," ");
            int nA = Integer.parseInt(st.nextToken());
            while(nA-->0) {
                arrA[Integer.parseInt(st.nextToken())]++;
            }

            //B의 카드 패를 배열에 저장
            st = new StringTokenizer(br.readLine()," ");
            int nB = Integer.parseInt(st.nextToken());
            while(nB-->0) {
                arrB[Integer.parseInt(st.nextToken())]++;
            }

            String ans = "D";
            //가장 우선 순위가 높은 별 모양부터 갯수를 비교
            //같으면 동그라미->네모->세모 순으로 비교되고,
            //마지막까지 수가 같으면 초기값인 D가, 아니면 승자의 이니셜이 프린트된다.
            for(int i=4; i>=1; i--) {
                if(arrA[i]==arrB[i]) continue;
                else if(arrA[i]>arrB[i]) {
                    ans="A"; break;
                }
                else {
                    ans="B";
                    break;
                }
            }

            System.out.println(ans);
        }
    }

}
