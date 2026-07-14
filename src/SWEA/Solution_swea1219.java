package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    A도시에서 출발하여 B도시로 가는 길이 존재하는지 조사하려고 한다.
    길 중간 중간에는 최대 2개의 갈림길이 존재하고, 모든 길은 일방 통행으로 되돌아오는 것이 불가능하다.
    다음과 같이 길이 주어질 때, A도시에서 B도시로 가는 길이 존재하는지 구하기.
    *A와 B는 숫자 0과 99으로 고정
    *가는 길의 개수와 상관없이 한가지 길이라도 존재하면 됨.
    *한 개의 정점에서 선택할 수 있는 길의 개수도 2개를 넘어가지 않는다.
    *가능할 경우 1, 불가능할 경우 0을 출력한다.
 */

public class Solution_swea1219 {                            //[S/W 문제해결 기본] 4일차 - 길찾기
    static int[] left, right;
    static boolean[] visit;

    private static int dfs(int start){
        if(start == 99){
            return 1;
        }

        if (visit[start]){
            return 0;
        }

        visit[start] = true;

        if(left[start] != 0){
            int flag = dfs(left[start]);

            if(flag == 1){
                return 1;
            }
        }

        if(right[start] != 0){
            int flag = dfs(right[start]);

            if(flag == 1){
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T <= 10; T++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            left = new int[100];
            right = new int[100];
            visit = new boolean[100];
            int flag = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if(left[start] == 0){
                    left[start] = end;
                } else {
                    right[start] = end;
                }
            }

            flag = dfs(0);

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}
