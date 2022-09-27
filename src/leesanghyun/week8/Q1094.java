import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1094 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		// X가 이진법으로 나타냈을때의 1의 갯수를 구하면 된다.
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if ((X & (1 << i)) != 0)
				cnt++;
		}
		System.out.println(cnt);
	}

}