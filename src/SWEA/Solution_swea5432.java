package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다.
    쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
    - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
    - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
    - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
    - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
    레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
    1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 “()” 으로 표현된다. 또한, 모든 “()”는 반드시 레이저를 표현한다.
    2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘(’ 로, 오른쪽 끝은 닫힌 괄호 ‘)’ 로 표현된다.
    >>>잘려진 쇠막대기 조각의 총 개수를 구하기.<<<
 */

public class Solution_swea5432 {                            //쇠막대기 자르기
    //머리가 안굴러가는데 이거 어케 풀어요...다시풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int cnt = 0;                                //잘린 막대 개수
            int pipe = 0;                               //잘리기 전 막대의 개수? (여는 괄호 만날 때 마다)

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    pipe++;                             //일단 여는 괄호면 파이프로 간주
                } else {
                    pipe--;                                 //레이저인 경우 위에서 올린 개수 줄이기, 닫는 막대인 경우도 개수 줄여주기

                    if(str.charAt(i-1) == '(') {            //()로 레이저인 )
                        cnt += pipe;
                    }
                    else{                                 //막대를 닫는 )
                        cnt++;                              //레이저로 자르고 남은 조각 개수 세기
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
