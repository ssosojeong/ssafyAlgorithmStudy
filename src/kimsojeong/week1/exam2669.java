package src.kimsojeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2669 {
    //전체 공간을 2차원 배열로 나타냄
    //단순히 해당 칸을 종이가 차지하고 있다는 것만 나타내면 되므로 boolean 선언
    static boolean[][] area = new boolean[101][101];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine()," ");
            int leftBottomX = Integer.parseInt(st.nextToken());
            int leftBottomY = Integer.parseInt(st.nextToken());
            int rightTopX = Integer.parseInt(st.nextToken());
            int rightTopY = Integer.parseInt(st.nextToken());

            coloring(leftBottomX, leftBottomY, rightTopX, rightTopY);
        }

        System.out.println(ans);


    }

    //종이 위치를 나타내는 입력이 들어오면 종이가 놓여진 곳을 색칠한다
    public static void coloring(int leftBottomX, int leftBottomY, int rightTopX, int rightTopY) {
        for(int i=leftBottomY ; i<rightTopY ; i++){
            for(int j=leftBottomX; j<rightTopX; j++){
                if(!area[i][j]){
                    area[i][j] = true;
                    ans++;
                }
            }
        }
    }
}

