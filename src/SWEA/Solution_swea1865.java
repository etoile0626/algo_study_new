package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    직원들의 번호가 1부터 N까지 매겨져 있고, 해야 할 일에도 번호가 1부터 N까지 매겨져 있을 때, i번 직원이 j번 일을 하면 성공할 확률이 Pi, j이다.
    여기서 우리는 동철이가 모든 일이 잘 풀리도록 도와주어야 한다.
    직원들에게 해야 할 일을 하나씩 배분하는 방법은 여러 가지다.
    우리는 여러 방법 중에서 생길 수 있는 “주어진 일이 모두 성공할 확률”의 최댓값을 구하기.
    *Pi, j는 i번 사람이 j번 일을 성공할 확률을 퍼센트 단위로
    *모든 일을 성공할 확률이 최대화될 때의 확률을 퍼센트 단위로 소수점 아래 7번째 자리에서 반올림하여 6번째까지 출력.
    ex)1-1, 2-2, 3-3으로 매칭될 때 모든 일을 성공할 확률이 최대가 된다면 그 확률은 (0.13*0.7*1.0)*100 = 9.1%
 */

public class Solution_swea1865 {                            //동철이의 일 분배
    //다시풀기, dfs, dp모두 다시 해보기
    static int n;
    static double max;
    static double[][] arr;
    static boolean[] visit;

    private static void dfs(int num, double prob){
        //현재값이 최댓값보다 작으면 그대로 종료
        if(prob <= max){
            return;
        }

        //끝까지 도달하면 최댓값 갱신
        if(num == n){
            max = Math.max(max, prob);
            return;
        }

        for(int i = 0; i < n; i++){
            //이미 선택한 노동자면 패스
            if(visit[i]){
                continue;
            }

            //확률이 0 이면 무조건 최솟값이므로 패스
            if(arr[num][i] == 0){
                continue;
            }

            visit[i] = true;
            dfs(num+1, prob * arr[num][i]);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            max = 0;
            arr = new double[n][n];
            visit = new boolean[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Double.parseDouble(st.nextToken()) / 100;
                }
            }

            dfs(0, 1.0);

            sb.append("#").append(t).append(" ").append(String.format("%.6f", max * 100)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
