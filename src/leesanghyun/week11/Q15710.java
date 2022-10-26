import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q15710 {
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());

		long tmp = (long) Math.pow(2, 31) % 1000000007;

		long ans = getAnswer(tmp, n - 1);
		System.out.println(ans);

	}

	static long getAnswer(long num, long power) {
		if(map.containsKey(power)) {
			return map.get(power);
		}
		if (power > 1) {
			map.put(power, getAnswer(num, power / 2) * getAnswer(num, power - power / 2) % 1000000007);
			return map.get(power);
		} else if (power == 1) {
			return num;
		} else {
			return 1;
		}
	}
}