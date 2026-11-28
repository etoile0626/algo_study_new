package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
    숫자는 다양성을 가지고 있다. 다양성이란, 숫자를 구성하는 수의 종류를 의미한다.
    예를 들어서 1512 라는 숫자는 ‘1’, ‘5’, ‘2’로 구성되어 있기 때문에 다양성이 3이다.
    숫자가 주어졌을 때 그 숫자의 다양성을 구하기.
 */

public class Solution_swea7728 {                                //다양성 측정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            Set<Character> set = new HashSet<>();

            for(int i = 0; i < str.length(); i++){
                set.add(str.charAt(i));
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
