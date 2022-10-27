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
		//left�� right ���̿��� �������� ���� ���������� ������ idx�� ã�´�.
		for(int i=left;i<=right;i++) {
			if(str.charAt(idx)>str.charAt(i)) {
				idx=i;
			}
		}
		//visited�� ã�� ������ idx�� true��� �Ѵ�.
		visited[idx]= true;
		//��ü �����߿� true�� ���ڸ� ����Ѵ�.
		for(int i=0;i<str.length();i++) {
			if(visited[i]) {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println();
		
		//���� idx ������������ �ٽ� Ž���Ѵ�.
		zoac(idx+1,right);
		//��� Ž���� ������ �������� Ž�����Ѵ�.
		zoac(left,idx-1);
		
		
	}

}
