import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q16719 {
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        visited = new boolean[arr.length];
        stack.push(0);
        getAnswer();
        System.out.println(sb);
    }

    private static void getAnswer() {
        int start = 0;
        if (!stack.isEmpty()) {
            start = stack.peek();
        }
        int min = 1000;
        int idx = -1;
        for (int i = start; i < arr.length; i++) {
            if (!visited[i] && min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        if (idx == -1) {
            if (stack.peek() != 0) {
                stack.pop();
                getAnswer();
                return;
            } else {
                return;
            }
        }
        String res = "";
        visited[idx] = true;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                res += arr[i];
            }
        }
        sb.append(res).append("\n");
        stack.push(idx);
        getAnswer();
    }

}