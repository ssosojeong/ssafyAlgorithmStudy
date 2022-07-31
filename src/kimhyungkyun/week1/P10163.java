package studybaek;

import java.util.Scanner;

public class P10163 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //색종이 몇 장 쓸껀지 입력받기
        int N = sc.nextInt();
        
        //색종이가 놓이는 평면 만들기(초기화 값 0으로 들어감)
        int[][] plane = new int[1001][1001];
        
        //색종이 마다 정보를 가지고 있어줄 배열
        int[] colorPaper = new int[N];
        
        //색종이마다 정보를 입력 받기
        for (int i=0; i<N;i++) {
            //x좌표 값 열로 변환해서 받기
            int x = sc.nextInt();
            int col = x;
            
            //y좌표 값 행으로 변환해서 받기
            int y = sc.nextInt();
            int row = 1000-y;
            
            //너비와 높이값 받기
            int width = sc.nextInt();
            int height = sc.nextInt();
            for(int n=col;n<col+width;n++) {
                for(int m =row-height+1; m<=row;m++) {
                    plane[m][n]=i+1;
                }
            }
        }
            
        //색종이 색깔에 맞게 값 배열에 저장하기 + 각 배열에 저장된 값 출력해주기
        for (int i=0;i<N;i++) {
            int count=0;
            for(int n=0;n<1001;n++) {
                for(int m=0;m<1001;m++) {
                    if(plane[n][m]==i+1) count++;
                }
            }
            colorPaper[i]=count;
            System.out.println(colorPaper[i]);
        }
        
        
        
        sc.close();
    }
    
}
//이상현 : 46-47에서 colorPaper로 받지 않고 count를 출력하면 더 좋을것같아요~
