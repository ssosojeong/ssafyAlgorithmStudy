package study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {
	static int[][] map,mapClone;
	static boolean[][] vRow, vCol;//�̹� ���� ���� �ߺ��ؼ� ���� ���� �����ϱ� true�� �� ���� �� �ǵ帮�� �ʰ��ϱ�
	static int N, L, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}//for
		
		///////////////////�Է°� �ޱ� ��
		
		mapClone = map.clone();
		vRow = new boolean[N][N];
		vCol = new boolean[N][N];
		
		
		cnt = 0;
		for(int i=0;i<N;i++) {
			checkRow(i);//��ü �� ���鼭 ��� ����� �� �ִ��� üũ
			checkCol(i);//��ü �� ���鼭 ��� ��� �������� üũ
		}//for

		//�࿡ ���� �ִº��ϰ� ���� ���� ������ �ִ� 2���� ����� ���� ����� ������ �ʱ� ������ ���纻�� mapClone���� ��ó�� ���� �˻����ָ�ȴ�
		
		System.out.println(cnt);
		
		
		br.close();
	}//main

	

	private static void checkRow(int i) {
		//��� ���� i�� ���鼭 ��ȸ
		for(int j=0;j<N-1;j++) {
			int jVal = map[i][j];
			int jPlusVal = map[i][j+1];
			
			if(jVal==jPlusVal) continue;
			else if(jVal+1==jPlusVal) {//���� ���� �ִ� ���� �� �ܰ� ���� ��
				for(int l=0;l<L;l++) {
					int newJ = j-l;
					if (newJ<0 || vRow[i][newJ]) return;//���࿡ L�� ��ŭ�� ���� ������ ���ϸ� �� ���� ������ �� ���� ���̹Ƿ� �� ���� �ʰ� return �׸��� �̹� ���� ���� ���� �� �׾ƾ� �ϴ� ���� pass
					if(map[i][newJ]+1==jPlusVal) vRow[i][newJ] = true; //�ڿ� üũ�� ���� boolean�� �� �ǵ�� �൵ �� �ϰ� ���� �Ű� �Ⱦ��� ����
					else return;//�� �� ������ ���� ������ ���� �� �� ���� ��� �̹Ƿ� return
				}
			}//else if
			else if(jVal-1==jPlusVal) {//���� ���� �ִ� ���� �� �ܰ� ���� ���
				for(int l=1;l<=L;l++) {
					int newJ = j+l;
					if (newJ>=N) return;//�� �κп� ���ؼ��� vRowüũ�� �� �ʿ䰡 ���� ������
					if(map[i][newJ]+1==jVal) vRow[i][newJ] = true;
					else return;
				}//for
			}//else if
			else return; //���ų� 1��ŭ ���̳��ų��� �ƴϸ� ���� ���� �Ұ�
		}//for
		//������� return �ȵǰ� �� �Դٴ� ���� �� �ٿ� ���� ���� �ȴٴ� �ǹ�
		cnt++;
	}//checkRow
	
	
	private static void checkCol(int i) {
		//��� ���� i�� ���鼭 ��ȸ
		for(int j=0;j<N-1;j++) {
			int jVal = mapClone[j][i];
			int jPlusVal = mapClone[j+1][i];
			if(jVal==jPlusVal) continue;
			else if(jVal+1==jPlusVal) {//���� �࿡ �ִ� ���� �� �ܰ� ���� ��
				for(int l=0;l<L;l++) {
					int newJ = j-l;
					if (newJ<0 || vCol[newJ][i]) return;//���࿡ L�� ��ŭ�� ���� ������ ���ϸ� �� ���� ������ �� ���� ���̹Ƿ� �� ���� �ʰ� return �׸��� �̹� ���� ���� ���� �� �׾ƾ� �ϴ� ���� pass
					if(mapClone[newJ][i]+1==jPlusVal) vCol[newJ][i] = true;
					else return;//�� �� ������ ���� ������ ���� �� �� ���� ��� �̹Ƿ� return
				}
			}//else if
			else if(jVal-1==jPlusVal) {//���� �࿡ �ִ� ���� �� �ܰ� ���� ���
				for(int l=1;l<=L;l++) {
					int newJ = j+l;
					if (newJ>=N) return;//�� �κп� ���ؼ��� vRowüũ�� �� �ʿ䰡 ���� ������
					if(mapClone[newJ][i]+1==jVal) vCol[newJ][i] = true;
					else return;
				}//for
			}//else if
			else return; //���ų� 1��ŭ ���̳��ų��� �ƴϸ� ���� ���� �Ұ�
		}//for
		//������� return �ȵǰ� �� �Դٴ� ���� �� �ٿ� ���� ���� �ȴٴ� �ǹ�
		cnt++;
	}//checkCol
}//class
