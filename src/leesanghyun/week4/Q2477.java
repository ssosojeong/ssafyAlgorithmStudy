package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 }; // 밑에 좌료에 넣을 때 쉽게 넣기 위해.
		int x = 0, y = 0;
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			x += dr[dir - 1] * dis;
			y += dc[dir - 1] * dis;
			list.add(new Node(x, y)); // x,y node로 넣어준다.
		}

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				return o1.x - o2.x;
			}

		}); 
		// x값으로 오름차순 정렬한다.
		//그렇게 되면 최대 x의 길이와 들어간 부분의 y값을 구할 수 있다.
		
		int maxrow = list.get(0).x - list.get(5).x;
		int mincol = list.get(2).y - list.get(3).y;

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				return o1.y - o2.y;
			}

		});
		
		//위와 마찬가지 방법으로 y순으로 정렬한다음
		//최대y의 길이와 들어간 부분의 x길이를 구한다.
		int maxcol = list.get(0).y - list.get(5).y;
		int minrow = list.get(2).x - list.get(3).x;
		//사각형 빼기 사각형
		int ans = Math.abs(maxrow * maxcol) - Math.abs(minrow * mincol);
		System.out.println(ans * n);

	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
