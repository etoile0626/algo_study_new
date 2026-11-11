package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    한 복도에는 1 이상 100 이하의 정수로 구분되는 100개의 버튼이 존재한다.
    버튼 K는 복도의 시작점에서 K미터 떨어져 있다. 두 로봇은 버튼 1에서 시작한다.
    매 1초마다, 로봇은 복도의 양 방향 중 하나로 1미터 걷거나, 자기 위치에 있는 버튼을 누르거나, 아무 것도 하지 않는다.
    *오렌지와 블루는 서로 다른 복도에 있음
    버튼은 O x, B x와 같은 형태로 주어지는데, O x는 오렌지가 해당 버튼을 눌러야 함을 뜻하고, B x는 블루가 해당 버튼을 눌러야 함을 뜻한다.
    순서대로 버튼을 눌러야 하기 때문에, 두 로봇이 동시에 버튼을 누를 수는 없다. 두 로봇 모두 수열을 정확히 알고 있다.
    악마는 테스트가 끝나면 두 로봇에게 케이크를 주기로 약속했다.
    테스트를 끝낼 수 있는 가장 빠른 시간은 언제인가?
 */

public class Solution_swea10761 {                       //신뢰
    //다시 풀기, 하나가 버튼을 누르는 동안 다른 로봇도 미리 이동할 수 있음을 염두해두기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int o = 1;                                      //오렌지의 위치
            int b = 1;                                      //블루의 위치
            int o_time = 0;                                 //오렌지가 마지막으로 버튼을 누른 시각
            int b_time = 0;                                 //블루가 마지막으로 버튼을 누른 시각
            int time = 0;                                      //전체 시간

            for(int i = 0; i < n; i++){
                String order = st.nextToken();
                int button = Integer.parseInt(st.nextToken());

                if(order.equals("O")){                              //오렌지의 차례
                    int arrive = o_time + Math.abs(button - o);     //오렌지가 버튼에 도달한 시각
                    time = Math.max(arrive, time) + 1;              //이전 버튼이 눌린시각보다는 이후에 누르도록 max로 비교
                    o = button;
                    o_time = time;
                } else{                                             //블루의 차례
                    int arrive = b_time + Math.abs(button - b);     //블루가 버튼에 도달한 시각
                    time = Math.max(arrive, time) + 1;              //이전 버튼이 눌린시각보다는 이후에 누르도록 max로 비교
                    b = button;
                    b_time = time;
                }
            }


            sb.append("#").append(t).append(" ").append(time).append("\n");
        }

        System.out.println(sb.toString());
    }
}
