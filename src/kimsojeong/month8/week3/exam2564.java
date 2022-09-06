package src.kimsojeong.month8.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class exam2564 {
    static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] disShop = new int[N+1];   //원점으로부터의 거리를 계산해서 저장해줄 배열


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
            //원점으로부터 계산한 동근이 위치와 가게 위치 사이의 거리를 계산한다.
            int val = Math.abs(disShop[i]-disDg);
            //하지만 val은 최소값이 아닐 수 있으므로 (원래 사각형 모양인걸 억지로 일자로 찢어놨으니까)
            //구한 val과 전체 길이에서 val을 빼 준 수 중 작은 값이 최소값
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
