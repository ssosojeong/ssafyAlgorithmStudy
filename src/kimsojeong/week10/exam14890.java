package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //메모리가 넉넉하고 N이 작으니까 그냥 2*N으로 다 받기
        int[][] map = new int[2*N][N];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<N; m++){
                map[n][m] =  map[m+N][n] =  Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        for(int i=0; i<2*N; i++){
            boolean[] visit = new boolean[N];
            for(int j=0; j<N; j++){
                //0. 만약 해당 행에 대해 끝까지 탐색이 끝났다면 ans를 증가시킨다.
                if(j==N-1){
                    ans++;
                    break;
                }
                //1. 다음칸과 높이가 같다면 넘어간다.
                if(map[i][j]==map[i][j+1]) {
                    continue;
                }
                //2. 오르막길일 경우 -> 지금 칸부터 <-방향으로 경사로 설치
                else if(map[i][j]+1==map[i][j+1]){
                    //필요한 칸수만큼 공간이 있는지 탐색한다.
                    boolean flag = true;
                    for(int k=0; k<L; k++){
                        //범위를 벗어나거나 / 높이가 다르거나 / 이미 경사로가 놓여져있으면 안됨
                        if(j-k<0 || map[i][j-k]!=map[i][j] || visit[j-k]){
                            flag = false;
                            break;
                        }
                        visit[j-k] = true;
                    }
                    if(!flag) break;
                }
                //3. 내리막일 경우 -> 지금 칸 다음 칸부터 -> 방향으로 경사로 설치
                else if(map[i][j]-1==map[i][j+1]){
                    boolean flag = true;
                    for(int k=1; k<=L; k++){
                        if(j+k>=N || map[i][j+k]!=map[i][j+1] || visit[j+k]){
                            flag = false;
                            break;
                        }
                        visit[j+k] = true;
                    }
                    if(!flag) break;
                }

                //4. 2칸 이상 차이날 경우 불가능하다.
                if(Math.abs(map[i][j]-map[i][j+1])>=2){
                    break;
                }

            }
        }

        System.out.println(ans);

    }
}
