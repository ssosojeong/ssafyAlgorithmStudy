package src.kimsojeong;

import java.util.Scanner;

public class exam10163 {
    //전체 공간을 2차원 배열로 나타냄
    static int[][] area = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        //주어진 n개의 종이에 대해 coloring 메소드를 실행시킨다
        for(int n=1; n<=N; n++) {
            coloring(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(), n);
        }

        //각 종이가 어느 면적을 차지하고 있는지 저장하기 위한 ans 배열 선언
        //1번 종이가 칠해진 면적의 넓이는 ans[1]에 저장되도록
        int[] ans = new int[N+1];

        for(int i=0; i<1001; i++) {
            for(int j=0; j<1001; j++) {
                ans[area[i][j]]++;
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.println(ans[i]);
        }
    }

    //종이의 시작점과 너비/높이가 주어지면 해당 지점을 색칠한다
    //종이의 번호로 표시-> 뒤에 들어온 종이의 번호가 남을 수 있도록
    public static void coloring(int X, int Y, int dX, int dY, int n) {
        for(int i=Y; i<=(Y+dY-1); i++) {
            for(int j=X; j<=(X+dX-1); j++) {
                area[i][j] = n;
            }
        }
    }
}