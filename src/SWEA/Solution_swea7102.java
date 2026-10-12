package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    번 카드부터 N번 카드, 1번 카드부터 M번 카드로 구성되어 있다.
    심심했던 준홍이는 각 카드 세트에서 카드 한 장씩을 골랐다.
    그리고 각 카드에 적힌 숫자를 더해보았다.
    1번 카드와 1번 카드를 골랐다면 카드에 적힌 숫자의 합은 2가 될 것이고, N번 카드와 M번 카드를 골랐다면 카드에 적힌 숫자의 합은 N+M이 될 것이다.
    문득 준홍이는 각 카드 세트에서 카드를 한 장씩 골라서 카드에 적힌 숫자를 합한 결과 중, 등장할 확률이 가장 높은 숫자 구하기.
 */

public class Solution_swea7102 {                            //준홍이의 카드놀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    map.put(i+j, map.getOrDefault(i+j, 0)+1);
                }
            }

            StringBuilder answer = new StringBuilder();
            int max = Collections.max(map.values());
            for(int tmp : map.keySet()){
                if(map.get(tmp) == max){
                    answer.append(" ").append(tmp);
                }
            }

            sb.append("#").append(t).append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
