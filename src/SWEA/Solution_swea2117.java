package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N*N 크기의 도시에 홈방범 서비스를 제공하려고 함.
    운영 비용은 서비스 영역의 면적과 동일하며, 아래와 같이 구할 수 있다.
    운영 비용 = 서비스 면적 = K * K + (K - 1) * (K - 1) -> 마름모 꼴 모양, 그림 참고
    *(k >= 1)
    *도시를 벗어난 영역에 서비스를 제공해도 운영 비용은 변경되지 않음.
    집들은 각각 M의 비용을 지불할 수 있어, 보안회사에서는 손해를 보지 않는 한 최대한 많은 집에 홈방범 서비스를 제공하려고 함.
    손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고,
    그 때의 홈방범 서비스를 제공 받는 집들의 수를 구하기.
    * 0 = 빈공간 / 1 = 집
 */

public class Solution_swea2117 {                                //[모의 SW 역량테스트] 홈 방범 서비스
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int cnt = 0;                                            //최대일때 집 수

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int k = 1; k <= n+1; k++){
                int bill = k * k + (k-1) * (k-1);                   //운영 비용

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){                     //중심 좌표
                        int house = 0;

                        for(int x = 0; x < n; x++){
                            for(int y = 0; y < n; y++){             //중심좌표 주변 마름모 확인
                                //맨허튼 거리 측정(마름모)
                                if(Math.abs(i - x) + Math.abs(j - y) < k && arr[x][y] == 1){
                                    house++;
                                }
                            }
                        }

                        //이익이 있는지 확인
                        if(house * m >= bill){
                            cnt = Math.max(cnt, house);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
