package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N * N 크기의 절벽지대에 활주로를 건설하려고 한다.
    각 셀의 숫자는 그 지형의 높이를 의미.
    사로는 길이가 X 이고, 높이는 1 이다.
    경사로는 높이 차이가 1 이고 낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치가능
    경사로의 길이 X 와 절벽지대의 높이 정보가 주어질 때,
    활주로를 건설할 수 있는 경우의 수를 계산하기.
 */

public class Solution_swea4014 {                            //[모의 SW 역량테스트] 활주로 건설
    //다시 풀기

    static int n , x;
    private static boolean isPossible(int[] arr){
        boolean[] visit = new boolean[n];               //어느칸에 경사로 깔았는지

        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) > 1) {
                return false;
            }

            if (diff == 1) {
                // 오르막: i부터 왼쪽 X칸 검사
                for(int j = i; j > i - x; j--){
                    if(j < 0 || arr[j] != arr[i] || visit[j]){
                        return false;
                    }

                    visit[j] = true;
                }
            } else {
                // 내리막: i + 1부터 오른쪽 X칸 검사
                for(int j = i+1; j < i + x + 1; j++){
                    if(j >= n || arr[j] != arr[i+1] || visit[j]){
                        return false;
                    }

                    visit[j] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int cnt = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < n; i++){
                //가로줄
                if(isPossible(arr[i])){
                    cnt++;
                }

                //세로줄
                int[] column = new int[n];

                for (int j = 0; j < n; j++) {
                    column[j] = arr[j][i];
                }

                if (isPossible(column)) {
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
