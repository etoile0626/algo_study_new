package SWEA;

/*
    가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.
    A와 B중에 누가 이겼는지 판별해보자. 단, 비기는 경우는 없다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1936 {                    //1 대 1 가위바위보
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a < b){
            if(a == 1 && b == 3) {
                System.out.println("A");
            }
            else {
                System.out.println("B");
            }
        } else {
            if (a == 3 && b == 1) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }
    }
}
