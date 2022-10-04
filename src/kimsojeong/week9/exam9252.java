package src.kimsojeong.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS 기본 개념
//두 문자열 X,Y에 대해
//dp[i][j] = 길이가 i인 X의 부분문자열과 길이가 j인 Y의 부분문자열의 공통 부분 문자열
//만약
//1. X[i]==Y[j]라면 -> dp[i][j] = dp[i-1][j-1]+1
//                 => 마지막 X[i]/Y[j]는 공통 부분 문자열에 포함될거니까 하나씩 자른 앞부분의 문자열 길이+1)
//2. X[i]!=Y[j]라면 -> dp[i][j] = MAX(dp[i-1][j], dp[i][j-1])
//                 => 일단 X[i]와 Y[j] 둘 중 하나는 공통 부분 문자열에 들어갈 수 없음 (다르니까!)
//                 => 그니까 하나씩 잘라서 만들고 비교하기
//-> 이 때 dp[0][~] = dp[~][0] = 0
//즉, dp[i][j]는 dp[i-1][j-1], dp[i-1][j], dp[i][j-1]을 건드니까 dp[1][1]부터 바텀업으로 구해주면 된다!

//근데!!! 그래서 문자열은 어떻게 구할것인가
//하나만 구해도 되는거면 1번 동작이 발생할때마다 정답에 추가해주면 되지않나..?
//  -> 안됨.. 중복해서 찍힘 (ACAYKP & CAPCAK -> 4/AACCAAKP)
//마지막에서 역방향으로 순회해야될듯..


public class exam9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] X = br.readLine().toCharArray();
        char[] Y = br.readLine().toCharArray();

        int xLen = X.length;
        int yLen = Y.length;

        int[][] dp = new int[xLen+1][yLen+1];

        //dp 배열 구해주고
        for(int x=1; x<=xLen; x++){
            for(int y=1; y<=yLen; y++){
                if(X[x-1]==Y[y-1]) {
                    dp[x][y] = dp[x-1][y-1]+1;
                }
                else dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
            }
        }

        //역으로 가져오기
        int cnt = 0;
        int x = xLen, y = yLen;
        while(cnt<dp[xLen][yLen]){
            if(X[x-1]==Y[y-1]){
                sb.append(X[x-1]);
                cnt++;
                x--; y--;
            } else{
                if(dp[x][y-1]>dp[x-1][y]){
                    y--;
                } else{
                    x--;
                }
            }
        }

        System.out.println(dp[xLen][yLen]);
        if(dp[xLen][yLen]!=0){
            System.out.print(sb.reverse());
        }

    }
}
