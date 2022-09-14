package src.kimsojeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 1;
        int tE = 1;
        int tS = 1;
        int tM = 1;

        //ans를 하나씩 증가시켜가며 E와 S, M을 찾는다
        while(tE!=E || tS!=S || tM!=M){
            ans++;

            if(++tE==16) tE=1;
            if(++tS==29) tS=1;
            if(++tM==20) tM = 1;
        }

        System.out.println(ans);

    }

}
