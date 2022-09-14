package src.kimsojeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2578 {
    static int bingoCnt, numCnt;
    static int[][] bingo, coordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //빙고 입력 받아오기
        //불린 숫자의 위치를 찾아 빙고를 찾아야 하므로
        //미리 2차원 배열을 선언, coordinate[n]에는 n의 좌표 {i,j}가 저장되도록 하여
        //탐색 시간을 줄이고자 함
        bingo = new int[7][7];
        coordinate = new int[26][2];
        for(int i=1; i<6; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<6; j++){
                int num = Integer.parseInt(st.nextToken());
                coordinate[num] = new int[] {i,j};
                bingo[i][j] = num;
            }
        }

        //5줄 동안 25개의 숫자를 받아오기
        outer: for(int i=1; i<6; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<6; j++){
                numCnt++;
                checkBingo(Integer.parseInt(st.nextToken()));
                //빙고 갯수가 2를 초과하면 모든 반복문을 빠져 나감
                if(bingoCnt>2){
                    break outer;
                }
            }
        }

        System.out.println(numCnt);

    }

    //숫자가 불린 후 빙고 갯수를 연산한다.
    public static void checkBingo(int num){

        int numI = coordinate[num][0];
        int numJ = coordinate[num][1];

        //각 가로줄에서 불린 번호의 수는 bingo[i][6]에 저장
        if(++bingo[numI][6]>=5){
            bingoCnt++;
        }

        //각 세로줄에서 불린 번호의 수는 bingo[6][j]에 저장
        if(++bingo[6][numJ]>=5){
            bingoCnt++;
        }

        //우하향 대각선에서 불린 번호의 수는 bingo[6][6]에 저장
        if(numI==numJ && ++bingo[6][6]>=5){
            bingoCnt++;
        }

        //좌하향 대각선에서 불린 번호의 수는 bingo[6][0]에 저장
        if(numI+numJ==6 && ++bingo[6][0]>=5){
            bingoCnt++;
        }
    }
}
