package SWEA;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
    I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
    위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하기.
 */

public class Solution_swea1228 {                    //[S/W 문제해결 기본] 8일차 - 암호문1
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = sc.nextInt();                //원본 문자열 길이
            List<Integer> list = new LinkedList<>();

            for(int i = 0; i < n; i++){
                list.add(sc.nextInt());
            }

            int command = sc.nextInt();                         //명령어 개수
            for(int i = 0; i < command; i++){
                sc.next();                                      //I
                int pos = sc.nextInt();
                int count = sc.nextInt();

                for(int j = 0; j < count; j++){
                    list.add(pos + j, sc.nextInt());
                }
            }

            sb.append("#").append(t).append(" ");
            for(int i = 0; i < 10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
