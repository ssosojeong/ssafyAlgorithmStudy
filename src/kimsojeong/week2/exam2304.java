package src.kimsojeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Block implements Comparable<Block>{
    int idx;
    int height;

    public Block(int idx,int  height){
        this.idx=idx;
        this.height=height;
    };

    //x축을 기준으로 정렬하기 위해서
    @Override
    public int compareTo(Block o) {
        return this.idx-o.idx;
    }
}

public class exam2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Block[] blocks = new Block[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            blocks[i] = new Block(idx,height);
        }

        Arrays.sort(blocks);
        int ans = 0;
        int maxIdx = 0;

        Block highestBlock = blocks[0];
        //왼쪽부터 가장 높은 곳까지 면적 계산
        for(int i=0; i<N; i++){
            Block curBlock = blocks[i];

            //만약 현재 참조하는 블럭의 높이가 기존 블럭의 높이보다 높다면
            //현재 블럭까지의 창고 다각형의 면적을 계산하여 더해준다
            if(curBlock.height >= highestBlock.height){
                ans += (curBlock.idx-highestBlock.idx) * highestBlock.height;
                highestBlock = curBlock;
                maxIdx = i;
            }
        }

        highestBlock = blocks[N-1];
        //오른쪽에서부터 구한 가장 높은 블럭까지 면적을 계산해준다
        for(int i=N-1; i>=maxIdx; i--){
            Block curBlock = blocks[i];

            if(curBlock.height > highestBlock.height){
                ans += (highestBlock.idx-curBlock.idx) * highestBlock.height;
                highestBlock = curBlock;
            }
        }

        //끝까지 더해지지 않은 가장 높은 빌딩의 넓이를 더해준다
        ans += blocks[maxIdx].height;

        System.out.println(ans);
    }
}