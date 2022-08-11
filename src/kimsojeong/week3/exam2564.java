package src.kimsojeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//아직 덜풀었어요!!!!!!


public class exam2564 {
    static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] disShop = new int[N+1];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            //1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            disShop[i] = calcDis(dir,dis);

            //dir -> 1북 2남 3서 4동
            //dis -> 북남-> 왼쪽으로부터 거리 / 서동->위쪽으로부터 거리


            //맨왼쪽상단을 기준으로 그냥 일자라고 생각하고 거리 계산해보면
            //북쪽 -> 그냥 dis
            //동쪽 -> W+dis
            //남쪽 -> W+H+W-dis
            //서쪽 -> W+H+W+H-dis

            //내껏도 저렇게 계산한다음에
            //빼고 절대값씌우고
            //2W+2H에서 뺀값이랑 처음에 뺀거중에 최소값구하면 안되나?????
        }

        st = new StringTokenizer(br.readLine()," ");
        int disDg = calcDis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i=0; i<N; i++){
            int val = Math.abs(disShop[i]-disDg);
            System.out.println(Math.min(val, 2*H+2*W-val));
        }



    }

    public static int calcDis(int dir, int dis){

        if(dir==1) return dis;
        else if(dir==2) return W + dis;
        else if(dir==3) return 2*W + H - dis;
        else if(dir==4) return 2*W + 2*H - dis;

        return 0;
    }
}
