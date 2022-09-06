package src.kimsojeong.month8.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N: 학생의 수
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> students = new ArrayList<>();

        //학생들이 뽑은 수를 받아오고
        //(자신의 원래 순서) - (뽑은 수)에 데이터를 삽입한다
        //arrayList.add(특정인덱스,값)은 해당 자리에 데이터를 삽입하고 후위의 데이터를 한칸씩 밀어 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            students.add(i-Integer.parseInt(st.nextToken()),(i+1));
        }

        for(int student:students){
            System.out.print(student+" ");
        }

    }
}
