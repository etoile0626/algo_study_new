package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    준환이는 적절한 몸을 유지하기 위하여 1주일에 L분 이상 U분 이하의 운동을 하여야 한다.
    준환이는 이번 주에 X분만큼 운동을 하였다.
    준환이가 제한되어 있는 시간을 넘은 운동을 한 것인지, 그것이 아니라면 몇 분 더 운동을 해야 제한을 맞출 수 있는지 출력하기.
    *필요한 양보다 더 많은 운동을 하고 있다면 -1을 출력하고, 아니라면 추가로 몇 분을 더 운동해야 하는지 출력.
 */

public class Solution_swea3431 {                            //준환이의 운동관리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int time = 0;

            if(x < l){
                time = l - x;
            } else if(x > u){
                time = -1;
            }

            sb.append("#").append(t).append(" ").append(time).append("\n");
        }

        System.out.println(sb.toString());
    }
}
