import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14725 {
	static int N, M, T;
	static int[][] arr;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Node root = new Node();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			Node tmp = root; // 루트를 처음에 tmp로 지정하고
			for (int j = 0; j < K; j++) { // k번만큼 자식을 넣어줄 것이므로
				String str = st.nextToken();
				tmp.insert(str); // tmp에 자식을 넣어준다.

				tmp = tmp.childNode.get(str); // tmp를 자식으로 변경하고 for문을 계속 진행한다.
			}
		}
		ant(root, 0);
		System.out.println(sb);

	}

	private static void ant(Node node, int cnt) {
		if (node.isEnd) // node가 끝이면 리턴해줌 (기저조건)
			return;
		List<Node> list = new ArrayList<>(node.childNode.values());
		list.sort((o1, o2) -> o1.str.compareTo(o2.str)); // 인텔리제이에서 이렇게 변환해줌
		for (Node child : list) { // 자식이면
			for (int i = 0; i < cnt; i++) {
				sb.append("--"); // cnt만큼 --를 추가하고 (자식의 level)
			}
			sb.append(child.str).append("\n"); // 그 자식을 sb에 넣어준다.
			ant(child, cnt + 1); // 그리고 재귀를 돌린다.
		}
	}

	private static class Node {
		Map<String, Node> childNode = new HashMap<>(); // String의 중복을 막기위해서(Apple Apple), (Apple Apple Banana)
		String str; // string을 넣어주고
		boolean isEnd = true; // 끝임을 표시한다.

		public Node() { // 기본생성자(root생성용)
		}

		public Node(String str) { // root를 제외한 다른 node생성용
			this.str = str;
		}

		public void insert(String str) { // 자식을 넣어줄 메서드. str을 넣으면 map안에 str을 만들고 새로운 노드를 생성한다.
			if (!childNode.containsKey(str)) // 만약에 childNode에 str이 없으면,
				childNode.put(str, new Node(str)); // 새로 childNode를 만들어준다.
			isEnd = false;
		}
	}
}
