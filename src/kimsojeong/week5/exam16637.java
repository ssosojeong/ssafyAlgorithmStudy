package src.kimsojeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam16637 {
    static int N,ans=Integer.MIN_VALUE;
    static char[] equation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        equation = br.readLine().toCharArray();

        insertBracket(0,'+',0);

        System.out.println(ans);
    }

    //lastValue: 가장 마지막에 나온 정수
    //lastOper: 가장 마지막에 나온 연산자
    //curIdx: 선택 여부를 따질 인덱스
    public static void insertBracket(int lastValue, char lastOper, int curIdx){
        //str을 끝까지 다 탐색했을 경우
        if(curIdx>=(N-1)){
            if(curIdx==N-1) ans = Math.max(ans, calc(lastValue,lastOper,equation[curIdx]-'0'));
            else ans = Math.max(ans,lastValue);
        } else{
            //해당 문자가 숫자일 경우 -> 선택 여부를 따진다.
            if(equation[curIdx]>='0' && equation[curIdx]<='9'){
                //선택할 경우
                //1. (cur, cur+1, cur+2)를 계산한다.
                //2. (lastValue, lastOper, 1의 결과)를 계산한다.
                //3. 2의 결과를 lastValue에 넣고 curIdx를 3 증가시켜 재귀한다.
                //4. 3에서 lastOper는 그냥 +값으로 넣는다 -> 인덱스가 끝까지 갈 경우의 null에러 방지
                //      -> 어차피 연산자면 else에서 대치됨
                int tmp = calc(equation[curIdx]-'0',equation[curIdx+1], equation[curIdx+2]-'0');
                insertBracket(calc(lastValue,lastOper,tmp), '+', curIdx+3);

                //선택하지 않을 경우
                //2번부터 실행
                insertBracket(calc(lastValue,lastOper,equation[curIdx]-'0'),'+',curIdx+1);
            }
            //해당 문자가 연산자일경우 -> 무조건 선택하지 않는다
            else{
                insertBracket(lastValue, equation[curIdx], curIdx+1);
            }
        }
    }

    public static int calc(int num1, char oper, int num2){
        switch(oper){
            case('+') : return num1+num2;
            case('-') : return num1-num2;
            case('*') : return num1*num2;
        }
        return -1;
    }
}
