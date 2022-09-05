package src.kimsojeong.month8.week2;

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


// 김형균 : 2차원 배열 대신에 Block이라는 클래스를 사용한 이유가 객체의 정렬을 이용하기 위해서인거 같은데 그게 2차원 배열을 정렬 하는거 보다 더 효과적인가요?
//     ㄴ 사실 효과적인지는 잘 모르겠어요! 오히려 클래스를 하나 더 로딩해야되니까 미세하게나마 쪼금 더 걸릴수도..? 근데 전 사실 큰 차이 안날 것 같기도 하고
//         그냥 클래스 만들어서 푸는게 더 깔끔해보여서 만들었습니다!ㅎㅎ
