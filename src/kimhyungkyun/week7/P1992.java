package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
	static char[][] arr;
	static StringBuffer sb;
	
	
	private static void divide(int N, int x, int y) {
		char first = arr[x][y];
		boolean check = true;
		label : for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(first != arr[x+i][y+j]) {
					check = false;
					break label;
				}//if
			}//for
		}//for
		
		if(check && first=='1') {
			sb.append('1');
		}else if(check && first=='0') {
			sb.append('0');
		}else {
			sb.append('(');
			divide(N/2,x,y);
			divide(N/2,x,y+N/2);
			divide(N/2,x+N/2,y);
			divide(N/2,x+N/2,y+N/2);
			sb.append(')');
		}
		
	}//divide
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int n=0;n<N;n++) {
			String st = br.readLine();
			arr[n] = st.toCharArray();
		}//for
		
		
		sb = new StringBuffer();
		divide(N,0,0);
		
		System.out.println(sb);
		
		br.close();
	}//main

}//class
