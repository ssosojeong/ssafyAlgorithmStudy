import java.util.Scanner;

public class BJ_16719_psj {
	
	static String str;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		visited = new boolean[str.length()];
		
		zoac(0,str.length()-1);
	}
	private static void zoac(int left, int right) {
		if(left>right) {
			return;}
		int idx = left;
		//left와 right 사이에서 사전에서 제일 먼저나오는 글자의 idx를 찾는다.
		for(int i=left;i<=right;i++) {
			if(str.charAt(idx)>str.charAt(i)) {
				idx=i;
			}
		}
		//visited를 찾은 글자의 idx에 true라고 한다.
		visited[idx]= true;
		//전체 글자중에 true인 글자를 출력한다.
		for(int i=0;i<str.length();i++) {
			if(visited[i]) {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println();
		
		//현재 idx 다음에서부터 다시 탐색한다.
		zoac(idx+1,right);
		//모두 탐색을 했으면 그전까지 탐색을한다.
		zoac(left,idx-1);
		
		
	}

}
