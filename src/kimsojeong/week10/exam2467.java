package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int left = 0; int right = N-1;
        int sum = 0;
        int cur = 2000000000;
        int[] ans = new int[2];
        while(left<right){
            sum = arr[left]+arr[right];

            if(Math.abs(sum)<Math.abs(cur)){
                cur = sum;
                ans[0] = arr[left];
                ans[1] = arr[right];
                if(sum==0) break;
            }

            //만약 sum이 0보다 작으면 left를 증가시켜서 전체 sum을 크게 만들어야 함
            if(sum<0) {
                left++;
            } else if(sum>0){
                right--;
            }
        }

        System.out.println(ans[0] + " " + ans[1] );
    }
}
