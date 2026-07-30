package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    0~9로 이루어진 번호 문자열에서 같은 번호로 붙어있는 쌍들을 소거하고 남은 번호를 비밀번호로 만들고자 함.
    번호 쌍이 소거되고 소거된 번호 쌍의 좌우 번호가 같은 번호이면 또 소거 할 수 있습니다.
 */

public class Solution_swea1234 {                        //[S/W 문제해결 기본] 10일차 - 비밀번호
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){

            sb.append("#").append(t).append(" ").append().append("\n");
        }

        System.out.println(sb.toString());
    }
}
