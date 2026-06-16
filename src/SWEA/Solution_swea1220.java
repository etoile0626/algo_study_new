package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    푸른 자성체의 경우 N극에 이끌리는 성질을 가지고 있고, 붉은 자성체의 경우 S극에 이끌림.
    *테이블의 위쪽에 N극, 테이블의 아래쪽에 S극이 존재.
    시간이 흐른 뒤에 자성체들이 서로 충돌하여 테이블 위에 남아있는 교착 상태의 개수를 구하기.
    *한 쪽 방향으로 움직이는 자성체의 개수가 많더라도 반대 방향으로 움직이는 자성체가 하나라도 있으면 교착 상태에 빠져 움직이지 않는다.
    *좌우로 인접한 경우는 각각 다른 교착 상태로 판단하여 2개의 교착 상태로 판정.
    *한 줄에 두 개 이상의 교착 상태가 발생할 수도 있다.
    **자성체는 테이블 앞뒤 쪽에 있는 N극 또는 S극에만 반응하며 자성체끼리는 전혀 반응하지 않는다.
    *테이블의 크기는 100x100, 1은 N극 2는 S극
 */

public class Solution_swea1220 {                            //[S/W 문제해결 기본] 5일차 - Magnetic
    //다시풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());                //n=100
            int[][] arr = new int[n][n];
            int cnt = 0;                                            //deadlock개수

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < n; i++){
                int tmp = 0;                        //직전 탐색값이 뭐였는지 저장하는 변수

                for(int j = 0; j < n; j++){
                    if(arr[j][i] == 1){
                        tmp = 1;
                    } else if (arr[j][i] == 2) {
                        if(tmp == 1){
                            cnt++;                              //1이후 2가 나옴 -> 무조건 부딪혀 교착상태 생성
                        }

                        tmp = 2;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
