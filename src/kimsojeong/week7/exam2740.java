package src.kimsojeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //첫번째 행렬 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //두번째 행렬 입력
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[M][K];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //곱해주기
        //|1 2|    *  |-1 -2 0|
        //|3 4|       | 0  0 3|
        //|5 6|
        // -> 답[0][0] = 1*(-1) + 2*0 = arr1[0][0]*arr2[0][0] + arr1[0][1]*arr2[1][0]
        // ...
        // -> 답[8][8] = 5*0 + 6*3 = arr1[2][0]*arr2[0][2] + ar1[2][1]*arr2[1][2]

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int tmp = 0;
                for(int l=0; l<M; l++){
                    tmp += arr1[i][l]*arr2[l][j];
                }
                sb.append(tmp+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
//김형균 : 여기서 조금 수정할 수 있을꺼라곤 행렬을 입력 받을 때 비슷한 코드를 2번 쓰셔서 반복이 생기는데 for문으로 if문을 통해서 경우를 나누어서 코드를 줄일 수 있을꺼 같고 ,
//        다른 방법으로는 3차원 배열을 사용해도 가능하지 않을까 싶어요! 
      
