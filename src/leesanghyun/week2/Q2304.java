package week2;

import java.util.*;
import java.io.*;

public class Q2304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> myStack = new Stack<>(); // 스택 정의
		List<Node> list = new ArrayList<>(); // Node를 타입으로 하는 list 생성. Node는 임의의 클래스로 맨 밑에 코딩.
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (h > max) {
				max = h; // max 찾기.
			}
			list.add(new Node(l, h)); // list에 높이h, 해당위치 l을 가진 Node를 집어넣음.
		}
		Collections.sort(list, new Comparator<Node>() { // list를 l을 기준으로 오름차순으로 정렬

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.l - o2.l;
			}
		});
		
		//다음과 같이 list를 받으면 최소l부터 최대l까지에 빈칸인 부분들이 있음. 예제를 보면, (l,h) 값이 (2,4), (4,6)을 받는데, (3,0)은 존재하지 않음.
		//이를 채워주기 위해서 graph배열을 만들고, graph 배열에는 l을 index로, h를 value로 받음
		
		int[] graph = new int[list.get(list.size() - 1).l - list.get(0).l + 1]; // l의 처음과 끝을 이용해서 graph의 크기를 설정.
		int start = list.get(0).l; // 가장 작은 l의 값을 0으로 설정하기 위해서.
		for (int i = 0; i < list.size(); i++) {
			graph[list.get(i).l - start] = list.get(i).h;
		}
		
		// stack에 하나하나 채워넣을건데, 밑의 코드에 peek()를 쓰기 때문에 에러 방지를 위해 하나를 미리 넣어둠.
		
		myStack.add(graph[0]); 
		boolean isExistMax = false; // 맨 위에 찾아놓은 max가 stack에 존재하는지의 여부
		for (int i = 1; i < graph.length; i++) {
			if (isExistMax) { // stack에 max값 존재.-> peek()한 값보다 낮은 값이 나오면 그 값을 집어넣어야 함. 하지만 그 와중에 큰 값이 나오면
				              // 그 큰 값보다 작은 값들을 모두 제거하고 나온 큰 값으로 채워넣어야함.
				if (graph[i] <= myStack.peek()) { // peek()한 값보다 작은 값이 보이면
					myStack.add(graph[i]);        // 스택에 넣는다.
				} else {
					int cnt = 1;                          //peek()한 것보다 더 큰 값이 나온다면, 예제의 (l,h) = (13,6)의 상황이라면
					while (myStack.peek() < graph[i]) {   //pop()을 해서 그 값을 제거하고 peek()을 해도 작다면 계속해서 pop()을 통해 제거하고 
						myStack.pop();                    //pop()한 숫자를 카운트한다.
						cnt++;
					}
					while (cnt-- != 0) {         //pop()한만큼 해당graph[i]를 집어넣는다.
						myStack.add(graph[i]);
					}
				}
			} else {  //stack값에 max값이 존재하지 않음.-> peek()한 값보다 높은 값이 나오면 그 값을 따라가야함.
                      //중간에 peek()한 값보다 낮은 값이 나오면 이를 무시하고 peek()한 값을 그대로 집어넣음.
				if (graph[i] > myStack.peek()) {
					myStack.add(graph[i]); // peek()한 값보다 큰 값이 나오면 그 값을 집어넣음.
				} else {
					myStack.add(myStack.peek()); // peek()한 값보다 작은 값이 나오면 peek()한 값을 넣음.
				}
				if (myStack.peek() == max) {
					isExistMax = true; // peek()했는데 그 값이 max값이라면 isExistMax를 true로 만들어줘서 위의 if식으로 들어갈 수 있도록 함.
				}
			}
		}
		int sum = 0;
		for (int i : myStack) {
			sum += i; // 스택에 있는 값들을 다 더해줌.
		}
		System.out.println(sum);
	}
}

class Node { // l과 h를 저장해줄 클래스
	int l;
	int h;

	public Node(int l, int h) { // 생성자
		this.l = l;
		this.h = h;
	}
}
//"하드코딩"
