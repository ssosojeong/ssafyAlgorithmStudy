import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int end = -1; // 입력이 끝나고도 -1이면 양수가 없는거
        boolean isFound = false; // 양수를 찾았는지
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!isFound && arr[i] > 0) {
                end = i;
                isFound = true;
            }
        }
        if (end == 0) { // end가 0이면 양수만 있는거 -> 밑에 로직이 필요없음
            sb.append(arr[0]).append(" ").append(arr[1]);
            System.out.println(sb);
            return;
        } else if (end == -1) { // 이것도 마찬가지
            sb.append(arr[N - 2]).append(" ").append(arr[N - 1]);
            System.out.println(sb);
            return;
        }

        int start = end - 1; // end가 양수 시작이므로 start는 end-1로해야 음수 시작이 된다.
        int min = Integer.MAX_VALUE; // 일단 최댓값으로 설정하고
        int ans1 = 0, ans2 = 0; // ans 2개를 선언한다.
        if (end + 1 < N) { // 범위벗어나기 방지
            min = arr[end] + arr[end + 1];
            ans1 = end;
            ans2 = end + 1;
        }
        if (start - 1 >= 0) { // 범위벗어나기 방지
            int diff = Math.abs(arr[start] + arr[start - 1]);
            if (min > diff) { // 만약 diff가 더 작다면 ans값 두개를 변경해줘야한다.
                min = diff;
                ans1 = start - 1;
                ans2 = start;
            }
        }

        while (start >= 0 && end < N) { // start가 0보다 작거나 end가 N보다 같거나 크면 멈춘다.
            int diff = arr[start] + arr[end]; // 차이
            if (min > Math.abs(diff)) { // 차이가 min보다 작으면 변경해준다.
                min = Math.abs(diff);
                ans1 = start;
                ans2 = end;
            }
            if (diff > 0) start--; // 그 뒤에 0보다 크면 start를 감소시켜 음수를 더 작게 만들어주고
            else if (diff < 0) end++; // 0보다 작으면 end를 증가시켜 양수를 더 크게 만들어준다.
            else break; // 만약 0이라면 더 볼것이 없으므로 break

        }
        sb.append(arr[ans1]).append(" ").append(arr[ans2]);
        System.out.println(sb);
    }
}