package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//LIS를 이분탐색으로 구하기
//주어진 배열 arr을 순차적으로 탐색하며 LIS를 찾을 것이다.
//지금까지 찾은 증가수열 리스트를 이분탐색하여 지금 타겟으로 하는 배열 arr을 삽입한다.
//list[n] = arr에서 탐색한 부분까지 존재하는 LIS 중 길이가 n인 LIS 마지막 값 중 가장 작은 것

// 1,5,2,3,6,7,2,1
// 위의 입력값에 대해 순차적으로 탐색할 때, 각 라운드에 대한 list 배열의 변화 모습
// 1) 1
// 2) 1 5
// 3) 1 2   -> [1,5], [1,2] 둘 다 길이가 2인 LIS지만 2를 저장하는 이유는 그래야지 더 많은 경우를 판단할 수 있기 때문이다.
// 4) 1 2 3
// 5) 1 2 3 6
// 6) 1 2 3 6 7
// 7) 1 2 3 6 7
// 8) 1 2 3 6 7

//하지만 이 때 list 배열은 lis를 보장하지 않는다.
// 1,4,7,6,3의 경우
// 1) 1
// 2) 1 4
// 3) 1 4 7
// 4) 1 4 6
// 5) 1 3 6
// 이지만, 정답은 1,4,7 또는 1,4,6임
// 이렇게 되는 이유는, 마지막 3까지 탐색했을 때 얻을 수 있는 길이 2짜리의 부분증가수열은
// [1,4], [1,7], [1,6], [1,3]이고, 이 중 2번째 자리에서의 최소값은 3이지만,
// 존재하는 최장 증가수열인 길이 3짜리가 존재하기때문임

// 따라서 이분 탐색을 진행하며 lis를 뽑아내려면
// 애초에 arr와 동일한 크기의 배열을 만들어놓고, 해당 타겟값이 list에 저장될때마다 그 자리를 새로운 배열에 같이 저장해야 함
// 그렇다면 위의 예시에서
// order = {1, 2, 3, 3, 2}이며,
// 최장 길이인 3을 가진 arr[3](6) -> 2를 가진 arr[1](4) -> 1을 가진 arr[0](1)를 뽑아낼 수 있음

public class exam14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int[] order = new int[N];
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        order[0] = 1;

        for(int n=1; n<N; n++){
            //lis 배열에서 이분탐색으로 내 자리 찾기

            //upper bound로 나보다 큰 인덱스를 반환하게 하여 해당 자리에 값을 삽입하는 경우,
            //현재 리스트의 끝 인덱스를 초과하는 인덱스에 삽입하는 동작이 발생할 수 있다.
            //따라서 만약 지금 넣으려는 값이 가장 큰 값이면, 그냥 삽입한다
            if(lis.get(lis.size()-1)<arr[n]) {
                lis.add(arr[n]);
                order[n] = lis.size();
            }

            //나(=arr[n])보다 크거나 같은 값이 존재하는 첫번째 자리를 반환하도록 한다. (lower bound)
            else{
                int left = 0;
                int right = lis.size();

                while(left<=right){
                    int mid = (left+right)/2;
                    if(lis.get(mid)<arr[n]) left = mid+1;
                    else right = mid-1;
                }

                lis.set(left,arr[n]);
                order[n] = left+1;
            }
        }

        //order 배열을 통해 최종 LIS를 만든다.
        int len = lis.size();
        int[] ans = new int[len];
        for(int i=N-1; i>=0; i--){
            if(order[i]==len) {
                ans[len-1] = arr[i];
                len--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()+"\n");
        for(int i: ans){
            sb.append(i+" ");
        }
        System.out.print(sb);

    }
}
