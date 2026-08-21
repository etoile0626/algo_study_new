package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    어떤 물체가 n개의 자성체들이 위치한 직선의 임의의 위치에 존재하면 각 자성체로부터 인력이 작용한다.
    자성체에서 물체에 작용하는 인력은 자성체와 물체 사이의 거리(d)와 자성체와 물체의 질량(m)으로 구한다.
    *자성체로부터 물체에 작용하는 인력을 구하는 공식: F = G*m1*m2/(d*d), G는 양의 상수 값 -> F' = m1 / (d*d)
    물체의 왼쪽에 있는 자성체들의 인력과 오른쪽의 자성체들의 인력들에서 더 큰 쪽으로 물체가 이동할 것이다.
    양쪽의 힘이 같은 지점에 물체가 있다면 물체는 움직이지 않고 정지 상태가 된다.
    >>>물체에 작용하는 양쪽이 힘이 같은 지점을 찾기.<<<
    *같은 줄에 빈 칸을 하나 사이에 두고 균형점들의 x좌표 값 출력, 좌표 값이 소수점 이하 10자리 이상이면 10자리까지만 출력
    *n개의 자성체가 있다면 n-1개의 균형점이 존재
    *좌표값의 오차가 10 -12(1e-12) 보다는 작아야 함에 주의 -> 소수점 12자리 이하는 보지 않음?1
 */

public class Solution_swea1245 {                        //[S/W 문제해결 응용] 2일차 - 균형점
    //문제가 어렵넹...다시 풀기

    static int n;
    static int[][] arr;

    private static double force(double x){
        double left = 0;
        double right = 0;

        for(int i = 0; i < n; i++){
            double dist = Math.abs(x - arr[i][0]);
            double f = arr[i][1] / (dist * dist);

            if(arr[i][0] < x){
                left += f;
            } else {
                right += f;
            }
        }

        return left - right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            double[] answer = new double[n-1];

            st = new StringTokenizer(br.readLine());
            //x좌표
            for(int i = 0; i < n; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
            }

            //질량값
            for(int i = 0; i < n; i++){
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n - 1; i++) {
                double low = arr[i][0];
                double high = arr[i + 1][0];

                while (high - low > 1e-13) {
                    double mid = (low + high) / 2.0;

                    if (mid == low || mid == high) {
                        break; // double 정밀도 한계로 더 이상 구간을 줄일 수 없음
                    }

                    if (force(mid) > 0) {
                        low = mid;      // 왼쪽 힘이 더 크므로 오른쪽 탐색
                    } else {
                        high = mid;
                    }
                }

                answer[i] = (low + high) / 2.0;
            }

            //출력
            sb.append("#").append(t);
            for(int i = 0; i < n-1; i++){
                sb.append(String.format(" %.10f", answer[i]));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
