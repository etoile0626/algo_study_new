package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  · 일요일에 교환학생을 위한 수업이 열리면 a1 = 1, 아니면 0
  월요일에 교환학생을 위한 수업이 열리면 a2 = 1, 아니면 0
  · …
  · 토요일에 교환학생을 위한 수업이 열리면 a7 = 1, 아니면 0

  수업이 어떠한 요일에도 열리지 않는 경우는 없다고 가정해도 된다.
  당신은 삼성대학교에서 교환학생으로 n일 동안 수업을 들으려고 한다.
  목표를 이루기 위해 삼성대학교에 지내야 하는 최소 일수 구하기.
 */

public class Solution_swea13038 {                           //교환학생
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[7];
            st = new StringTokenizer(br.readLine());

            int k = 0;                                      //일주일 수업 수
            for(int i = 0; i < 7; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                k += arr[i];
            }

            int full = (n - 1) / k;                         //수업을 들어야하는 주 수 (마지막 주 제외)
            int r = (n - 1) % k + 1;                        //마지막 주에 들어야 할 수업 수

            long best = Long.MAX_VALUE;
            for(int i = 0; i < 7; i++){
                if(arr[i] == 0) {
                    continue;                   //수업 있는 날에 시작해야 최소
                }

                int cnt = 0;                    //마지막 주에 수업 들은 횟수
                int days = 0;                   //마지막 주, i요일부터 시작해서 지나간 총 날짜
                while(cnt < r){
                    if(arr[(i + days) % 7] == 1){
                        cnt++;
                    }

                    days++;
                }

                best = Math.min(best, (long) full * 7 + days);
            }

            sb.append("#").append(t).append(" ").append(best).append("\n");
        }

        System.out.println(sb.toString());
    }
}
