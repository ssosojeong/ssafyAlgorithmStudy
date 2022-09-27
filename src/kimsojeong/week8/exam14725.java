package day0927.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node{
	//사전순서대로 저장해야하므로
	Map<String, Node> childNodes = new TreeMap<>();
}


public class exam14725 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Node root = new Node();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());	//hasMoreTokens() 써서 사실 필요 없음 
			
			//토큰이 계속 있다면 -> 루트부터 넣어줘야 한다
			Node curNode = root;
			while(st.hasMoreTokens()) {
				String food = st.nextToken();
				//food에 해당하는 자식노드를 가지고 있으면 걔를 curNode로 삼고
				//없으면 만들어서 curNode로 삼고
				//curNode로 삼는다 = 한단계 내려간다.
				curNode = curNode.childNodes.computeIfAbsent(food, str->new Node());
			}
		}
		
		print(root, 0);
		
		System.out.print(sb);
	}
	
	public static void print(Node curNode, int level) {
		//해당 노드의 각 자식들에 대해 순회가 필요하다.
		Iterator<String> iterator = curNode.childNodes.keySet().iterator();
		//자식 노드가 존재하면
		while(iterator.hasNext()) {
			String key = iterator.next();
			for(int i=0; i<level; i++) {
				sb.append("--");
			}
			sb.append(key).append("\n");
			print(curNode.childNodes.get(key), level+1);
		}
	}
}