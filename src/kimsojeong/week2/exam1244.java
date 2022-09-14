package src.kimsojeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1244 {
    static int[] switches;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //스위치 수와 스위치 초기 상태 입력
        N = Integer.parseInt(br.readLine());
        switches = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) switches[i] = Integer.parseInt(st.nextToken());

        //반복
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine()," ");
            if(Integer.parseInt(st.nextToken())==1) maleSwitch(Integer.parseInt(st.nextToken()));
            else femaleSwitch(Integer.parseInt(st.nextToken())-1);
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<N; i++){
            ans.append(switches[i]+" ");
            if((i+1)%20==0) ans.append("\n");   //i가 0에서 시작하므로 20의 배수를 판단할 땐 1을 더해서 비교해야 함
        }
        System.out.println(ans);


    }

    //남학생일 경우 -> 배수만큼 스위치를 바꿔준다
    //행렬이 0부터 시작하므로 시작idx를 idx-1로 지정
    public static void maleSwitch(int idx){
        for(int i=idx-1; i<N; i+=idx){
            switches[i] = 1-switches[i];
        }
    }

    //여학생일 경우 -> 양옆 비교해서 둘 다 같으면 바꿔준다
    //반복 횟수는 왼쪽으로 비교 가능한 횟수와 오른쪽으로 비교 가능한 횟수 중 작은 값
    //배열이 0부터 시작하므로 인자 넘겨줄 때 -1 해줌 (line 26)
    public static void femaleSwitch(int idx){
        for(int i=0; i<=Math.min(N-idx-1,idx); i++){
            if(switches[idx-i]==switches[idx+i]) {
                switches[idx-i] = switches[idx+i] = 1-switches[idx-i];
            } else
                break;
        }
    }
}
//이상현 : 남자와 여자 switch로 나누니까 훨씬 깔끔하게 코드를 짤 수 있네요.
//P소정: 차원이 뭔가 다르셔서 할말은 없구 마지막에 여자 함수 설명 자세히 듣고싶습니다! 
