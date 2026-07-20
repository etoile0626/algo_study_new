package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
     N명의 점원들이 높이가 B인 선반에 올려놓은 물건을 사용해야 하는 일이 생겼다.
     점원의 키는 Hi로 나타나는데, 점원들은 탑을 쌓아서 선반 위의 물건을 사용.
     탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합.
     탑의 높이가 B 이상인 경우 선반 위의 물건을 사용, 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 구하기.
     만들 수 있는 높이가 B 이상인 탑 중에서 '탑의 높이와 B의 차이가 가장 작은 것'을 출력하기!
 */

public class Solution_swea1486 {                            //장훈이의 높은 선반
    static int n, b, min;
    static int[] arr;

    private static void dfs(int cnt, int h){
        if(h >= b){
            min = Math.min(min, h);
            return;
        }

        for(int i = cnt; i < n; i++){
            dfs(i + 1, h + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new int[n];
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            int diff = min - b;
            sb.append("#").append(t).append(" ").append(diff).append("\n");
        }

        System.out.println(sb.toString());
    }
}
