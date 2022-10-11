import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //여기까지 입력
        int[] res = new int[N];
        int[] K = new int[N]; // res배열에 넣을 때 몇번째에 넣느냐를 저장
        res[0] = arr[0];
        K[0] = 0;
        int cnt = 0; // 글자수를 저장할 변수
        for (int i = 1; i < N; i++) {
            if (arr[i] > res[cnt]) { // res의 마지막 값보다 크면 cnt를 증가시키고 res[cnt]에 값을 저장한다.
                res[++cnt] = arr[i];
                K[i] = cnt;// 순서를 저장한다.
            } else {
                int idx = binarySearch(arr[i], res, 0, cnt); //아니라면 이분탐색을 통해 적절한 위치를 찬고
                res[idx] = arr[i];//그 위치에 넣어준다.
                K[i] = idx; // 순서를 저장한다.
            }
        }
        sb.append(cnt + 1).append("\n"); // 1개를 저장할때 0으로 저장했으므로 +1을 시켜준다.

        int[] ans = new int[cnt + 1];
        // 뒤에서부터 cnt를 찾아준다.
        // 찾고나면 cnt--를 시켜서 다음 값을 찾는다.
        // 뒤에서부터 찾기때문에 저장할 때도 cnt에 저장해야한다.
        for (int i = N - 1; i >= 0; i--) {
            if (K[i] == cnt) {
                ans[cnt--] = arr[i];
            }
        }
        for (int num : ans) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n, int[] res, int left, int right) { // 이분탐색
        if (left >= right) { // 왼쪽이 오른쪽보다 같거나 커지면
            return right; // 오른쪽 리턴
        } else { //아니라면 이분탐색 해야함
            int mid = (left + right) / 2; // 중간값설정
            if (n > res[mid]) { // 그 중간값보다 들어온 값이 크면
                return binarySearch(n, res, mid + 1, right); //mid+1~right
            } else {//같거나 작으면
                return binarySearch(n, res, left, mid); // left~mid
            }
        }
    }
}