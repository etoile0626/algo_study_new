package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    D 킬로미터 길이의 고속도로를 지나는 중, 지름길이 존재함을 발견함.
    모든 지름길은 일방통행, 고속도로를 역주행할 수는 없음.
    운전하는 거리의 최솟값 구하기
    * 0 <= 지름길 갯수 n <= 12, 0 < D <= 10000, 모든 위치와 길이는 10000 아래의 음이 아닌 정수
 */

public class Main_BJ1446 {                              //지름길

    public static class ShortCut{                       //지름길 정보 저장을 위한 클래스
        int start;
        int end;
        int dis;

        public ShortCut(int start, int end, int dis){
            this.start = start;
            this.end = end;
            this.dis = dis;
        }
    }

    static int n, d;
    static int[] dp;
    static ShortCut[] shortCuts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dp = new int[d+1];
        for(int i = 1; i <= d; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        shortCuts = new ShortCut[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());                           //지름길 시작 위치
            int end = Integer.parseInt(st.nextToken());                             //지름길 종료 위치
            int dis = Integer.parseInt(st.nextToken());                             //지름길 길이

            shortCuts[i] = new ShortCut(start, end, dis);
        }

        Arrays.sort(shortCuts, Comparator.comparingInt(sc -> sc.start));        //시작 위치 기준으로 오름차순 정렬

        int idx = 0;                                                                //지름길 인덱스
        for(int i = 0; i < d; i++){
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);                             //그냥 앞으로 한 칸 가기

            while (idx < n && shortCuts[idx].start == i){                           //해당 위치에 지름길이 있으면 반복문 실행
                int s = shortCuts[idx].start;
                int e = shortCuts[idx].end;
                int dis = shortCuts[idx].dis;

                if(e <= d && dis < e - s){                                          //지름길을 타는게 더 빠르다면 지름길을 타기
                    dp[e] = Math.min(dp[e], dp[i] + dis);
                }
                idx++;                                                              //지름길을 타든 안타든 더 빠른 길을 찾았으므로 다음 지름길을 탐색
            }
        }

        System.out.println(dp[d]);
    }
}
