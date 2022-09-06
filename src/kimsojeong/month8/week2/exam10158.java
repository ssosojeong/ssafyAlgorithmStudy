package src.kimsojeong.month8.week2;

import java.io.*;
import java.util.StringTokenizer;

public class exam10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        //개미는 1시간마다 x축 1칸, y축 1칸 움직임
        //(처음 위치)+(움직인 거리=시간)를 전체 너비(높이)에 2를 곱한 값으로 나눠 나머지를 구하면
        //최종적으로 개미가 0에서부터 얼마나 이동했는지 알 수 있음
        int dx = (p+t)%(2*w);
        int dy = (q+t)%(2*h);

        //2*w로 나눈 이유가 0에서 얼마나 이동했는지 알기 위해선데
        //방향을 고려하지 않고 그냥 구했기 때문에 처리해줘야함
        //만약 dx가 7이 나왔다? 그럼 너비가 6인 공간에서 오른쪽으로 6시간 가고 벽 맞고 왼쪽으로 1시간 온거니까
        //최종 좌표값은 -> dx가 w보다 크면? 12-dx 아니면 걍 dx
//        System.out.println((dx>w?2*w-dx:dx) + " " + (dy>h?2*h-dy:dy));
        bw.write((dx>w?2*w-dx:dx) + " " + (dy>h?2*h-dy:dy));

        bw.flush();
        bw.close();
    }
}