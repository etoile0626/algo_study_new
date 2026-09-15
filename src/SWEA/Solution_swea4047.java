package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    한 덱”이란 스페이드, 다이아몬드, 하트, 클로버 무늬 별로 각각 A, 2~10, J, Q, K의 라벨 즉 4개의 무늬 별로 각각 13장씩 총 52장의 카드가 있는 모음을 의미한다.
    편의상 A는 1, J, Q, K는 11, 12, 13으로 하여 1~13의 숫자가 카드에 적혀있다고 하자.
    영준이는 몇 장의 카드를 이미 가지고 있는데 게임을 하기 위해서 몇 장의 카드가 더 필요한지 알고 싶어 한다.
    그리고 이미 겹치는 카드를 가지고 있다면 오류를 출력하고자 한다.
    지금 가지고 있는 카드의 정보가 주어지면 이 작업을 수행하는 프로그램을 작성하기.
    *카드는 TXY 꼴로 표현되며, T는 카드의 무늬(S, D, H, C)이며 XY는 카드의 숫자 (01 ~ 13)이다.
    *문자열 S를 보고 지금 무늬 별로(S, D, H, C 순서로) 몇 장의 카드가 부족한지 출력.
    *이미 겹치는 카드가 있다면 문자열 “ERROR”
 */

public class Solution_swea4047 {            //영준이의 카드 카운팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            List<Integer> S = new ArrayList<>();
            List<Integer> D = new ArrayList<>();
            List<Integer> H = new ArrayList<>();
            List<Integer> C = new ArrayList<>();
            boolean flag = true;

            for(int i = 0; i < str.length(); i+=3){
                char c = str.charAt(i);
                int n = Integer.parseInt(str.substring(i+1, i+3));

                if(c == 'S'){
                    if(!S.contains(n)) {
                        S.add(n);
                    } else{
                        flag = false;
                        break;
                    }
                } else if(c == 'D'){
                    if(!D.contains(n)) {
                        D.add(n);
                    } else{
                        flag = false;
                        break;
                    }
                } else if(c == 'H'){
                    if(!H.contains(n)) {
                        H.add(n);
                    } else{
                        flag = false;
                        break;
                    }
                } else if(c == 'C'){
                    if(!C.contains(n)) {
                        C.add(n);
                    } else{
                        flag = false;
                        break;
                    }
                }
            }

            sb.append("#").append(t);
            if(flag) {
                sb.append(" ").append(13-S.size())
                        .append(" ").append(13-D.size())
                        .append(" ").append(13-H.size())
                        .append(" ").append(13-C.size())
                        .append("\n");
            }
            else{
                sb.append(" ").append("ERROR").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
