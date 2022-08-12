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
            
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            disShop[i] = calcDis(dir,dis);

        }

        st = new StringTokenizer(br.readLine()," ");
        int disDg = calcDis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        int ans = 0;
        
        for(int i=0; i<N; i++){
            int val = Math.abs(disShop[i]-disDg);
            ans += Math.min(val, 2*H+2*W-val);
        }

        System.out.println(ans);
    }

    public static int calcDis(int dir, int dis){
        //맨왼쪽상단을 기준으로 그냥 일자라고 생각하고 거리 계산해보면
        //북쪽 -> 그냥 dis
        //동쪽 -> W+dis
        //남쪽 -> W+H+W-dis
        //서쪽 -> W+H+W+H-dis

        if(dir==1) return dis;						//북
        else if(dir==2) return 2*W + H - dis;		//남
        else if(dir==3) return 2*W + 2*H - dis;		//서
        else if(dir==4) return W + dis;				//동

        return 0;
    }
}
