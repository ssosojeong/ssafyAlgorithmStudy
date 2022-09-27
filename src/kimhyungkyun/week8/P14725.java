package lecture.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.Function;

public class P14725 {
	static Function<String, Integer> stoi = Integer::parseInt;//메서드를 변수처럼 사용 (신기해서 써봤어요)
	static int N ;
	static Trie root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi.apply(br.readLine());//메서드 변수 사용하는 방법(apply)
		root = new Trie();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = stoi.apply(st.nextToken());
			Node node = root.node;
			for (int j = 0; j < k; j++) {
				node = node.down.computeIfAbsent(st.nextToken(), s -> new Node());
			}
		}
		root.node.print(0);
		br.close();
	}//main
}//class

//computeIfAbsent 메서드의 역할(위 사용 예시 KIWI가 없으면 key를 KIWI로 , Value는 Node()로 하는 
//새로운 값이 반환되고 만약 KIWI라는 키를 가지고 있는 데이터가 존재한다하면 그 value인 node를 반환한다.)

//Map<Key, Value> map = new HashMap();
//
//Value value = map.get(key);
//if (value == null) {
//    value = getNewValue(key);
//    map.put(key, value);
//}



class Trie{
	Node node = new Node();;
}

class Node{
	Map<String, Node> down = new TreeMap<String, Node>();
	
	public void print(int depth) {
		for(String s : down.keySet()) {
			for(int i=0; i<depth;i++) 
				System.out.print("--");
			System.out.println(s);
			down.get(s).print(depth + 1);
		}//for
		
	}//print
}