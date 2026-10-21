package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    숫자게임을 좋아하는 새샘이는 서로 다른 7개의 정수 중에서 3개의 정수를 골라 합을 구해서 수를 만들려고 한다.
    이렇게 만들 수 있는 수 중에서 5번째로 큰 수를 출력하는 프로그램을 작성하라.
 */

public class Solution_swea5948 {                    //새샘이의 7-3-5 게임
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];

            for(int i = 0; i < 7; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //완전 탐색
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < 7; i++){
                for(int j = i+1; j < 7; j++){
                    for(int k = j+1; k < 7; k++){
                        set.add(arr[i] + arr[j] + arr[k]);
                    }
                }
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());

            sb.append("#").append(t).append(" ").append(list.get(4)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
