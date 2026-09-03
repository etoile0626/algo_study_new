package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    24시간이다. 24시간제 시계에서는 하루가 자정에서 시작해서 다음 날 자정에서 끝나며, 자정에서부터 지금까지 흐른 시간을 기준으로 시각을 표기한다.
    ex)지금이 오후 8시라면 “20시”와 같은 꼴로 표현할 수 있다. 자정을 표기하는 유일한 방법은 “0시”임에 유의하라.
    지금은 자정에서부터 정확히 A시간이 지났다. 앞으로 정확히 B시간이 더 지난다면, 24시간제 시계에서 그 때는 몇 시일까?
 */

public class Solution_swea12368 {                               //24시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("#").append(t).append(" ").append((a+b)%24).append("\n");
        }

        System.out.println(sb.toString());
    }
}
