package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N개의 숫자가 적혀 있는 게임 판이 있고, +, -, x, / 의 연산자 카드를 숫자 사이에 끼워 넣어 다양한 결과 값을 구해보기로 했다.
    연산자의 우선 순위는 고려하지 않고 왼쪽에서 오른쪽으로 차례대로 계산한다.
    수식을 계산했을 때 그 결과가 최대가 되는 수식과 최소가 되는 수식을 찾고, 두 값의 차이를 출력하기.
 */

public class Solution_swea4008 {                        //[모의 SW 역량테스트] 숫자 만들기
    static int n, max, min;
    static int[] oper, arr;

    private static void dfs(int cnt, int num){
        if(cnt == n){
            max = Integer.max(max, num);
            min = Integer.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(oper[i] < 1) {
                continue;
            }

            oper[i]--;

            if(i == 0){
                dfs(cnt+1, num + arr[cnt]);
            } else if(i == 1){
                dfs(cnt+1, num - arr[cnt]);
            } else if(i == 2){
                dfs(cnt+1, num * arr[cnt]);
            } else if(i == 3){
                dfs(cnt+1, num / arr[cnt]);
            }

            oper[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            oper = new int[4];            // 0=+, 1=-, 2=*, 3-/
            arr = new int[n];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                oper[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, arr[0]);

            sb.append("#").append(t).append(" ").append(max-min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
