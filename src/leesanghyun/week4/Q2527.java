package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double[] rec1 = new double[4];
			double[] rec2 = new double[4];
			for (int i = 0; i < 4; i++)
				rec1[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 4; i++)
				rec2[i] = Integer.parseInt(st.nextToken());
			
			//원리 : 직사각형 각각의 한 가운데를 찍는다.(mid1, mid2)
			//      가운데끼리의 거리를 x와 y로 분리시킨다.
			//      disX부분부터 한다면, rec1의 가로길이의 절반과 rec2의 가로길이의 절반을 합한 값과 비교해서 cnt에 적절한 값을 더해준다.
			
			
			double row1 = rec1[2] - rec1[0];
			double col1 = rec1[3] - rec1[1];
			double row2 = rec2[2] - rec2[0];
			double col2 = rec2[3] - rec2[1];
			double[] mid1 = { (rec1[2] + rec1[0]) / 2, (rec1[3] + rec1[1]) / 2 };
			double[] mid2 = { (rec2[2] + rec2[0]) / 2, (rec2[3] + rec2[1]) / 2 };

			double disX = Math.abs(mid1[0] - mid2[0]);
			double disY = Math.abs(mid1[1] - mid2[1]);

			int cnt = 0;

			if (disX < (row1 + row2) / 2) {
				cnt += 3;
			} else if (disX == (row1 + row2) / 2) {
				cnt++;
			}

			if (disY < (col1 + col2) / 2) {
				cnt += 3;
			} else if (disY == (col1 + col2) / 2) {
				cnt++;
			}
			//이렇게 되면 조합상 cnt가 6 4 3 2 1 0이 나올 수 있는데, 6 4 2를 제외하고는 전부 만나지 않는다.
			if (cnt == 6)
				sb.append("a\n");
			else if (cnt == 4)
				sb.append("b\n");
			else if (cnt == 2)
				sb.append("c\n");
			else {
				sb.append("d\n");
			}
		}
		System.out.println(sb);

	}
}
